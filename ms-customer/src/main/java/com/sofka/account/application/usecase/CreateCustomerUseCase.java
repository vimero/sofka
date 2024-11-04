package com.sofka.account.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.account.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.account.application.domain.dto.AccountDTO;
import com.sofka.account.application.domain.dto.CustomerDTO;
import com.sofka.account.application.domain.type.AccountStatus;
import com.sofka.account.application.domain.type.AccountType;
import com.sofka.account.application.mapper.CustomerMapper;
import com.sofka.account.application.port.input.PersistenceCustomerPort;
import com.sofka.account.application.port.output.AccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final AccountPort accountPort;
    private final CustomerMapper customerMapper;

    public CustomerDTO create(CustomerDTO dto){
        log.info("Create customer");
        CustomerEntity entity = persistenceCustomerPort.save(customerMapper.toEntity(dto));
        AccountDTO account = AccountDTO.builder()
                .customer(entity.getId())
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVINGS)
                .build();
        accountPort.createAccount(account);
        return customerMapper.toDTO(entity);
    }

}
