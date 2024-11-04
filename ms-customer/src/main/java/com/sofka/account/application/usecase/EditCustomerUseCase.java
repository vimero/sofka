package com.sofka.account.application.usecase;

import com.sofka.account.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.account.application.domain.dto.CustomerDTO;
import com.sofka.account.application.exception.NotFoundException;
import com.sofka.account.application.mapper.CustomerMapper;
import com.sofka.account.application.port.input.PersistenceCustomerPort;
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
