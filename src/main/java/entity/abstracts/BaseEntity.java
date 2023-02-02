package entity.abstracts;

import java.time.LocalDate;

public abstract class BaseEntity {

    Long id;

    LocalDate creationDate = LocalDate.now();

    LocalDate modificationDate;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity(Long id, LocalDate creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }
}
