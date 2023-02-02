package service.impl;

import entity.Customer;
import entity.Invoice;
import repository.InvoiceRepository;
import service.InvoiceService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import static util.constant.BigDecimalCompareConstants.GREATER;

public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }

    @Override
    public Invoice getById(Long id) {
        return invoiceRepository.getById(id);
    }

    @Override
    public Invoice add(Invoice entity) {
        return invoiceRepository.add(entity);
    }

    @Override
    public List<Invoice> getInvoicesOverAmount(BigDecimal amount) {
        return invoiceRepository.getAll().stream()
                .filter(i -> i.getAmount().compareTo(amount) == GREATER)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getAverageOfInvoicesOverAmount(BigDecimal amount) {
        List<BigDecimal> total = getInvoicesOverAmount(amount)
                .stream()
                .map(Invoice::getAmount)
                .toList();

        if (total.size() == 0)
            return BigDecimal.ZERO;

        return total.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(total.size()), RoundingMode.UNNECESSARY);
    }

    @Override
    public BigDecimal getTotalInvoicesByCustomerRegistrationMonth(Month month) {
        return invoiceRepository.getAll()
                .stream()
                .map(Invoice::getCustomer)
                .filter(c -> c.getCreationDate().getMonthValue() == month.getValue())
                .map(Customer::getTotalInvoiceAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
