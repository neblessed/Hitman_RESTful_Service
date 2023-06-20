package com.hitmans.api.services;

import com.hitmans.api.model.Weapon;

import java.util.List;

public interface WeaponService {
    Object createNewWeapon(Weapon weapon);

    void deleteWeaponById(int weaponId);

    List<Weapon> getAllWeapons();

    Object getWeaponById(int weaponId);
}
