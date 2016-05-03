package com.spittr.data;


import com.spittr.model.Spittle;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FictionalSpittleRepository implements SpittleRepository{

    @Override
    public List<Spittle> getSpittles(long max, int count) {
        Stream<Spittle> spittleStream = Stream
                .iterate(new Spittle("This is spittle #1", new Date()),
                        spittle -> {
                            String prevMessage = spittle.getMessage();
                            long id = Long.parseLong(prevMessage.substring(prevMessage.indexOf("#")+1));
                            id++;
                            return new Spittle("This is spittle #" + id, new Date());
                        }).limit(count);

        return spittleStream.collect(Collectors.toList());
    }
}
