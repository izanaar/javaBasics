package com.spittr.service;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpittleService {

    @Autowired
    private SpittleRepository spittleRepository;

    @Secured("ROLE_ADMIN")
    public Spitter getSpitterProfile(Long spitterId){
        System.out.println("Get profile ".concat(spitterId.toString()));
        return spittleRepository.getSpitter(spitterId);
    }


    @PreAuthorize("hasRole('PRESIDENT') or #spitterId == 6")
    @PostAuthorize("returnObject.id == 6 or principal.username == returnObject.username")
    public Spitter getSpitterProfilePostAuthorize(Long spitterId){
        System.out.println("Get profile ".concat(spitterId.toString()));
        return spittleRepository.getSpitter(spitterId);
    }

    @PostFilter("filterObject.id == 0")
    public List<Spittle> getSpittles(){
        return spittleRepository.getSpittles(0, 0);
    }

    @PreFilter("filterObject.id == 2")
    public void deleteSpittles(List<Spittle> spittles){
        spittleRepository.deleteSpittles(spittles);
    }

}
