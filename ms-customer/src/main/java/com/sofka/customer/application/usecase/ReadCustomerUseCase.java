package com.sofka.customer.application.usecase;

import com.sofka.customer.application.domain.dto.CustomerDTO;
import com.sofka.customer.application.mapper.CustomerMapper;
import com.sofka.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReadCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final CustomerMapper customerMapper;

    public List<CustomerDTO> read(){
        return customerMapper.toDTOList(persistenceCustomerPort.read());
    }

}
