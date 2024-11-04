package com.sofka.account.application.usecase.account;

import com.sofka.account.adapter.persistence.postgres.entity.AccountEntity;
import com.sofka.account.application.domain.dto.AccountDTO;
import com.sofka.account.application.exception.NotFoundException;
import com.sofka.account.application.mapper.AccountMapper;
import com.sofka.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public AccountDTO edit(Long id, double balance) throws NotFoundException {
        AccountEntity entity = persistenceAccountPort.find(id);
        entity.setBalance(balance);
        return accountMapper.toDTO(persistenceAccountPort.save(entity));
    }
}
