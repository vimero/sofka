package com.sofka.person.adapter.rest;


import com.sofka.person.application.domain.dto.PersonDTO;
import com.sofka.person.application.exception.NotFoundException;
import com.sofka.person.application.usecase.CreatePersonUseCase;
import com.sofka.person.application.usecase.DeletePersonUseCase;
import com.sofka.person.application.usecase.EditPersonUseCase;
import com.sofka.person.application.usecase.ReadPersonUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/people")
public class PersonRest {

    private CreatePersonUseCase createPersonUseCase;
    private ReadPersonUseCase readPersonUseCase;
    private EditPersonUseCase editPersonUseCase;
    private DeletePersonUseCase deletePersonUseCase;

    @GetMapping
    public List<PersonDTO> read(){
        return readPersonUseCase.read();
    }

    @PutMapping("/{id}")
    public PersonDTO edit(@PathVariable("id")String id, @RequestParam String lastName) throws NotFoundException {
        return editPersonUseCase.edit(id, lastName);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")String id) throws NotFoundException {
        deletePersonUseCase.delete(id);
    }

    @PostMapping
    public PersonDTO create(@Valid @RequestBody PersonDTO request){
        return createPersonUseCase.create(request);
    }

}
