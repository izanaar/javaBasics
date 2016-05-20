package com.spittr.security;

import com.spittr.config.MethodSecurityConfig;
import com.spittr.data.SpittleRepository;
import com.spittr.model.Spitter;
import com.spittr.service.SpittleService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebSecurityTestRootConfig.class, MethodSecurityConfig.class})
public class PrePostSecurityTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private SpittleService spittleService;

    @Autowired
    private SpittleRepository spittleRepository;

    @Before
    public void setUp() throws Exception {
        reset(spittleRepository);
    }

    @Test
    @WithMockUser(roles = "PRESIDENT")
    public void testGetSpitterAsAdmin() throws Exception {
        long id = 6L;
        Spitter spitter = mock(Spitter.class);
        when(spitter.getId()).thenReturn(id);

        when(spittleRepository.getSpitter(id)).thenReturn(spitter);
        spittleService.getSpitterProfilePostAuthorize(id);
        verify(spittleRepository, times(1)).getSpitter(anyLong());
    }

    @Test
    @WithMockUser()
    public void testPost1() throws Exception {
        long id = 6L;
        Spitter spitter = new Spitter();
        spitter.setId(6L);

        when(spittleRepository.getSpitter(id)).thenReturn(spitter);
        spittleService.getSpitterProfilePostAuthorize(id);
        verify(spittleRepository, times(1)).getSpitter(anyLong());
    }

    @Test
    @WithMockUser
    public void testPost2() throws Exception {
        long id = 6L;
        Spitter spitter = new Spitter();
        spitter.setId(7L);


        when(spittleRepository.getSpitter(id)).thenReturn(spitter);
        thrown.expect(AccessDeniedException.class);
        spittleService.getSpitterProfilePostAuthorize(id);
        verify(spittleRepository, times(1)).getSpitter(anyLong());
    }

    @Test
    @WithMockUser("user42")
    public void testPost3() throws Exception {
        long id = 6L;
        Spitter spitter = new Spitter();
        spitter.setId(9L);
        spitter.setUsername("user42");
        when(spittleRepository.getSpitter(id)).thenReturn(spitter);
        spittleService.getSpitterProfilePostAuthorize(id);
        verify(spittleRepository, times(1)).getSpitter(anyLong());
    }
}
