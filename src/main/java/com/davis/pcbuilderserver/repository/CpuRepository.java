package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CpuRepository extends JpaRepository<Cpu, Long> {
    public List<Cpu> findCpusByBrandOrNameOrLevelContains(String brand, String name, String level);

    List<Cpu> findCpusByBrand(String brand);
}
