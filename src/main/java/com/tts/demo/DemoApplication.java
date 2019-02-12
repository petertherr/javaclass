package com.tts.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tts.demo.domain.Customer;
import com.tts.demo.domain.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository repository) {
        return args -> {
            //save a couple customer
            repository.save( new Customer("Jimmy", "Dang"));
            repository.save( new Customer("Joe", "Doe"));
            repository.save( new Customer("Jimbo", "Limbo"));
            repository.save( new Customer("Jenny", "Dangy"));

            //read all customers
            log.info("Customers found with findAll():");
            log.info("--------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            //read an individual customer by ID
            repository.findById(1L)
                .ifPresent(customer -> {
                    log.info("Customer found with findById(1L):");
                    log.info("---------------------------------");
                    log.info(customer.toString());
                    log.info("");
                    });

            //read customer by last name
            log.info("Customers found with findByLastName('Dang'):");
            log.info("--------------------------------");
            repository.findByLastName("Dang").forEach(bauer -> {
                log.info(bauer.toString());
            });
                log.info("");
        };
    }
}

