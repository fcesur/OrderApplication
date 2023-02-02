package repository.impl;

import entity.Customer;
import repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class CustomerRepositoryImpl implements CustomerRepository {

    private final Set<Customer> customers;

    public CustomerRepositoryImpl() {
        this.customers = new HashSet<>();
    }

    @Override
    public List<Customer> getAll() {
        return customers.stream().toList();
    }

    @Override
    public Customer getById(Long id) {

        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer add(Customer entity) {
        return customers.add(entity) ? entity : null;
    }


}
