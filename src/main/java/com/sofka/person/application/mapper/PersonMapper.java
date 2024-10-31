package com.sofka.person.application.mapper;

import com.sofka.person.adapter.persistence.postgres.entity.PersonEntity;
import com.sofka.person.application.domain.dto.PersonDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonEntity toEntity(PersonDTO dto);
    PersonDTO toDTO(PersonEntity entity);

    List<PersonDTO> toDTOList(List<PersonEntity> list);
}
