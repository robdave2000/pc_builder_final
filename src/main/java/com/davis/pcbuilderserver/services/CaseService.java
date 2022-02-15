package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CaseDto;

import java.util.List;
import java.util.Optional;

public interface CaseService {
    Optional<CaseDto> getCaseById(Long caseId);

    List<CaseDto> getCasesByColor(String color);

    String addCaseToPc(Long caseId, Long pcId);

    List<CaseDto> getAllCases();
}
