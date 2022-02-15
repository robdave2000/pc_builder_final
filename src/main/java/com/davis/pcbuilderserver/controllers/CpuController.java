package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.CpuDto;
import com.davis.pcbuilderserver.services.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cpu")
public class CpuController {
    @Autowired
    CpuService cpuService;

    @GetMapping
    public List<CpuDto> getAllCpus()
    {
        return cpuService.getAllCpus();
    }

    @GetMapping("/")
    public List<CpuDto> getCpusByQuery(@RequestParam Map<String, String> params){
        if (params.containsKey("brand")){
            return cpuService.getCpusByBrand(params.get("brand"));
        }
        if (params.containsKey("search")){
            return cpuService.getAllCpusBySearch(params.get("search"), params.get("search"), params.get("search"));
        }
        return Collections.emptyList();
    }

    @PostMapping("/{cpuId}/{pcId}")
    public String addCpuToPc(@PathVariable Long cpuId,@PathVariable Long pcId)
    {
        return cpuService.addCpuToPc(cpuId, pcId);
    }

    @GetMapping("/{cpuId}")
    public Optional<CpuDto> getCpuById(@PathVariable Long cpuId)
    {
        return cpuService.getCpuById(cpuId);
    }
}
