package com.spittr.web;

import com.spittr.data.DuplicateSpittleException;
import com.spittr.data.SpittleNotFoundException;
import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import sun.security.provider.ConfigFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class SpittleControllerTest {

    @Mock
    private SpittleRepository spittleRepository;

    @InjectMocks
    private SpittleController spittleController = new SpittleController(spittleRepository);

    private MockMvc mockMvc = standaloneSetup(spittleController).build();

    @Test
    public void testGetSpittles() throws Exception {
        List<Spittle> expectedSpittles = new ArrayList<>(2);
        expectedSpittles.add(new Spittle(0L, "Spittle 1", new Date()));
        expectedSpittles.add(new Spittle(1L, "Spittle 2", new Date()));

        when(spittleRepository.getSpittles(anyLong(), anyInt())).thenReturn(expectedSpittles);

        mockMvc.perform(get("/spittles/get"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testGetSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle(2L, "the spittle", new Date(), 2D, -3D);

        when(spittleRepository.findOne(expectedSpittle.getId())).thenReturn(expectedSpittle);
        when(spittleRepository.findOne(3L)).thenThrow(SpittleNotFoundException.class);

        mockMvc.perform(get("/spittles/get/2"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));


        mockMvc.perform(get("/spittles/get/3"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    public void testSaveSpittle() throws Exception {
        Spittle originalSpittle = new Spittle(null, "Original spittle", new Date(), 4D, 2D);
        Spittle duplicateSpittle = new Spittle(null, "Duplicate spittle", new Date(), 6D, -3D);

        when(spittleRepository.saveSpittle(originalSpittle)).thenReturn(new Spittle(
                1L, originalSpittle.getMessage(), originalSpittle.getTime(),
                originalSpittle.getLongitude(), originalSpittle.getLatitude()));

        when(spittleRepository.saveSpittle(duplicateSpittle)).thenThrow(DuplicateSpittleException.class);

        mockMvc.perform(post("/spittles/save")
                        .param("message", originalSpittle.getMessage())
                        .param("time", String.valueOf(originalSpittle.getTime().getTime()))
                        .param("longitude", originalSpittle.getLongitude().toString())
                        .param("latitude", originalSpittle.getLatitude().toString()))
                .andExpect(redirectedUrl("/spittles"));

    }
}