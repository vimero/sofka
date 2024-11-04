package com.sofka.customer.application.port.input;

import com.sofka.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.customer.application.exception.NotFoundException;

import java.util.List;

public interface PersistenceCustomerPort {

    CustomerEntity save(CustomerEntity entity);
    List<CustomerEntity> read();

    CustomerEntity find(Long id) throws NotFoundException;

    void delete(CustomerEntity entity);

}
