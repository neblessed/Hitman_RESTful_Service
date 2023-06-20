package com.hitmans.api;


import com.hitmans.api.model.Hitman;
import com.hitmans.api.services.HitmanServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/hitman")
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
            return new ResponseEntity<>("Something wrong with your id parameter", HttpStatus.BAD_REQUEST);
        }
        Object hitman = service.getHitmanById(id);
        if (hitman == null || id > service.getAllHitmans().size()) {
            return new ResponseEntity<>("The Hitman is not found", HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(hitman, HttpStatus.OK);
    }

    @PostMapping("/createHitman")
    public ResponseEntity<Object> createHitman(@RequestBody Hitman hitman) {
        if (service.getAllHitmans().stream().anyMatch(x -> x.getId() == hitman.getId())) {
            return new ResponseEntity<>("This id is already used", HttpStatus.BAD_REQUEST);
        }
        Object newHitman = service.createNewHitman(hitman);
        return new ResponseEntity<>(newHitman, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteHitman/{id}")
    public ResponseEntity<Object> deleteHitman(@PathVariable("id") int id) {
        if (id == 0) {
            return new ResponseEntity<>("This id is not found", HttpStatus.BAD_REQUEST);
        }
        service.deleteHitmanById(id);
        return new ResponseEntity<>("The Hitman was successfully deleted", HttpStatus.OK);
    }

    @PutMapping("/editHitman")
    public ResponseEntity<Object> editHitman(@RequestBody Hitman hitman) {
        if (hitman.getId() <= 0 || hitman.getId() > service.getAllHitmans().size()) {
            return new ResponseEntity<>("Wrong id!", HttpStatus.BAD_REQUEST);
        }
        Object newHitman = service.createNewHitman(hitman);
        return new ResponseEntity<>(newHitman, HttpStatus.CREATED);
    }
}
