package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
    public List<Case> findAllByColorEquals(String color);
}
