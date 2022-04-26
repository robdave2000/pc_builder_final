package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.CaseDto;
import com.davis.pcbuilderserver.entities.Case;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.repository.CaseRepository;
import com.davis.pcbuilderserver.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    CaseRepository caseRepository;

    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<CaseDto> getCaseById(Long caseId)
    {
        Optional<Case> optionalCase = caseRepository.findById(caseId);
        if (optionalCase.isPresent())
        {
            return Optional.of(new CaseDto(optionalCase.get()));
        }
        return Optional.empty();
    }

    @Override
    public String addCaseToPc(Long caseId, Long pcId) {
        Optional<Case> caseOptional = caseRepository.findById(caseId);
        Optional<Pc> pcOptional = pcRepository.findById(pcId);

        if (caseOptional.isPresent() && pcOptional.isPresent())
        {
            pcOptional.get().setPcCase(new CaseDto(caseOptional.get()));
            pcRepository.saveAndFlush(pcOptional.get());
            return "Case added";
        }
        return "Case not added";
    }

    @Override
    public List<CaseDto> getAllCases() {
        List<Case> caseList = caseRepository.findAll();
        return caseList.stream().map(casw-> new CaseDto(casw)).collect(Collectors.toList());
    }

    @Override
    public List<CaseDto> getCasesByParams(Map<String, String> params) {
        if (params.containsKey("search"))
        {
            List<Case> caseList = caseRepository.findAllByNameOrBrandContains(params.get("search"), params.get("search"));
            return caseList.stream().map(casws->new CaseDto(casws)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
