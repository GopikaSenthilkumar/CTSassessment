package com.example.EmployeeManagementSystem.repository;
import com.example.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}