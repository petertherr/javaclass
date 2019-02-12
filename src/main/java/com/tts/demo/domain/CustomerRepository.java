package com.tts.demo.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.tts.demo.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
//repository stores data/information
    List<Customer> findByLastName(String lastName);
}
