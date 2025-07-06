package com.example.EmployeeManagementSystem.controller;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository empRepo;

    public EmployeeController(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }
   
    @GetMapping("/by-name/{name}")
    public List<Employee> getByName(@PathVariable String name) {
        return empRepo.findByName(name);
    }

    @GetMapping("/by-email/{email}")
    public Employee getByEmail(@PathVariable String email) {
        return empRepo.findByEmail(email);
    }

    @GetMapping("/by-dept/{deptId}")
    public List<Employee> getByDept(@PathVariable Long deptId) {
        return empRepo.findByDepartmentId(deptId);
    }

    @GetMapping("/search/{keyword}")
    public List<Employee> searchByName(@PathVariable String keyword) {
        return empRepo.searchByName(keyword);
    }

    @GetMapping("/named/email/{email}")
    public Employee getByEmailNamed(@PathVariable String email) {
        return empRepo.findByEmailNamed(email);
    }

    @GetMapping("/named/dept/{deptId}")
    public List<Employee> getByDeptNamed(@PathVariable Long deptId) {
        return empRepo.findByDeptIdNamed(deptId);
    }
}