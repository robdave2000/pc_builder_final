package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.CpuCoolerDto;
import com.davis.pcbuilderserver.services.CpuCoolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cpucoolers")
public class CpuCoolerController {
    @Autowired
    CpuCoolerService cpuCoolerService;

    @GetMapping
    public List<CpuCoolerDto> getAllCpuCoolers()
    {
        return cpuCoolerService.getAllCpuCoolers();
    }

    @PostMapping("/{cpuCoolerId}/{pcId}")
    public String addCpuCoolerToPc(@PathVariable Long cpuCoolerId,@PathVariable Long pcId)
    {
        return cpuCoolerService.addCpuCoolerToPc(cpuCoolerId, pcId);
    }

    @GetMapping("/{cpuCoolerId}")
    public Optional<CpuCoolerDto> getCpuCoolerId(@PathVariable Long cpuCoolerId){return cpuCoolerService.getCpuCoolerById(cpuCoolerId);}
}
