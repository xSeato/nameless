package com.seato.nameless.data.repositories;

import com.seato.nameless.data.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepo extends CrudRepository<Person, Long> {
    Optional<Person> findByFirstNameAndLastName(String fn, String ln);
}
