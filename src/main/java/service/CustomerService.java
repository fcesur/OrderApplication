package service;

import entity.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface CustomerService extends EntityService<Customer> {
    Set<Customer> getCustomersStartsWithLetter(String letter);
    List<Customer> getCustomerHaveInvoiceUnderAmount(BigDecimal amount);
}
