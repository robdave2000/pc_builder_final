package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.CpuDto;
import com.davis.pcbuilderserver.entities.Cpu;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.repository.CpuRepository;
import com.davis.pcbuilderserver.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CpuServiceImpl implements CpuService{
    @Autowired
    CpuRepository cpuRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<CpuDto> getCpuById(Long cpuId)
    {
        Optional<Cpu> optionalCpu = cpuRepository.findById(cpuId);
        if (optionalCpu.isPresent())
        {
            return Optional.of(new CpuDto(optionalCpu.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addCpuToPc(Long cpuId, Long pcId) {
        Optional<Cpu> cpuOptional = cpuRepository.findById(cpuId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (cpuOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setCpu(new CpuDto(cpuOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Cpu added";
        }
        return "Cpu not added";
    }

    @Override
    public List<CpuDto> getCpusByBrand(String brand) {
        List<Cpu> cpuList = cpuRepository.findCpusByBrand(brand);
        return cpuList.stream().map(cpu -> new CpuDto(cpu)).collect(Collectors.toList());
    }

    @Override
    public List<CpuDto> getAllCpusBySearch(String brand, String name, String level) {
        List<Cpu> cpuList = cpuRepository.findCpusByBrandOrNameOrLevelContains(brand, name, level);
        return cpuList.stream().map(cpu -> new CpuDto(cpu)).collect(Collectors.toList());
    }

    @Override
    public List<CpuDto> getAllCpus() {
        List<Cpu> cpuList = cpuRepository.findAll();
        return cpuList.stream().map(cpu -> new CpuDto(cpu)).collect(Collectors.toList());
    }
}
