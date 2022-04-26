package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CaseDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CaseService {
    Optional<CaseDto> getCaseById(Long caseId);

    String addCaseToPc(Long caseId, Long pcId);

    List<CaseDto> getAllCases();

    List<CaseDto> getCasesByParams(Map<String, String> params);
}
