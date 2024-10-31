package com.sofka.person.application.port.input;

import com.sofka.person.adapter.persistence.postgres.entity.PersonEntity;
import com.sofka.person.application.exception.NotFoundException;

import java.util.List;

public interface PersistencePersonPort {

    PersonEntity save(PersonEntity entity);
    List<PersonEntity> read();

    PersonEntity find(String id) throws NotFoundException;

    void delete(PersonEntity entity);

}
