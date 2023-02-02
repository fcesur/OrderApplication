package repository.impl;

import entity.Company;
import repository.CompanyRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CompanyRepositoryImpl implements CompanyRepository {


    private static final Set<Company> companies = new HashSet<>();


    @Override
    public List<Company> getAll() {
        return companies.stream().toList();
    }

    @Override
    public Company getById(Long id) {
        return companies.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Company add(Company entity) {
        return companies.add(entity) ? entity : null;
    }

}
