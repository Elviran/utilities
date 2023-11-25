package com.elviran.utilities.api.documents;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Document(collection = "electricity_bill")
public class ElectricityBill {

    @Transient
    public static final String SEQUENCE_NAME = "electricity_bill_sequence";

    @Id
    private Long id;

    private LocalDate dateAdded;
    private Double amount;

    public ElectricityBill(Long id, LocalDate dateAdded, Double amount) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ElectricityBill{" +
                "id='" + id + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
