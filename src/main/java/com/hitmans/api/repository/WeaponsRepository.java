package com.hitmans.api.repository;

import com.hitmans.api.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponsRepository extends JpaRepository<Weapon,Integer> {
}
