package com.sofka.account.application.usecase;

import com.sofka.account.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.account.application.exception.NotFoundException;
import com.sofka.account.application.mapper.CustomerMapper;
import com.sofka.account.application.port.input.PersistenceCustomerPort;
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
