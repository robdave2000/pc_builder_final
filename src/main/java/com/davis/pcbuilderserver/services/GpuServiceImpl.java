package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.GpuDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.entities.Gpu;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.repository.GpuRepository;
import com.davis.pcbuilderserver.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GpuServiceImpl implements GpuService{
    @Autowired
    GpuRepository gpuRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<GpuDto> getGpuById(Long gpuId)
    {
        Optional<Gpu> optionalGpu = gpuRepository.findById(gpuId);
        if (optionalGpu.isPresent())
        {
            return Optional.of(new GpuDto(optionalGpu.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addGpuToPc(Long gpuId, Long pcId) {
        Optional<Gpu> gpuOptional = gpuRepository.findById(gpuId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (gpuOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setGpu(new GpuDto(gpuOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Gpu added";
        }
        return "Gpu not added";
    }

    @Override
    public List<GpuDto> getAllGpus() {
        List<Gpu> gpuList = gpuRepository.findAll();
        return gpuList.stream().map(gpu-> new GpuDto(gpu)).collect(Collectors.toList());
    }
}
