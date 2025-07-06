package com.example.EmployeeManagementSystem.repository;
import com.example.EmployeeManagementSystem.dto.EmployeeNameAndDept;
import com.example.EmployeeManagementSystem.dto.EmployeeNameAndEmail;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeDeptView;
import com.example.EmployeeManagementSystem.projection.EmployeeNameView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeNameView> findAllBy();
    List<EmployeeDeptView> findByDepartment_Name(String deptName);
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeNameAndEmail(e.name, e.email) FROM Employee e")
    List<EmployeeNameAndEmail> fetchNameAndEmail();
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeNameAndDept(e.name, e.department.name) FROM Employee e")
    List<EmployeeNameAndDept> fetchNameAndDept();
}