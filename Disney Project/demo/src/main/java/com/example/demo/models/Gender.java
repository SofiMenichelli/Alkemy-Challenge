package com.example.demo.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String nameGender;

    public Gender(){}

    public Gender(String nameGender) {
        this.nameGender = nameGender;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }


}
