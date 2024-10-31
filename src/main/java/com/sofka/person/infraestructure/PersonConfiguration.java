package com.sofka.person.infraestructure;

import com.sofka.person.application.mapper.PersonMapper;
import com.sofka.person.application.port.input.PersistencePersonPort;
import com.sofka.person.application.usecase.CreatePersonUseCase;
import com.sofka.person.application.usecase.DeletePersonUseCase;
import com.sofka.person.application.usecase.EditPersonUseCase;
import com.sofka.person.application.usecase.ReadPersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {

    @Bean
    CreatePersonUseCase createPersonUseCase(PersistencePersonPort persistencePersonPort, PersonMapper personMapper){
        return new CreatePersonUseCase(persistencePersonPort, personMapper);
    }

    @Bean
    ReadPersonUseCase listPersonUseCase(PersistencePersonPort persistencePersonPort, PersonMapper personMapper){
        return new ReadPersonUseCase(persistencePersonPort, personMapper);
    }

    @Bean
    EditPersonUseCase editPersonUseCase(PersistencePersonPort persistencePersonPort, PersonMapper personMapper){
        return new EditPersonUseCase(persistencePersonPort, personMapper);
    }

    @Bean
    DeletePersonUseCase deletePersonUseCase(PersistencePersonPort persistencePersonPort, PersonMapper personMapper){
        return new DeletePersonUseCase(persistencePersonPort, personMapper);
    }

}
