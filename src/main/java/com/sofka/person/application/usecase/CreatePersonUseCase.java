package com.sofka.person.application.usecase;

import com.sofka.person.application.domain.dto.PersonDTO;
import com.sofka.person.application.mapper.PersonMapper;
import com.sofka.person.application.port.input.PersistencePersonPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePersonUseCase {

    private final PersistencePersonPort persistencePersonPort;
    private final PersonMapper personMapper;

    public PersonDTO create(PersonDTO dto){
        return personMapper.toDTO(persistencePersonPort.save(personMapper.toEntity(dto)));
    }

}
