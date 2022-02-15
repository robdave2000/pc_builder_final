package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.GpuDto;

import java.util.List;
import java.util.Optional;

public interface GpuService {
    Optional<GpuDto> getGpuById(Long gpuId);

    String addGpuToPc(Long gpuId, Long pcId);

    List<GpuDto> getAllGpus();
}
