package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Psu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsuRepository extends JpaRepository<Psu, Long> {
}
