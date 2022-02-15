package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.PsuDto;
import com.davis.pcbuilderserver.services.PsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/psus")
public class PsuController {
    @Autowired
    PsuService psuService;

    @PostMapping("/{psuId}/{pcId}")
    public String addPsuToPc(@PathVariable Long psuId, @PathVariable Long pcId)
    {
        return psuService.addPsuToPc(psuId, pcId);
    }

    @GetMapping
    public List<PsuDto> getAllPsus()
    {
        return psuService.getAllPsus();
    }

    @GetMapping("/{psuId}")
    public Optional<PsuDto> getPsuById(@PathVariable Long psuId) {return psuService.getPsuById(psuId);}
}
