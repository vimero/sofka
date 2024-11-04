package com.sofka.account.application.port.input;

import com.sofka.account.adapter.persistence.postgres.entity.AccountEntity;
import com.sofka.account.application.exception.NotFoundException;

import java.util.List;

public interface PersistenceAccountPort {

    AccountEntity save(AccountEntity entity);
    List<AccountEntity> read();

    AccountEntity find(Long id) throws NotFoundException;

    void delete(AccountEntity entity);

}
