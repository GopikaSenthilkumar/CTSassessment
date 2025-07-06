package com.example.EmployeeManagementSystem.dto;
public class EmployeeNameAndDept {
    private String employeeName;
    private String departmentName;

    public EmployeeNameAndDept(String employeeName, String departmentName) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}