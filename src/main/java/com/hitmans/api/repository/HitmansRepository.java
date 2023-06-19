package com.hitmans.api.repository;

import com.hitmans.api.model.Hitman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HitmansRepository extends JpaRepository<Hitman, Integer> {
}
