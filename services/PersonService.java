package com.seato.nameless.services;

import com.seato.nameless.data.entities.Person;
import com.seato.nameless.data.repositories.PersonRepo;
import com.seato.nameless.exceptions.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo pr){
        this.personRepo = pr;
    }

    public void createPerson(String f, String l, String c){
        this.validateNoEmptyInput(f, l, c);

        var p = new Person(f, l, c);
        personRepo.save(p);
    }

    public Person getPersonByName(String f, String l){
        this.validateNoEmptyInput(f, l);
        return personRepo.findByFirstNameAndLastName(f, l).orElseThrow( () -> new PersonException("Benutzer " + f + " " + l + " nicht gefunden."));
    }

    public void validateNoEmptyInput(String... input){
        for(String i : input){
            if(i == null){
                throw new NullPointerException("Eingabe darf nicht leer sein");
            }
        }
    }
}
