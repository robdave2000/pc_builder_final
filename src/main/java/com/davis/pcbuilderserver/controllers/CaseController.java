package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {
    @Autowired
    CaseService caseService;

    @PostMapping("/{caseId}/{pcId}")
    public String addCaseToPc(@PathVariable Long caseId,@PathVariable Long pcId)
    {
        return caseService.addCaseToPc(caseId, pcId);
    }

    @GetMapping
    public List<CaseDto> getAllCases()
    {
        return caseService.getAllCases();
    }

    @GetMapping("/{caseId}")
    public Optional<CaseDto> getCaseById(@PathVariable Long caseId)
    {
        return caseService.getCaseById(caseId);
    }

    @GetMapping("/")
    public List<CaseDto> getCasesByParam(@RequestParam Map<String, String> params)
    {
        return caseService.getCasesByParams(params);
    }
}
