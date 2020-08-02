package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/employees")

public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId) throws Exception{
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping()
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping(path = "/{employeeId}")
    public void updateEmployee(@PathVariable Integer employeeId,@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployeeById(@PathVariable Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @GetMapping(params = "gender")
    public List<Employee> getEmployeeByGender(@RequestParam String gender){
        return employeeService.getEmployeeByGender(gender);
    }

    @GetMapping(params = {"page","pageSize"})
    public Page<Employee> getEmployeeByPage(@RequestParam Integer page,@RequestParam Integer pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return employeeService.getEmployeeByPage(pageable);
    }


}
