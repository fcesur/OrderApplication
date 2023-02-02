package repository;

import java.util.List;

public interface EntityRepository<T> {

    List<T> getAll();

    T getById(Long id);

    T add(T entity);



}
