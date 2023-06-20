package com.hitmans.api.services;

import com.hitmans.api.model.Weapon;
import com.hitmans.api.repository.WeaponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponImplement implements WeaponService{

    @Autowired
    WeaponsRepository weaponsRepository;

    @Override
    public Weapon createNewWeapon(Weapon weapon) {
        return weaponsRepository.save(weapon);
    }

    @Override
    public void deleteWeaponById(int weaponId) {
        weaponsRepository.deleteById(weaponId);
    }

    @Override
    public List<Weapon> getAllWeapons() {
        return weaponsRepository.findAll();
    }

    @Override
    public Object getWeaponById(int weaponId) {
        return weaponsRepository.findById(weaponId);
    }
}
