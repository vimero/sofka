package com.sofka.person.adapter.persistence;

import com.sofka.person.adapter.persistence.postgres.entity.PersonEntity;
import com.sofka.person.adapter.persistence.postgres.repository.PersonRepository;
import com.sofka.person.application.exception.NotFoundException;
import com.sofka.person.application.port.input.PersistencePersonPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersistencePersonAdapter implements PersistencePersonPort {

    private final PersonRepository personRepository;

    @Override
    public PersonEntity save(PersonEntity entity) {
        if (entity.getId() == null) {
            entity.setId(getCode());
        }
        return personRepository.save(entity);
    }

    @Override
    public List<PersonEntity> read() {
        return personRepository.findByActiveTrue();
    }

    @Override
    public PersonEntity find(String id) throws NotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person " + id + " not found"));
    }

    @Override
    public void delete(PersonEntity entity) {
        entity.setActive(false);
        personRepository.save(entity);
    }

    private String getCode() {
        return String.format("P%09d", personRepository.count() + 1);
    }

}
