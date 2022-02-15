package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.PcDto;
import com.davis.pcbuilderserver.services.PcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pcs")
public class PcController {
    @Autowired
    PcService pcService;

    @GetMapping("/{pcId}")
    public Optional<PcDto> getPcById(@PathVariable Long pcId){return pcService.getPcById(pcId);}

    @PostMapping
    public Optional<Long> addPc(@RequestBody Map<String, String> body)
    {
        if (body.containsKey("name"))
        {
            return Optional.of(pcService.addPc(body.get("name")));
        }
        return Optional.empty();
    }
}
