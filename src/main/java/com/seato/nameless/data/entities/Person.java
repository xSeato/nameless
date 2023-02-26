package com.seato.nameless.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;

    public Person(String f, String l, String c){
        this();
        this.firstName = f;
        this.lastName= l;
        this.mail = c;
    }
}
