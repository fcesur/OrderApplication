package service.impl;

import entity.Sector;
import repository.SectorRepository;
import service.SectorService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static util.constant.BigDecimalCompareConstants.LESS;

public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;

    public SectorServiceImpl(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }


    @Override
    public List<Sector> getAll() {
        return sectorRepository.getAll();
    }

    @Override
    public Sector getById(Long id) {
        return sectorRepository.getById(id);
    }

    @Override
    public Sector add(Sector entity) {
        return sectorRepository.add(entity);
    }

    @Override
    public Set<Sector> getSectorOfCompaniesHaveInvoicesUnderAverageAmount(BigDecimal amount) {
        return sectorRepository.getAll()
                .stream()
                .flatMap(s ->
                        s.getCompanies()
                                .stream()
                                .filter(c ->
                                        c.getAverageInvoice().compareTo(amount) == LESS
                                )
                                .map(c -> c.getSector())
                )
                .collect(Collectors.toSet());
    }
}
