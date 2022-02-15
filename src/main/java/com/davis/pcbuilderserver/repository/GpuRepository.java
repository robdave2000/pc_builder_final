package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
