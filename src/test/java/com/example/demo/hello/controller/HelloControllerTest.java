package com.example.demo.hello.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/* Test with "dev" profile */
//@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;


    @Test
    public void add() throws Exception {
    //   IntegerAdder adder = new IntegerAdder();
       int result = 1 +  2;
       assert result == 3;
    }

    @Test
    public void index() throws Exception {

      //get 
      //MvcResult result = 
      
      this.mockMvc
            .perform(get("/hello"))
            .andExpect(status().isOk())          
            .andExpect(jsonPath("$.id", is("uuid-01")))
            .andReturn();
      
      //      log.info("AddAttachment result :{}", result.getResponse().getContentAsString());
	}
 }