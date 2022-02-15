package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.PcDto;

import java.util.Optional;

public interface PcService {
    Optional<PcDto> getPcById(Long pcId);

    Long addPc(String name);
}
