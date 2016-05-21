package com.spittr.security;

import com.spittr.config.MethodSecurityConfig;
import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import com.spittr.service.SpittleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MethodSecurityConfig.class, WebSecurityTestRootConfig.class})
public class FilterSecurityTest {

    @Autowired
    private SpittleRepository spittleRepository;

    @Autowired
    private SpittleService spittleService;

    @Before
    public void setUp() throws Exception {
        reset(spittleRepository);
        when(spittleRepository.getSpittles(anyLong(), anyInt()))
                .thenReturn(new ArrayList<>(Arrays.asList(new Spittle(0L, "spittle 1", new Date()),
                        new Spittle(1L, "spittle 1", new Date()))));
    }

    @Test
    @WithMockUser
    public void testPost() throws Exception {
        assertTrue(spittleService.getSpittles().size() == 1);
    }

    @Test
    @WithMockUser
    public void testPre() throws Exception {
        Stream<Spittle> spittleStream = Stream.iterate(new Spittle(0L, "msg", new Date()), spittle ->
                new Spittle(spittle.getId() + 1, spittle.getMessage(), spittle.getTime())).limit(5);
        spittleService.deleteSpittles(spittleStream.collect(Collectors.toList()));

    }
}
