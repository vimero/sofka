package com.sofka.account.adapter.rest;


import com.sofka.account.application.domain.dto.CustomerDTO;
import com.sofka.account.application.exception.NotFoundException;
import com.sofka.account.application.usecase.CreateCustomerUseCase;
import com.sofka.account.application.usecase.DeleteCustomerUseCase;
import com.sofka.account.application.usecase.EditCustomerUseCase;
import com.sofka.account.application.usecase.ReadCustomerUseCase;
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
@RequestMapping("/api/v1/customers")
public class CustomerRest {

    private CreateCustomerUseCase createCustomerUseCase;
    private ReadCustomerUseCase readCustomerUseCase;
    private EditCustomerUseCase editCustomerUseCase;
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @GetMapping
    public List<CustomerDTO> read(){
        return readCustomerUseCase.read();
    }

    @PutMapping("/{id}")
    public CustomerDTO edit(@PathVariable("id")Long id, @RequestParam String fullName) throws NotFoundException {
        return editCustomerUseCase.edit(id, fullName);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) throws NotFoundException {
        deleteCustomerUseCase.delete(id);
    }

    @PostMapping
    public CustomerDTO create(@Valid @RequestBody CustomerDTO request){
        return createCustomerUseCase.create(request);
    }

}
