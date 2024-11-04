package com.sofka.account.application.port.input;

import com.sofka.account.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.account.application.exception.NotFoundException;

import java.util.List;

public interface PersistenceCustomerPort {

    CustomerEntity save(CustomerEntity entity);
    List<CustomerEntity> read();

    CustomerEntity find(Long id) throws NotFoundException;

    void delete(CustomerEntity entity);

}
