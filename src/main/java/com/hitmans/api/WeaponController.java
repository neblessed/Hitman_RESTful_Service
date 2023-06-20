package com.hitmans.api;

import com.hitmans.api.model.Hitman;
import com.hitmans.api.model.Weapon;
import com.hitmans.api.services.HitmanServiceImplement;
import com.hitmans.api.services.WeaponImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/weapon")
public class WeaponController {
    @Autowired
    WeaponImplement weaponImplement;

    @Autowired
    HitmanServiceImplement hitmanServiceImplement;

    @PostMapping("/createWeapon")
    public ResponseEntity<Object> createWeapon(@RequestBody Weapon weapon) {
        if (weapon.getHitmanLinkId() > hitmanServiceImplement.getAllHitmans().size()) {
            return new ResponseEntity<>("You need to change your 'hitmanLinkId', because the Hitman with this id is not exists!",
                    HttpStatus.BAD_REQUEST);
        }
        Weapon weapon1 = weaponImplement.createNewWeapon(weapon);
        return new ResponseEntity<>(weapon1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllWeapons")
    public ResponseEntity<List<Weapon>> getAllWeapons() {
        return new ResponseEntity<>(weaponImplement.getAllWeapons(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteWeapon/{id}")
    public ResponseEntity<Object> deleteWeaponById(@PathVariable("id") int weaponId) {
        if (weaponId == 0) {
            return new ResponseEntity<>("This id is not found", HttpStatus.BAD_REQUEST);
        }
        weaponImplement.deleteWeaponById(weaponId);
        return new ResponseEntity<>("The weapon with " + weaponId + " was successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/getWeaponById/{id}")
    public ResponseEntity<Object> getWeaponById(@PathVariable("id") int weaponId) {
        if (weaponId == 0) {
            return new ResponseEntity<>("Something wrong with your id parameter", HttpStatus.BAD_REQUEST);
        }
        Object weapon = weaponImplement.getWeaponById(weaponId);
        if (weapon == null || weaponId > weaponImplement.getAllWeapons().size()) {
            return new ResponseEntity<>("The Weapon is not found", HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(weapon, HttpStatus.OK);
    }

    @PutMapping("/editWeapon")
    public ResponseEntity<Object> editWeapon(@RequestBody Weapon weapon) {
        if (weapon.getHitmanLinkId() > hitmanServiceImplement.getAllHitmans().size()) {
            return new ResponseEntity<>("You need to change your 'hitmanLinkId', because the Hitman with this id is not exists!",
                    HttpStatus.BAD_REQUEST);
        } else if (weapon.getId() <= 0) {
            return new ResponseEntity<>("Wrong Id!", HttpStatus.BAD_REQUEST);
        }
        Weapon weapon1 = weaponImplement.createNewWeapon(weapon);
        return new ResponseEntity<>(weapon1, HttpStatus.CREATED);
    }
}
