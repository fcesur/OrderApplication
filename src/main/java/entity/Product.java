package entity;

import entity.abstracts.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product extends BaseEntity {

    private String name;

    private BigDecimal price;

    public Product(Long id, LocalDate creationDate, String name, BigDecimal price) {
        super(id, creationDate);
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, BigDecimal price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
