package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.RamDto;

import java.util.List;
import java.util.Optional;

public interface RamService {
    Optional<RamDto> getRamById(Long ramId);

    String addRamToPc(Long ramId, Long pcId);

    List<RamDto> getAllRam();
}
