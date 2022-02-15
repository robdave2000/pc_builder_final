package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.RamDto;
import com.davis.pcbuilderserver.services.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rams")
public class RamController {
    @Autowired
    RamService ramService;

    @PostMapping("/{ramId}/{pcId}")
    public String addRamToPc(@PathVariable Long ramId,@PathVariable Long pcId)
    {
        return ramService.addRamToPc(ramId, pcId);
    }

    @GetMapping
    public List<RamDto> getAllRam()
    {
        return ramService.getAllRam();
    }

    @GetMapping("/{ramId}")
    public Optional<RamDto> getRamById(@PathVariable Long ramId) {return ramService.getRamById(ramId);}
}
