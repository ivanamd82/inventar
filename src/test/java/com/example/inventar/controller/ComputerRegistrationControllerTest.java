package com.example.inventar.controller;

import com.example.inventar.model.Computer;
import com.example.inventar.repository.ComputerRepository;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ComputerRegistrationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ComputerRepository computerRepository;

    @Test
    public void shouldAddNewComputer() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.post("/computers")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{" +
                                "\"name\":\"comp1\"," +
                                "\"price\":\"1000.0\"" +
                                "}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("regNumber", Matchers.greaterThan(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is("comp1")))
                .andExpect(MockMvcResultMatchers.jsonPath("price", Matchers.is(1000.0)));
    }

    @Test
    public void shouldReturnAllComputers() throws Exception {

        computerRepository.deleteAll();

        Computer existingComputer = new Computer();

        existingComputer.setName("comp1");
        existingComputer.setPrice(1000.0);

        Computer savedComputer = computerRepository.save(existingComputer);

        mvc.perform(MockMvcRequestBuilders.get("/computers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Matchers.is("comp1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price", Matchers.is(1000.0)));
    }

}