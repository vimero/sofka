package com.sofka.account.infraestructure;

import com.sofka.account.application.mapper.AccountMapper;
import com.sofka.account.application.port.input.PersistenceAccountPort;
import com.sofka.account.application.usecase.account.CreateAccountUseCase;
import com.sofka.account.application.usecase.account.DeleteAccountUseCase;
import com.sofka.account.application.usecase.account.EditAccountUseCase;
import com.sofka.account.application.usecase.account.ReadAccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfiguration {

    @Bean
    CreateAccountUseCase createAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new CreateAccountUseCase(persistenceAccountPort, accountMapper);
    }

    @Bean
    ReadAccountUseCase readAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new ReadAccountUseCase(persistenceAccountPort, accountMapper);
    }

    @Bean
    EditAccountUseCase editAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new EditAccountUseCase(persistenceAccountPort, accountMapper);
    }

    @Bean
    DeleteAccountUseCase deleteAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new DeleteAccountUseCase(persistenceAccountPort, accountMapper);
    }

}
