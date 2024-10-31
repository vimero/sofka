package com.sofka.person.adapter.persistence.postgres.repository;

import com.sofka.person.adapter.persistence.postgres.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository <PersonEntity, String>{

    List<PersonEntity> findByActiveTrue();

}
