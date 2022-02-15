package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByUsername(String username);
}
