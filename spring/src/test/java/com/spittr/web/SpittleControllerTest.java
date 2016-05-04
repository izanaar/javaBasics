package com.spittr.web;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class SpittleControllerTest {

    @Mock
    private SpittleRepository spittleRepository;

    @InjectMocks
    private SpittleController spittleController = new SpittleController();

    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).build();


    @Test
    public void testGetSpittles() throws Exception{

        List<Spittle> expectedSpittles = new ArrayList<>(2);
        expectedSpittles.add(new Spittle("Spittle 1", new Date()));
        expectedSpittles.add(new Spittle("Spittle 2", new Date()));

        when(spittleRepository.getSpittles(anyLong(), anyInt())).thenReturn(expectedSpittles);

        mockMvc.perform(get("/spittles/get"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        hasItems(expectedSpittles.toArray())));

    }
}