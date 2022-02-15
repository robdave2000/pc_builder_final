package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.PsuDto;

import java.util.List;
import java.util.Optional;

public interface PsuService {
    Optional<PsuDto> getPsuById(Long psuId);

    String addPsuToPc(Long psuId, Long pcId);

    List<PsuDto> getAllPsus();
}
