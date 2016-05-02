package web;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {

    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();

    @Test
    public void home() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }

}