package com.hitmans.api;


import com.hitmans.api.model.Hitman;
import com.hitmans.api.services.HitmanServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1")
public class HitmanController {

    @Autowired
    HitmanServiceImplement service;


    @GetMapping("/getAllHitmans")
    public List<Hitman> getAllHitmans() {
        return service.getAllHitmans();
    }

    @GetMapping("/getHitman/{id}")
    public ResponseEntity<Object> getHitmanById(@PathVariable("id") int id) {
        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Object hitman = service.getHitmanById(id);
        System.out.println(hitman);
        if (hitman == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(hitman, HttpStatus.OK);
    }

    @PostMapping("/createHitman")
    public ResponseEntity<Object> createHitman(@RequestBody Hitman hitman) {
        Object newHitman = service.createNewHitman(hitman);
        return new ResponseEntity<>(newHitman, HttpStatus.CREATED);
    }
}
