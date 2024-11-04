package com.sofka.customer.application.usecase;

import com.sofka.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.customer.application.domain.dto.CustomerDTO;
import com.sofka.customer.application.exception.NotFoundException;
import com.sofka.customer.application.mapper.CustomerMapper;
import com.sofka.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final CustomerMapper customerMapper;

    public CustomerDTO edit(Long id, String fullName) throws NotFoundException {
        CustomerEntity entity = persistenceCustomerPort.find(id);
        entity.setFullName(fullName);
        return customerMapper.toDTO(persistenceCustomerPort.save(entity));
    }
}
