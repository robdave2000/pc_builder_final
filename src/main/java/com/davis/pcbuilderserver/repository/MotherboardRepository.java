package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
}
