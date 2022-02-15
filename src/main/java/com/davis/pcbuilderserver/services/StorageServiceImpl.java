package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.RamDto;
import com.davis.pcbuilderserver.dtos.StorageDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.entities.Ram;
import com.davis.pcbuilderserver.entities.Storage;
import com.davis.pcbuilderserver.repository.PcRepository;
import com.davis.pcbuilderserver.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService{
    @Autowired
    StorageRepository storageRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<StorageDto> getStorageById(Long storageId)
    {
        Optional<Storage> optionalStorage = storageRepository.findById(storageId);
        if (optionalStorage.isPresent())
        {
            return Optional.of(new StorageDto(optionalStorage.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addStorageToPc(Long storageId, Long pcId) {
        Optional<Storage> storageOptional = storageRepository.findById(storageId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (storageOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setStorage(new StorageDto(storageOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Storage added";
        }
        return "Storage not added";
    }

    @Override
    public List<StorageDto> getAllStorage() {
        List<Storage> storageList = storageRepository.findAll();
        return storageList.stream().map(storage-> new StorageDto(storage)).collect(Collectors.toList());
    }
}
