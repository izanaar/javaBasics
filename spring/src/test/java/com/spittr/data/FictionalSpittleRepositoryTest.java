package com.spittr.data;

import com.spittr.model.Spittle;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FictionalSpittleRepositoryTest {

    private FictionalSpittleRepository repository = new FictionalSpittleRepository();

    @Test
    public void getSpittles() throws Exception {
        List<Spittle> spittleList = repository.getSpittles(0, 20);
        assertEquals(20, spittleList.size());
    }

}