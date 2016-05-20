package com.spittr.service;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpittleService {

    @Autowired
    private SpittleRepository spittleRepository;

    public Spitter getSpitterProfile(Long spitterId){
        System.out.println("Get profile ".concat(spitterId.toString()));
        return spittleRepository.getSpitter(spitterId);
    }

}
