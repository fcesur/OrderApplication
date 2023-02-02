package service.impl;

import entity.Customer;
import repository.CustomerRepository;
import service.CustomerService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public Customer add(Customer entity) {
        return customerRepository.add(entity);
    }

    @Override
    public Set<Customer> getCustomersStartsWithLetter(String letter) {
        return customerRepository.getAll()
                .stream()
                .filter(c ->
                        c.getName().startsWith(letter))
                .collect(Collectors.toSet());
    }

    @Override
    public List<Customer> getCustomerHaveInvoiceUnderAmount(BigDecimal amount) {
        return customerRepository.getAll().stream()
                .filter(c ->
                        c.hasInvoiceUnderAmount(amount))
                .collect(Collectors.toList());
    }
}
