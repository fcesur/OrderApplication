package entity;

import entity.abstracts.BaseEntity;

import java.time.LocalDate;
import java.util.List;

public class Order extends BaseEntity {

    private Customer customer;

    private List<Product> products;


    public Order(Long id, LocalDate creationDate) {
        super(id, creationDate);
    }
}
