package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcRepository extends JpaRepository<Pc, Long> {
    public List<Pc> findPcByUserSetContaining(User user);

}
