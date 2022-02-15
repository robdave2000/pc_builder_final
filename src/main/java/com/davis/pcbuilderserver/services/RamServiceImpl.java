package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.PsuDto;
import com.davis.pcbuilderserver.dtos.RamDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.entities.Psu;
import com.davis.pcbuilderserver.entities.Ram;
import com.davis.pcbuilderserver.repository.PcRepository;
import com.davis.pcbuilderserver.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RamServiceImpl implements RamService{
    @Autowired
    RamRepository ramRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<RamDto> getRamById(Long ramId)
    {
        Optional<Ram> optionalRam = ramRepository.findById(ramId);
        if (optionalRam.isPresent())
        {
            return Optional.of(new RamDto(optionalRam.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addRamToPc(Long ramId, Long pcId) {
        Optional<Ram> ramOptional = ramRepository.findById(ramId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (ramOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setRam(new RamDto(ramOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Ram added";
        }
        return "Ram not added";
    }

    @Override
    public List<RamDto> getAllRam() {
        List<Ram> ramList = ramRepository.findAll();
        return ramList.stream().map(ram-> new RamDto(ram)).collect(Collectors.toList());
    }
}
