package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.MotherboardDto;
import com.davis.pcbuilderserver.services.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/motherboards")
public class MotherboardController {
    @Autowired
    MotherboardService motherboardService;

    @PostMapping("/{motherboardId}/{pcId}")
    public String addMotherboardToPc(@PathVariable Long motherboardId,@PathVariable Long pcId)
    {
        return motherboardService.addMotherboardToPc(motherboardId, pcId);
    }

    @GetMapping
    public List<MotherboardDto> getAllMotherboards()
    {
        return motherboardService.getAllMotherboards();
    }

    @GetMapping("/{motherboardId}")
    public Optional<MotherboardDto> getMotherboardById(@PathVariable Long motherboardId) {return motherboardService.getMotherboardById(motherboardId);}
}
