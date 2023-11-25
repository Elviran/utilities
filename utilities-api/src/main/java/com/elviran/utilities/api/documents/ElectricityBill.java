package com.elviran.utilities.api.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class ElectricityBill {

    @Id
    private String id;

    private String dateAdded;
    private String amount;

    public ElectricityBill(String id, String dateAdded, String amount) {
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
