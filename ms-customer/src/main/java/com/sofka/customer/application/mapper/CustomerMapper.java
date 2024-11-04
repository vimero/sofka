package com.sofka.customer.application.mapper;

import com.sofka.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.sofka.customer.application.domain.dto.CustomerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerEntity toEntity(CustomerDTO dto);
    CustomerDTO toDTO(CustomerEntity entity);

    List<CustomerDTO> toDTOList(List<CustomerEntity> list);
}
