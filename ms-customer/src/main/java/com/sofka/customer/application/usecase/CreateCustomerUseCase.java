package com.sofka.customer.application.usecase;

import com.sofka.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.customer.application.domain.dto.CustomerDTO;
import com.sofka.customer.application.mapper.CustomerMapper;
import com.sofka.customer.application.port.input.PersistenceCustomerPort;
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
