package com.sofka.customer.application.domain.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;

    private String fullName;

    private String gender;

    private int age;

    private String identification;

    private String address;

    private String phone;

    private String clientId;

    private String password;

    private String status;

}
