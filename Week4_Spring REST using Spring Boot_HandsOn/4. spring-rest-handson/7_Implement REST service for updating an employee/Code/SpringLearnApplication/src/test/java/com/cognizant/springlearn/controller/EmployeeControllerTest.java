package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.cognizant.springlearn.service.EmployeeService;

import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testInvalidIdFormat() throws Exception {
        String invalidJson = "{\"id\": \"abc\", \"name\": \"Gopika\", \"salary\": 10000, \"permanent\": true, \"dateOfBirth\": \"03/05/2005\", \"department\": {\"id\": 1, \"name\": \"IT\"}, \"skillList\": [{\"id\": 1, \"name\": \"Java\"}]}";
        mockMvc.perform(put("/employees")
                .contentType("application/json")
                .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}