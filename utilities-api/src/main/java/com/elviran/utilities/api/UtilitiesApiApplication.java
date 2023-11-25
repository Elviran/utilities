package com.elviran.utilities.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UtilitiesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilitiesApiApplication.class, args);
    }

}
