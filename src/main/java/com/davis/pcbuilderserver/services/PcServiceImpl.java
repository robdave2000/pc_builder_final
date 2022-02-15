package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.PcDto;
import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PcServiceImpl implements PcService {
    @Autowired
    PcRepository pcRepository;

    @Override
    public Optional<PcDto> getPcById(Long pcId)
    {
        Optional<Pc> optionalPc = pcRepository.findById(pcId);
        if (optionalPc.isPresent())
        {
            return Optional.of(new PcDto(optionalPc.get()));
        }
        return Optional.empty();
    }

    @Override
    public Long addPc(String name)
    {
        Pc pc = new Pc();
        pc.setName(name);
        pcRepository.saveAndFlush(pc);
        return pc.getId();
    }
}
