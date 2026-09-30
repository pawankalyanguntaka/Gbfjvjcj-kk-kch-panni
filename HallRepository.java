package com.hallease.api.repo;
import com.hallease.api.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HallRepository extends JpaRepository<Hall,Long> {}