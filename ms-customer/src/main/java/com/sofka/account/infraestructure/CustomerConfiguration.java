package com.sofka.account.infraestructure;

import com.sofka.account.application.mapper.CustomerMapper;
import com.sofka.account.application.port.input.PersistenceCustomerPort;
import com.sofka.account.application.usecase.CreateCustomerUseCase;
import com.sofka.account.application.usecase.DeleteCustomerUseCase;
import com.sofka.account.application.usecase.EditCustomerUseCase;
import com.sofka.account.application.usecase.ReadCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Bean
    CreateCustomerUseCase createCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, CustomerMapper customerMapper){
        return new CreateCustomerUseCase(persistenceCustomerPort, customerMapper);
    }

    @Bean
    ReadCustomerUseCase readCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, CustomerMapper customerMapper){
        return new ReadCustomerUseCase(persistenceCustomerPort, customerMapper);
    }

    @Bean
    EditCustomerUseCase editCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, CustomerMapper customerMapper){
        return new EditCustomerUseCase(persistenceCustomerPort, customerMapper);
    }

    @Bean
    DeleteCustomerUseCase deleteCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, CustomerMapper customerMapper){
        return new DeleteCustomerUseCase(persistenceCustomerPort, customerMapper);
    }

}
