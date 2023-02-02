package repository.impl;


import entity.Invoice;
import repository.InvoiceRepository;
import java.util.ArrayList;
import java.util.List;


public class InvoiceRepositoryImpl implements InvoiceRepository {


    private static final List<Invoice> invoices = new ArrayList<>();


    @Override
    public List<Invoice> getAll() {
        return invoices.stream().toList();
    }

    @Override
    public Invoice getById(Long id) {
        return invoices.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Invoice add(Invoice entity) {
        return invoices.add(entity) ? entity : null;
    }




}
