package com.elviran.utilities.api.sequence;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;
}
