package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.StorageDto;

import java.util.List;
import java.util.Optional;

public interface StorageService {
    Optional<StorageDto> getStorageById(Long storageId);

    String addStorageToPc(Long storageId, Long pcId);

    List<StorageDto> getAllStorage();
}
