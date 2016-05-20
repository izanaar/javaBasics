package com.spittr.data;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;

import java.util.List;
import java.util.Optional;

public interface SpittleRepository {

    List<Spittle> getSpittles(long max, int count);

    Spittle findOne(Long spittleId);

    Spittle saveSpittle(Spittle spittle);

    Spitter getSpitter(Long id);
}
