package com.sofka.customer.application.usecase;

import com.sofka.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.customer.application.exception.NotFoundException;
import com.sofka.customer.application.mapper.CustomerMapper;
import com.sofka.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final CustomerMapper customerMapper;

    public void delete(Long id) throws NotFoundException {
        CustomerEntity entity = persistenceCustomerPort.find(id);
        persistenceCustomerPort.delete(entity);
    }
}
