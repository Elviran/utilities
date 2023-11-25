package com.elviran.utilities.api.services;

import com.elviran.utilities.api.repositories.ElectricityBillRepository;
import com.elviran.utilities.api.documents.ElectricityBill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.elviran.utilities.api.utils.DateUtils.endOfYear;
import static com.elviran.utilities.api.utils.DateUtils.startOfYear;

@Slf4j
@Service
public class ElectricityBillService {

    ElectricityBillRepository electricityBillRepository;

    @Autowired
    public ElectricityBillService(ElectricityBillRepository repository) {
        this.electricityBillRepository = repository;
    }

    public ElectricityBill create(ElectricityBill bill) {
        return electricityBillRepository.save(bill);
    }

    public ElectricityBill fetchBill(Integer id) {
        Optional<ElectricityBill> bill = electricityBillRepository.findById(id);
        return bill.orElse(null);
    }

    public List<ElectricityBill> fetchAllBills() {
        return electricityBillRepository.findAll();
    }

    public List<ElectricityBill> fetchBillsByDateBetween(LocalDate from, LocalDate to) {
        return electricityBillRepository.findElectricityBillByDateAddedBetween(from.toString(), to.toString());
    }

    public List<ElectricityBill> fetchBillsByDateBetween(String from, String to) {
        return electricityBillRepository.findElectricityBillByDateAddedBetween(from, to);
    }

    public List<ElectricityBill> fetchAllBillsFromYear(Integer year) {
        // get year, start from first january till end of december
        String start = startOfYear(year);
        String end = endOfYear(year);
        return fetchBillsByDateBetween(start, end);
    }


}
