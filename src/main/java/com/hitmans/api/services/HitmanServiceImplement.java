package com.hitmans.api.services;

import com.hitmans.api.model.Hitman;
import com.hitmans.api.repository.HitmansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HitmanServiceImplement implements HitmanService {
    @Autowired
    HitmansRepository hitmansRepository;

    @Override
    public Object getHitmanById(int id) {
        return hitmansRepository.findById(id);
    }

    @Override
    public List<Hitman> getAllHitmans() {
        return hitmansRepository.findAll();
    }

    @Override
    public void saveHitman(Hitman hitman) {
        hitmansRepository.save(hitman);
    }

    @Override
    public void deleteHitmanById(int hitmanId) {
        hitmansRepository.deleteById(hitmanId);

    }

    @Override
    public Hitman createNewHitman(Hitman hitman) {
        return hitmansRepository.save(hitman);
    }

}
