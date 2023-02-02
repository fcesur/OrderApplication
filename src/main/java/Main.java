import entity.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Set;

public class Main {

    static CompanyService companyService = new CompanyServiceImpl(new CompanyRepositoryImpl());
    static SectorService sectorService = new SectorServiceImpl(new SectorRepositoryImpl());
    static CustomerService customerService = new CustomerServiceImpl(new CustomerRepositoryImpl());

    static ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    static InvoiceService invoiceService = new InvoiceServiceImpl(new InvoiceRepositoryImpl());

    public static void main(String[] args) {

        createRelations();


        printAllCustomers();


        printCustomersStartsWithLetter("C");


        printTotalInvoicesByCustomerRegistrationMonth(Month.JUNE);


        printAllInvoices();


        printInvoicesOverAmount(BigDecimal.valueOf(1500));


        printAverageOfInvoicesOverAmount(BigDecimal.valueOf(1500));


        printCustomersHaveInvoicesOverAmount(BigDecimal.valueOf(500));


        printSectorsOfCompaniesHaveUnderAverageAmountOfInvoices(BigDecimal.valueOf(750));

    }

    public static void printAllCustomers() {
        System.out.println("******** All Customers **********");
        customerService.getAll().stream().forEach(c ->
                System.out.println(c.getName())
        );
    }

    public static void printCustomersStartsWithLetter(String letter) {
        System.out.println("\n******** Customers Starts With 'C' **********");
        customerService.getCustomersStartsWithLetter(letter).stream().forEach(c ->
                System.out.println(c.getName())
        );
    }

    public static void printTotalInvoicesByCustomerRegistrationMonth(Month month) {
        System.out.println("\n******** Total Invoices By Customer Registration Month : JUNE **********");
        System.out.println(invoiceService.getTotalInvoicesByCustomerRegistrationMonth(month));
    }

    public static void printAllInvoices() {
        System.out.println("\n******** Get All Invoices **********");
        invoiceService.getAll().stream().forEach(i ->
                System.out.println(i.getId() + "\t" + i.getAmount() + "\t\t" + i.getCustomer().getName())
        );
    }

    public static void printInvoicesOverAmount(BigDecimal amount) {
        System.out.println("\n******** Get Invoices Over Amount : 1500 **********");
        invoiceService.getInvoicesOverAmount(amount).stream().forEach(i ->
                System.out.println(i.getId() + "\t" + i.getAmount() + "\t" + i.getCustomer().getName())
        );
    }

    public static void printAverageOfInvoicesOverAmount(BigDecimal amount) {
        System.out.println("\n******** Get Average of Invoices Over Amount : 1500 **********");
        System.out.println(invoiceService.getAverageOfInvoicesOverAmount(amount));
    }

    public static void printCustomersHaveInvoicesOverAmount(BigDecimal amount) {
        System.out.println("\n******** Get Customers Have Invoices Under Amount : 500 **********");
        customerService.getCustomerHaveInvoiceUnderAmount(amount).stream().forEach(c ->
                System.out.println(c.getName())
        );
    }

    public static void printSectorsOfCompaniesHaveUnderAverageAmountOfInvoices(BigDecimal amount) {
        System.out.println("\n******** Get Sectors of Companies Have Under Average Amount of Invoices : 750 **********");
        sectorService.getSectorOfCompaniesHaveInvoicesUnderAverageAmount(amount).stream().forEach(s ->
                System.out.println(s.getName())
        );
    }

    public static void createRelations() {


        Company company1 = companyService.add(new Company(0L, "DefineX"));
        Company company2 = companyService.add(new Company(1L, "Trendyol"));
        Company company3 = companyService.add(new Company(2L, "LC Waikiki"));

        Sector sector1 = sectorService.add(new Sector(0L, "Danismanlik"));
        Sector sector2 = sectorService.add(new Sector(1L, "Eglence"));
        Sector sector3 = sectorService.add(new Sector(2L, "Giyim"));

        Customer customer1 = customerService.add(new Customer(0L, LocalDate.of(2023, Month.JUNE, 01), "Caner"));
        Customer customer2 = customerService.add(new Customer(1L, LocalDate.of(2023, Month.JULY, 01), "Osman"));
        Customer customer3 = customerService.add(new Customer(2L, LocalDate.of(2023, Month.AUGUST, 01), "Lale"));

        Product product1 = productService.add(new Product(0L, "Product1", BigDecimal.valueOf(499)));
        Product product2 = productService.add(new Product(1L, "Product2", BigDecimal.valueOf(8000)));
        Product product3 = productService.add(new Product(2L, "Product3", BigDecimal.valueOf(9000)));

        Invoice invoice1 = invoiceService.add(new Invoice(0L, LocalDate.of(2023, Month.JUNE, 01), company1, customer1, Arrays.asList(product1)));
        Invoice invoice2 = invoiceService.add(new Invoice(1L, LocalDate.of(2023, Month.JULY, 01), company2, customer2, Arrays.asList(product1, product2)));
        Invoice invoice3 = invoiceService.add(new Invoice(2L, LocalDate.of(2023, Month.AUGUST, 01), company3, customer3, Arrays.asList(product1, product2, product3)));


        sector1.setCompanies(Set.of(company1));
        sector2.setCompanies(Set.of(company2));
        sector3.setCompanies(Set.of(company3));

        company1.setSector(sector1);
        company2.setSector(sector2);
        company3.setSector(sector3);

        company1.setInvoices(Set.of(invoice1));
        company2.setInvoices(Set.of(invoice2));
        company3.setInvoices(Set.of(invoice3));

        customer1.setInvoices(Set.of(invoice1));
        customer2.setInvoices(Set.of(invoice2));
        customer3.setInvoices(Set.of(invoice3));


    }
}