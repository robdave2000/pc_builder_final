package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.PcDto;
import com.davis.pcbuilderserver.dtos.UserDto;
import com.davis.pcbuilderserver.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserServices userServices;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public List<String> registerUser(@RequestBody UserDto userDto)
    {
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        return userServices.addUser(userDto);
    }

    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto)
    {
        return userServices.userLogin(userDto);
    }

    @PostMapping("/{userId}/{pcId}")
    public String addPcToUser(@PathVariable Long userId, @PathVariable Long pcId)
    {
        return userServices.addPcToUser(userId, pcId);
    }

    @GetMapping("/{userId}")
    public List<PcDto> getPcsByUser(@PathVariable Long userId)
    {
        return userServices.getPcsByUser(userId);
    }
}
