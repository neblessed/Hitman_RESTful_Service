package com.hitmans.api.services;

import com.hitmans.api.model.Hitman;

import java.util.List;

public interface HitmanService {

    //GET
    Object getHitmanById(int id);
    List<Hitman> getAllHitmans();

    //POST
    void saveHitman(Hitman hitman);

    //DELETE
    void deleteHitmanById(int hitmanId);

    //CREATE/UPDATE
    Hitman createNewHitman(Hitman hitman);



}
