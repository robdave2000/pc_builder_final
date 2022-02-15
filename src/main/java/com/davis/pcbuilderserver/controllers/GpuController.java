package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.GpuDto;
import com.davis.pcbuilderserver.services.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gpus")
public class GpuController {
    @Autowired
    GpuService gpuService;

    @PostMapping("/{gpuId}/{pcId}")
    public String addGpuToPc(@PathVariable Long gpuId,@PathVariable Long pcId)
    {
        return gpuService.addGpuToPc(gpuId, pcId);
    }

    @GetMapping("/{gpuId}")
    public Optional<GpuDto> getGpuById(@PathVariable Long gpuId) {return gpuService.getGpuById(gpuId);}

    @GetMapping
    public List<GpuDto> getAllGpus()
    {
        return gpuService.getAllGpus();
    }
}
