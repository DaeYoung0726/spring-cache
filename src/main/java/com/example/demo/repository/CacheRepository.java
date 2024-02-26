package com.example.demo.repository;

import com.example.demo.data.CacheData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CacheRepository extends JpaRepository<CacheData, Long> {

    CacheData findByName(String name);
}
