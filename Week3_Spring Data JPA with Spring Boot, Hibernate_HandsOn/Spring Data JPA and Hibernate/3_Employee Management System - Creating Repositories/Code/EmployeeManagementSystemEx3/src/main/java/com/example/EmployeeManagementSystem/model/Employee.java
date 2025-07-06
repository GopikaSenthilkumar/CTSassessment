package com.example.EmployeeManagementSystem.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}