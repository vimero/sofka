package com.sofka.person.application.usecase;

import com.sofka.person.adapter.persistence.postgres.entity.PersonEntity;
import com.sofka.person.application.domain.dto.PersonDTO;
import com.sofka.person.application.exception.NotFoundException;
import com.sofka.person.application.mapper.PersonMapper;
import com.sofka.person.application.port.input.PersistencePersonPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditPersonUseCase {

    private final PersistencePersonPort persistencePersonPort;
    private final PersonMapper personMapper;

    public PersonDTO edit(String id, String lastName) throws NotFoundException {
        PersonEntity entity = persistencePersonPort.find(id);
        entity.setLastName(lastName);
        return personMapper.toDTO(persistencePersonPort.save(entity));
    }
}
