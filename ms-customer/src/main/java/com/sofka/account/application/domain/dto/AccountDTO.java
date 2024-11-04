package com.sofka.account.application.domain.dto;

import com.sofka.account.application.domain.type.AccountStatus;
import com.sofka.account.application.domain.type.AccountType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class AccountDTO {

    private Long customer;
    private AccountType type;
    private AccountStatus status;

}
