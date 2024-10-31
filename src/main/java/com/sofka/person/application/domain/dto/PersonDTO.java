package com.sofka.person.application.domain.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonDTO {

    private String id;

    @Size(min = 0, max = 50)
    private String firstName;

    @Size(min = 0, max = 50)
    private String lastName;


}
