package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.PcDto;
import com.davis.pcbuilderserver.dtos.UserDto;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.entities.User;
import com.davis.pcbuilderserver.repository.PcRepository;
import com.davis.pcbuilderserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PcRepository pcRepository;

    @Override
    public List<String> addUser(UserDto userDto)
    {
        List<String> responce = new ArrayList<>();
        User user = new User(userDto);
        Pc pc = new Pc();
        pcRepository.saveAndFlush(pc);
        user.addPcToUser(pc);
        userRepository.saveAndFlush(user);
        responce.add("http://localhost:8080/login.html");
        return responce;
    }

    @Override
    public List<String> userLogin(UserDto userDto)
    {
        List<String> responce = new ArrayList<>();
        Optional<User> userOptional = userRepository.findUserByUsername(userDto.getUsername());
        if (userOptional.isPresent())
        {
            if (passwordEncoder.matches(userDto.getPassword(),userOptional.get().getPassword()))
            {
                responce.add("http://localhost:8080/home.html");
                responce.add(String.valueOf(userOptional.get().getId()));
            }
            else
            {
                responce.add("Not logged in");
            }
        }
        else
        {
            responce.add("User not found");
        }

        return responce;
    }

    @Override
    public String addPcToUser(Long userId, Long pcId)
    {
        Optional<Pc> pcOptional = pcRepository.findById(pcId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (pcOptional.isPresent() && userOptional.isPresent())
        {
            userOptional.get().addPcToUser(pcOptional.get());
            userRepository.saveAndFlush(userOptional.get());
            return "Pc added successfully to user";
        }

        return "Unable to process";
    }

    @Override
    public List<PcDto> getPcsByUser(Long userId)
    {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent())
        {
            List<Pc> pcList = pcRepository.findPcByUserSetContaining(userOptional.get());
            return pcList.stream().map(pc -> new PcDto(pc)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
