package com.github.nelsoncastro.springbootrest;

import com.github.nelsoncastro.springbootrest.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootRestApplication {

    @Autowired
    PersonRepository repository;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner run() {
        return args -> {
            var persons = List.of(Person.builder().age(35).name("Zezinho").build(),
                                  Person.builder().age(30).name("Huguinho").build(),
                                  Person.builder().age(28).name("Luizinho").build());
            
            repository.saveAll(persons);
            
            final var zezinho = repository.findPersonNameDtoByName_Named("Zezinho");
            System.out.println(">>>>> " + zezinho.getId() + " - " + zezinho.getName());

            final var huginho = repository.findByName("Huguinho", PersonSummaryDTO.class);
            System.out.println(">>>>> " + huginho.getId() + " - " + huginho.getName());

            final var luizinho = repository.findPersonNameDtoByName_Interface("Luizinho");
            System.out.println(">>>>> " + luizinho.getId() + " - " + luizinho.getName());
            
            final var huginho2 = repository.findByName_native("Huguinho", PersonSummaryDTO.class);
            System.out.println(">>>>> " + huginho2.getId() + " - " + huginho2.getName());
        };
    }
}
