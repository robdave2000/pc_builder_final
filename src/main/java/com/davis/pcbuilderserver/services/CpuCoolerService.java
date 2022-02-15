package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CpuCoolerDto;

import java.util.List;
import java.util.Optional;

public interface CpuCoolerService {
    Optional<CpuCoolerDto> getCpuCoolerById(Long cpuCoolerId);

    String addCpuCoolerToPc(Long cpuCoolerId, Long pcId);

    List<CpuCoolerDto> getAllCpuCoolers();
}
