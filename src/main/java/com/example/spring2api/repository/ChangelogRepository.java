package com.example.spring2api.repository;

import com.example.spring2api.entity.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChangelogRepository extends JpaRepository<ChangeLog, UUID>{
}
