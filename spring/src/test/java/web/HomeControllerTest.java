package web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {

    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();

    @Test
    public void home() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }

}