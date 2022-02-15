package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.CpuCooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpuCoolerRepository extends JpaRepository<CpuCooler, Long> {
}
