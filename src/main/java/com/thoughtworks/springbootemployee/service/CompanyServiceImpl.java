package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Integer companyId) throws Exception{
        return companyRepository.findById(companyId).orElseThrow(Exception::new);
    }

    @Override
    public void deleteCompanyById(Integer companyId) {
        companyRepository.deleteById(companyId);
    }

    @Override
    public void updateCompanyById(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Page<Company> getCompanyByPage(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public List<Employee> getEmployeeByCompanyId(Integer companyId) throws Exception{
       return companyRepository.findById(companyId).orElseThrow(Exception::new).getEmployeeList();
    }
}
