package com.spittr.data;


import com.spittr.model.Spittle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FictionalSpittleRepository implements SpittleRepository {

    private List<Spittle> spittles;

    @PostConstruct
    public void initSpittles() {

        long dateRange = 1000L * 60L * 60L * 24L * 14L;
        long maxDate = new Date().getTime(),
                minDate = maxDate - dateRange;
        System.out.println("Min date: " + new Date(minDate).toString());

        Long counter = -1L;

        Stream<Spittle> dateStream = Stream
                .generate(() -> new Date(ThreadLocalRandom.current().nextLong(minDate, maxDate + 1)))
                .limit(30)
                .sorted()
                .map(date -> {
                    counter = counter+1;
                    new Spittle(counter, "Spittle #" + counter.toString(), date,
                            ThreadLocalRandom.current().nextDouble(0, 361), ThreadLocalRandom.current().nextDouble(-180, 181));

                })

        dateStream.forEach(System.out::println);


    }

    @Override
    public List<Spittle> getSpittles(long max, int count) {
        return spittles;
    }
}
