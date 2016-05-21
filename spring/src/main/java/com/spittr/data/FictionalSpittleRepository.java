package com.spittr.data;


import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Component
public class FictionalSpittleRepository implements SpittleRepository {

    private List<Spittle> spittles;

    @PostConstruct
    public void initSpittles() {

        long dateRange = 1000L * 60L * 60L * 24L * 14L;
        long maxDate = new Date().getTime(),
                minDate = maxDate - dateRange;

        Date[] dates = Stream
                .generate(() -> new Date(ThreadLocalRandom.current().nextLong(minDate, maxDate + 1)))
                .limit(30)
                .sorted()
                .toArray(Date[]::new);

        spittles = new ArrayList<>(dates.length);

        for(int i = 0; i < dates.length; i++){
            spittles.add(i, new Spittle((long) i, "Spittle #" + i, dates[i],
                    ThreadLocalRandom.current().nextDouble(0, 361), ThreadLocalRandom.current().nextDouble(-180,181)));
        }

    }

    @Override
    public List<Spittle> getSpittles(long max, int count) {
        return spittles;
    }

    @Override
    public void deleteSpittles(List<Spittle> spittles) {

    }

    @Override
    public Spittle findOne(Long spittleId) {
        return spittles
                .stream()
                .filter(spittle -> spittle.getId()
                        .equals(spittleId))
                .findFirst()
                .orElseThrow(SpittleNotFoundException::new);
    }

    @Override
    public Spittle saveSpittle(Spittle spittle) {
        return null;//TODO implement method
    }

    @Override
    public Spitter getSpitter(Long id) {
        return null;
    }
}
