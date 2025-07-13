package com.cognizant.employeeservice.controller;

import com.cognizant.employeeservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private ApplicationContext context;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        LOGGER.info("Start getAllEmployees");
        List<Employee> employeeList = (List<Employee>) context.getBean("employeeList");
        LOGGER.info("End getAllEmployees");
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        LOGGER.info("Start getEmployee with id={}", id);
        List<Employee> employeeList = (List<Employee>) context.getBean("employeeList");

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                LOGGER.info("End getEmployee - Employee Found");
                return ResponseEntity.ok(emp);
            }
        }

        LOGGER.warn("End getEmployee - Employee Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}