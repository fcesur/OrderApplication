package service;

import entity.Sector;

import java.math.BigDecimal;
import java.util.Set;

public interface SectorService extends EntityService<Sector> {

    Set<Sector> getSectorOfCompaniesHaveInvoicesUnderAverageAmount(BigDecimal amount);

}
