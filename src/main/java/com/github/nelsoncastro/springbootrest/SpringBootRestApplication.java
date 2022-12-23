package com.github.nelsoncastro.springbootrest;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.nelsoncastro.springbootrest.api.Person;
import com.github.nelsoncastro.springbootrest.api.PersonRepository;

@SpringBootApplication
public class SpringBootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            var persons = List.of(Person.builder()
                    .age(35)
                    .name("Zezinho")
                    .build(),
                    Person.builder()
                            .age(30)
                            .name("Huguinho")
                            .build(),
                    Person.builder()
                            .age(28)
                            .name("Luizinho")
                            .build());
            repository.saveAll(persons);
        };
    }
}
