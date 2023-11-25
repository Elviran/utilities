package com.elviran.utilities.api.repositories;

import com.elviran.utilities.api.documents.ElectricityBill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectricityBillRepository extends MongoRepository<ElectricityBill, Integer> {
    List<ElectricityBill> findElectricityBillByDateAddedBetween(String from, String to);

}
