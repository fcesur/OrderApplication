package service.impl;

import entity.Company;
import repository.CompanyRepository;
import service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public Company add(Company entity) {
        return companyRepository.add(entity);
    }
}
