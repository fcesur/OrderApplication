package entity;

import entity.abstracts.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Invoice extends BaseEntity {

    private Company company;

    private Customer customer;

    private BigDecimal amount;

    private List<Product> products;

//    public Invoice(Long id, LocalDate creationDate) {
//        super(id, creationDate);
//    }

    public Invoice(Long id, LocalDate creationDate, Company company, Customer customer, List<Product> products) {
        super(id, creationDate);
        this.company = company;
        this.customer = customer;
        this.products = products;

        setAmount();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount() {
        amount = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
