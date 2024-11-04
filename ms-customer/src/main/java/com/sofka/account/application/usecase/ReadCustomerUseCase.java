package com.sofka.account.application.usecase;

import com.sofka.account.application.domain.dto.CustomerDTO;
import com.sofka.account.application.mapper.CustomerMapper;
import com.sofka.account.application.port.input.PersistenceCustomerPort;
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
