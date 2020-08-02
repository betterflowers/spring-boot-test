package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/companies")

public class CompanyController {

    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompany(){
        return  companyService.getAllCompany();
    }

    @GetMapping(path="/{companyId}")
    public Company getCompanyById(@PathVariable Integer companyId) throws Exception{
        return companyService.getCompanyById(companyId);
    }

    @PostMapping
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @DeleteMapping(path = "/{companyId}")
    public void deleteCompanyById(@PathVariable Integer companyId){
        companyService.deleteCompanyById(companyId);
    }

    @PutMapping(path = "/{companyId}")
    public void updateCompanyById(@PathVariable Integer companyId,@RequestBody Company company){
        companyService.updateCompanyById(company);
    }

    @GetMapping(params = "unpaged")
    public Page<Company> getCompanyByPage(@PageableDefault(size =2) Pageable pageable, @RequestParam(defaultValue = "true") boolean unpaged){
    if(unpaged){
        return companyService.getCompanyByPage(Pageable.unpaged());
    }
    return companyService.getCompanyByPage(pageable);
    }

    @GetMapping(params = {"page","size"})
    public Page<Company> getCompanyByPage(Pageable pageable){

        return companyService.getCompanyByPage(pageable);
    }

    @GetMapping(path="/{companyId}/employees")
    public List<Employee> getEmployeeByCompanyId (@PathVariable Integer companyId) throws Exception{

        return companyService.getEmployeeByCompanyId(companyId);
    }

}
