package service;

import java.util.List;

public interface EntityService<T> {

    List<T> getAll();

    T getById(Long id);

    T add(T entity);

}
