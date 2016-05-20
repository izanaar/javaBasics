package com.spittr.security;


import com.spittr.config.MethodSecurityConfig;
import com.spittr.data.SpittleRepository;
import com.spittr.model.Spitter;
import com.spittr.service.SpittleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MethodSecurityConfig.class, WebSecurityTestRootConfig.class})
public class MethodSecurityTest {

    private SpittleService spittleService;

    @Autowired
    private SpittleRepository spittleRepository;

    public MethodSecurityTest() {
        spittleService = new SpittleService();
        ReflectionTestUtils.setField(spittleService, "spittleRepository", spittleRepository);
    }

    @Test
    public void testGetSpitter() throws Exception {
        long id = 5L;
        Spitter spitter = mock(Spitter.class);

        when(spittleRepository.getSpitter(id)).thenReturn(spitter);

        assertEquals(spitter, spittleService.getSpitterProfile(id));
    }
}
