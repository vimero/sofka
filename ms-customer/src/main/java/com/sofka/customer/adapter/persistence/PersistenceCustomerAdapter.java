package com.sofka.customer.adapter.persistence;

import com.sofka.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.customer.adapter.persistence.postgres.repository.CustomerRepository;
import com.sofka.customer.application.exception.NotFoundException;
import com.sofka.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersistenceCustomerAdapter implements PersistenceCustomerPort {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return customerRepository.save(entity);
    }

    @Override
    public List<CustomerEntity> read() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity find(Long id) throws NotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer " + id + " not found"));
    }

    @Override
    public void delete(CustomerEntity entity) {
        entity.setActive(false);
        customerRepository.save(entity);
    }

}
