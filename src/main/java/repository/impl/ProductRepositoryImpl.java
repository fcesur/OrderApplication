package repository.impl;

import entity.Product;
import repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {


    private static final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return products.stream().toList();
    }

    @Override
    public Product getById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product add(Product entity) {
        return products.add(entity) ? entity : null;
    }
}
