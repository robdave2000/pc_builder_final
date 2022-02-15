package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.GpuDto;
import com.davis.pcbuilderserver.dtos.MotherboardDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.entities.Gpu;
import com.davis.pcbuilderserver.entities.Motherboard;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.repository.MotherboardRepository;
import com.davis.pcbuilderserver.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MotherboardServiceImpl implements MotherboardService{
    @Autowired
    MotherboardRepository motherboardRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<MotherboardDto> getMotherboardById(Long motherboardId)
    {
        Optional<Motherboard> optionalMotherboard = motherboardRepository.findById(motherboardId);
        if (optionalMotherboard.isPresent())
        {
            return Optional.of(new MotherboardDto(optionalMotherboard.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addMotherboardToPc(Long motherboardId, Long pcId) {
        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(motherboardId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (motherboardOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setMotherboard(new MotherboardDto(motherboardOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Motherboard added";
        }
        return "Motherboard not added";
    }

    @Override
    public List<MotherboardDto> getAllMotherboards() {
        List<Motherboard> motherboardList = motherboardRepository.findAll();
        return motherboardList.stream().map(motherboard-> new MotherboardDto(motherboard)).collect(Collectors.toList());
    }
}
