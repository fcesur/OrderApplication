package entity;

import entity.abstracts.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Company extends BaseEntity {

    private Sector sector;

    private String name;

    private Set<Invoice> invoices;

    public Company(Long id, LocalDate creationDate, String name) {
        super(id, creationDate);
        this.name = name;
    }

    public Company(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Company(Long id, LocalDate creationDate, Sector sector, String name, Set<Invoice> invoices) {
        super(id, creationDate);
        this.sector = sector;
        this.name = name;
        this.invoices = invoices;
    }

    public BigDecimal getAverageInvoice() {
        return invoices.stream().map(Invoice::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(invoices.size()));
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
