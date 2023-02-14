package com.seato.nameless.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Person {
    @Id
    private int id;

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    private String contactMail;

    @OneToMany
    @JoinColumn
    private Set<Order> orders = new HashSet<>();

    public Person(String f, String l, String c){
        this();
        this.firstName = f;
        this.lastName= l;
        this.contactMail = c;
    }
}
