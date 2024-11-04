package com.sofka.account.application.mapper;

import com.sofka.account.adapter.persistence.postgres.entity.AccountEntity;
import com.sofka.account.application.domain.dto.AccountDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountEntity toEntity(AccountDTO dto);
    AccountDTO toDTO(AccountEntity entity);

    List<AccountDTO> toDTOList(List<AccountEntity> list);
}
