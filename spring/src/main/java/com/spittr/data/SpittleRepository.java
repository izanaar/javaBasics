package com.spittr.data;

import com.spittr.model.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> getSpittles(long max, int count);

}
