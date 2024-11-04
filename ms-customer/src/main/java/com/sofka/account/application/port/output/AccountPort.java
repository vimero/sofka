package com.sofka.account.application.port.output;

import com.sofka.account.application.domain.dto.AccountDTO;

public interface AccountPort {

    void createAccount(AccountDTO event);
}
