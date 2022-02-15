package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CpuDto;

import java.util.List;
import java.util.Optional;

public interface CpuService {
    Optional<CpuDto> getCpuById(Long cpuId);

    String addCpuToPc(Long cpuId, Long pcId);

    List<CpuDto> getCpusByBrand(String brand);

    List<CpuDto> getAllCpusBySearch(String search, String search1, String search2);

    List<CpuDto> getAllCpus();
}
