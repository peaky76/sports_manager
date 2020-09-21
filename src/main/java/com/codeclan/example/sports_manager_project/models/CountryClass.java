package com.codeclan.example.sports_manager_project.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class CountryClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public CountryClass(String name) {
        this.name = name;
    }

    public CountryClass(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
