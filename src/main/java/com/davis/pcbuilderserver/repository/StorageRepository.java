package com.davis.pcbuilderserver.repository;

import com.davis.pcbuilderserver.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}
