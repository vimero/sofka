package com.sofka.account.application.usecase;

import com.sofka.account.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.account.application.domain.dto.CustomerDTO;
import com.sofka.account.application.mapper.CustomerMapper;
import com.sofka.account.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final CustomerMapper customerMapper;

    public CustomerDTO create(CustomerDTO dto){
        CustomerEntity entity =  customerMapper.toEntity(dto);
        return customerMapper.toDTO(persistenceCustomerPort.save(entity));
    }

}
