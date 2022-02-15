package com.davis.pcbuilderserver.controllers;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.dtos.StorageDto;
import com.davis.pcbuilderserver.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/storages")
public class StorageController {
    @Autowired
    StorageService storageService;

    @PostMapping("/{storageId}/{pcId}")
    public String addStorageToPc(@PathVariable Long storageId,@PathVariable Long pcId)
    {
        return storageService.addStorageToPc(storageId, pcId);
    }

    @GetMapping
    public List<StorageDto> getAllStorage()
    {
        return storageService.getAllStorage();
    }

    @GetMapping("/{storageId}")
    public Optional<StorageDto> getStorageById(@PathVariable Long storageId) {return storageService.getStorageById(storageId);}

}
