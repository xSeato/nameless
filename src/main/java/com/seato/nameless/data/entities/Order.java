package com.seato.nameless.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    public int id;
    private LocalDateTime orderDate;

    public Order(){

    }

}
