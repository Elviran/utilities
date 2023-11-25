package com.elviran.utilities.api.services;

import com.elviran.utilities.api.repositories.ElectricityBillRepository;
import com.elviran.utilities.api.documents.ElectricityBill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.elviran.utilities.api.utils.DateUtils.endOfYear;
import static com.elviran.utilities.api.utils.DateUtils.startOfYear;

@Slf4j
@Service
public class ElectricityBillService {

    private final ElectricityBillRepository electricityBillRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ElectricityBillService(ElectricityBillRepository repository, SequenceGeneratorService sequenceGeneratorService) {
        this.electricityBillRepository = repository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public ElectricityBill create(ElectricityBill bill) {
        bill.setId(sequenceGeneratorService.generateSequence(ElectricityBill.SEQUENCE_NAME));
        return electricityBillRepository.save(bill);
    }

    public ElectricityBill fetchBill(Long id) {
        Optional<ElectricityBill> bill = electricityBillRepository.findById(id);
        return bill.orElse(null);
    }

    public List<ElectricityBill> fetchAllBills() {
        return electricityBillRepository.findAll();
    }

    public List<ElectricityBill> fetchBillsByDateBetween(LocalDate from, LocalDate to) {
        return electricityBillRepository.findElectricityBillByDateAddedBetween(from, to);
    }


    public List<ElectricityBill> fetchAllBillsFromYear(Integer year) {
        LocalDate start = LocalDate.from(startOfYear(year).toInstant());
        LocalDate end = LocalDate.from(endOfYear(year).toInstant());
        return fetchBillsByDateBetween(start, end);
    }


}
