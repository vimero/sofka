package com.sofka.person.application.usecase;

import com.sofka.person.application.domain.dto.PersonDTO;
import com.sofka.person.application.mapper.PersonMapper;
import com.sofka.person.application.port.input.PersistencePersonPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReadPersonUseCase {

    private final PersistencePersonPort persistencePersonPort;
    private final PersonMapper personMapper;

    public List<PersonDTO> read(){
        return personMapper.toDTOList(persistencePersonPort.read());
    }

}
