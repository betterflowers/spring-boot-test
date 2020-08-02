package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    void addCompany(Company company);

    void deleteCompanyById(Integer companyId);
    Company getCompanyById(Integer companyId)throws Exception;


    void updateCompanyById(Company company);

    Page<Company> getCompanyByPage(Pageable pageable);

    List<Employee> getEmployeeByCompanyId(Integer companyId) throws Exception;
}
