package com.elviran.utilities.api.controllers;

import com.elviran.utilities.api.documents.ElectricityBill;
import com.elviran.utilities.api.services.ElectricityBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/electricity-bills")
public class ElectricityBillController {

    private final ElectricityBillService electricityBillService;

    private ElectricityBillController(ElectricityBillService electricityBillService) {
        this.electricityBillService = electricityBillService;
    }

    @PostMapping(value = "/create", consumes = {"application/json"})
    public ResponseEntity<?> createElectricityBill(@RequestBody ElectricityBill electricityBill) {
        ElectricityBill bill = electricityBillService.create(electricityBill);
        return ResponseEntity.ok(bill);
    }

    //add caching here before calling controller or before method.
    @GetMapping(value = "/get")
    public ResponseEntity<?> fetchAllElectricityBills() {
        List<ElectricityBill> bills = electricityBillService.fetchAllBills();
        return ResponseEntity.ok(bills);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getElectricityBill(@PathVariable Long id) {
        ElectricityBill bills = electricityBillService.fetchBill(id);
        return ResponseEntity.ok(bills);
    }

    @GetMapping(value = "/get/all/{year}")
    public ResponseEntity<?> getElectricityBillsByYear(@PathVariable Integer year) {
        List<ElectricityBill> bills = electricityBillService.fetchAllBillsFromYear(year);
        return ResponseEntity.ok(bills);
    }

    @GetMapping(value = "/get/{from}/{to}")
    public ResponseEntity<?> getElectricityBillsBetweenDates(@PathVariable LocalDate from, @PathVariable LocalDate to) {
        List<ElectricityBill> bills = electricityBillService.fetchBillsByDateBetween(from, to);
        return ResponseEntity.ok(bills);
    }


}
