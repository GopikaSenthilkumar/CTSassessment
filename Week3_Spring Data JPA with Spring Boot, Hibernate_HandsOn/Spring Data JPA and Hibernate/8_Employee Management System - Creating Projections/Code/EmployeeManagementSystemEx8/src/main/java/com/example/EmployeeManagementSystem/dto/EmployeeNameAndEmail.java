package com.example.EmployeeManagementSystem.dto;
public class EmployeeNameAndEmail {
    private String name;
    private String email;

    public EmployeeNameAndEmail(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}