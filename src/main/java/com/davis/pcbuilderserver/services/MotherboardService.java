package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.MotherboardDto;

import java.util.List;
import java.util.Optional;

public interface MotherboardService {
    Optional<MotherboardDto> getMotherboardById(Long motherboardId);

    String addMotherboardToPc(Long motherboardId, Long pcId);

    List<MotherboardDto> getAllMotherboards();
}
