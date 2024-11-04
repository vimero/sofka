package com.sofka.account.application.usecase.account;

import com.sofka.account.adapter.persistence.postgres.entity.AccountEntity;
import com.sofka.account.application.domain.dto.AccountDTO;
import com.sofka.account.application.mapper.AccountMapper;
import com.sofka.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public AccountDTO create(AccountDTO dto){
        AccountEntity entity =  accountMapper.toEntity(dto);

        return accountMapper.toDTO(persistenceAccountPort.save(entity));
    }

}
