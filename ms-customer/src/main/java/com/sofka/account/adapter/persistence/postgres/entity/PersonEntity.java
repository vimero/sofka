package com.sofka.account.adapter.persistence.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, length = 1)
    private String gender;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 20)
    private String identification;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private boolean active;

}
