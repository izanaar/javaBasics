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
import org.spridom perser javangframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MethodSecurityConfig.class, WebSecurityTestRootConfig.class})
public class MethodSecurityTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private SpittleService spittleService;

    @Autowired
    private SpittleRepository spittleRepository;

    @Before
    public void setUp() throws Exception{
        reset(spittleRepository);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testGetSpitterAsUser() throws Exception {
        long id = 5L;
        Spitter spitter = mock(Spitter.class);

        when(spittleRepository.getSpitter(id)).thenReturn(spitter);
        thrown.expect(AccessDeniedException.class);
        spittleService.getSpitterProfile(id);
        verify(spittleRepository, times(0)).getSpitter(anyLong());
    }

    @Test
    @WithMockUser(authorities = "ROLE_ADMIN")
    public void testGetSpitterWithAdminAuthority() throws Exception {
        testGetSpitter(5L);
    }

    private void testGetSpitter(long id){
        Spitter spitter = mock(Spitter.class);

        when(spittleRepository.getSpitter(id)).thenReturn(spitter);
        spittleService.getSpitterProfile(id);
        verify(spittleRepository, times(1)).getSpitter(id);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetSpitterWithAdminRole() throws Exception {
        testGetSpitter(5L);
    }
}
