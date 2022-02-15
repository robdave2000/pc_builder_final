package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.GpuDto;
import com.davis.pcbuilderserver.dtos.PsuDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.entities.Gpu;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.entities.Psu;
import com.davis.pcbuilderserver.repository.PcRepository;
import com.davis.pcbuilderserver.repository.PsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PsuServiceImpl implements PsuService{
    @Autowired
    PsuRepository psuRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<PsuDto> getPsuById(Long psuId)
    {
        Optional<Psu> optionalPsu = psuRepository.findById(psuId);
        if (optionalPsu.isPresent())
        {
            return Optional.of(new PsuDto(optionalPsu.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addPsuToPc(Long psuId, Long pcId) {
        Optional<Psu> psuOptional = psuRepository.findById(psuId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (psuOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setPsu(new PsuDto(psuOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Psu added";
        }
        return "Psu not added";
    }

    @Override
    public List<PsuDto> getAllPsus() {
        List<Psu> psuList = psuRepository.findAll();
        return psuList.stream().map(psu-> new PsuDto(psu)).collect(Collectors.toList());
    }
}
