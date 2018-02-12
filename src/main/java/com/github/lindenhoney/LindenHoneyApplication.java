package com.github.lindenhoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@EnableReactiveMongoRepositories(basePackages = {"com.github.lindenhoney.repository"})
@SpringBootApplication(scanBasePackages = {"com.github.lindenhoney"})
public class LindenHoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LindenHoneyApplication.class, args);
    }
}
