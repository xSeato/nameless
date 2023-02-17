package com.seato.nameless.api;

import com.seato.nameless.data.entities.Person;
import com.seato.nameless.data.repositories.PersonRepo;
import com.seato.nameless.exceptions.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class PersonController {

    private final PersonRepo personRepo;

    @Autowired
    public PersonController(PersonRepo pr){
        this.personRepo = pr;
    }

    @GetMapping("/persons")
    public Set<Person> all(){
        var persons = new HashSet<Person>();
        this.personRepo.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable Long id){
        return personRepo.findById(id).orElseThrow( () -> {
            throw new PersonException("Person nicht gefunden");
        });
    }

    @PostMapping("/employees")
    Person newPerson(@RequestBody Person p) {
        return personRepo.save(p);
    }



}
