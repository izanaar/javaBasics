package com.spittr.web;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class RegisterControllerTest {

    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new RegisterController())
            .setSingleView(new InternalResourceView("/WEB-INF/views/register.jsp"))
            .build();

    @Test
    public void getPage() throws Exception {
        mockMvc
                .perform(get("/register"))
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("spitter"));
    }

    @Test
    public void register() throws Exception {
        MockMultipartFile firstFile = new MockMultipartFile("file", "filename.txt", "text/plain", "some xml".getBytes());

        mockMvc
                .perform(fileUpload("/register")
                        .file(firstFile)
                        .param("firstName", "John"))

                .andExpect(redirectedUrl("/"));

    }

}