package com.elviran.utilities.api.repositories;

import com.elviran.utilities.api.documents.ElectricityBill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ElectricityBillRepository extends MongoRepository<ElectricityBill, Long> {
    List<ElectricityBill> findElectricityBillByDateAddedBetween(LocalDate from, LocalDate to);

}
