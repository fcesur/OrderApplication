package service;

import entity.Invoice;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public interface InvoiceService extends EntityService<Invoice> {
    List<Invoice> getInvoicesOverAmount(BigDecimal amount);

    BigDecimal getAverageOfInvoicesOverAmount(BigDecimal amount);

    BigDecimal getTotalInvoicesByCustomerRegistrationMonth(Month month);
}
