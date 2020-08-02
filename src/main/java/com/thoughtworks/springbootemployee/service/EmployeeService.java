package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId) throws Exception;

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(Integer employeeId);

    List<Employee> getEmployeeByGender(String gender);

    Page<Employee> getEmployeeByPage(Pageable pageable);
}
