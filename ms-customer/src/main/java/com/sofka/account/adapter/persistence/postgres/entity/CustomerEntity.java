package com.sofka.account.adapter.persistence.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity extends PersonEntity{


    @Column(nullable = false, length = 50)
    private String clientId;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 3)
    private String status;

}
