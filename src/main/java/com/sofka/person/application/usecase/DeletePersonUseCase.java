package com.sofka.person.application.usecase;

import com.sofka.person.adapter.persistence.postgres.entity.PersonEntity;
import com.sofka.person.application.exception.NotFoundException;
import com.sofka.person.application.mapper.PersonMapper;
import com.sofka.person.application.port.input.PersistencePersonPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeletePersonUseCase {

    private final PersistencePersonPort persistencePersonPort;
    private final PersonMapper personMapper;

    public void delete(String id) throws NotFoundException {
        PersonEntity entity = persistencePersonPort.find(id);
        persistencePersonPort.delete(entity);
    }
}
