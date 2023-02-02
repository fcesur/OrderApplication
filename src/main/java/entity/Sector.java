package entity;

import entity.abstracts.BaseEntity;

import java.time.LocalDate;
import java.util.Set;


public class Sector extends BaseEntity {

    private String name;

    private Set<Company> companies;

    public Sector(Long id, LocalDate creationDate, String name) {
        super(id, creationDate);
        this.name = name;
    }

    public Sector(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Sector(Long id, LocalDate creationDate, String name, Set<Company> companies) {
        super(id, creationDate);
        this.name = name;
        this.companies = companies;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
