package com.sofka.account.application.usecase.account;

import com.sofka.account.adapter.persistence.postgres.entity.AccountEntity;
import com.sofka.account.application.exception.NotFoundException;
import com.sofka.account.application.mapper.AccountMapper;
import com.sofka.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public void delete(Long id) throws NotFoundException {
        AccountEntity entity = persistenceAccountPort.find(id);
        persistenceAccountPort.delete(entity);
    }
}
