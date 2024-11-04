package com.sofka.account.application.usecase.account;

import com.sofka.account.application.domain.dto.AccountDTO;
import com.sofka.account.application.mapper.AccountMapper;
import com.sofka.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReadAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public List<AccountDTO> read(){
        return accountMapper.toDTOList(persistenceAccountPort.read());
    }

}
