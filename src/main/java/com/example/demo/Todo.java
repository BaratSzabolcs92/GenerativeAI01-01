package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;

}

