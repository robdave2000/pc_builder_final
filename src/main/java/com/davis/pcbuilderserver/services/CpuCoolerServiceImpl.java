package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.CpuCoolerDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.entities.CpuCooler;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.repository.CpuCoolerRepository;
import com.davis.pcbuilderserver.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CpuCoolerServiceImpl implements CpuCoolerService {
    @Autowired
    CpuCoolerRepository cpuCoolerRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<CpuCoolerDto> getCpuCoolerById(Long cpuCoolerId)
    {
        Optional<CpuCooler> optionalCpuCooler = cpuCoolerRepository.findById(cpuCoolerId);
        if (optionalCpuCooler.isPresent())
        {
            return Optional.of(new CpuCoolerDto(optionalCpuCooler.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addCpuCoolerToPc(Long cpuCoolerId, Long pcId) {
        Optional<CpuCooler> cpuCoolerOptional = cpuCoolerRepository.findById(cpuCoolerId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (cpuCoolerOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setCpuCooler(new CpuCoolerDto(cpuCoolerOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Cpu Cooler added";
        }
        return "Cpu Cooler not added";
    }

    @Override
    public List<CpuCoolerDto> getAllCpuCoolers() {
        List<CpuCooler> cpuCoolerList = cpuCoolerRepository.findAll();
        return cpuCoolerList.stream().map(cpuCooler-> new CpuCoolerDto(cpuCooler)).collect(Collectors.toList());
    }
}
