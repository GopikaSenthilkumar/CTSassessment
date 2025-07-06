package com.example.EmployeeManagementSystem.controller;
import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentRepository deptRepo;
    public DepartmentController(DepartmentRepository deptRepo) {
        this.deptRepo = deptRepo;
    }
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return deptRepo.save(department);
    }
    @GetMapping
    public List<Department> getAllDepartments() {
        return deptRepo.findAll();
    }
}