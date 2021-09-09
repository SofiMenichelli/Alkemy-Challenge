package com.example.demo.dtos;

import com.example.demo.models.Gender;

public class GenderDTO {
    private Long id;
    private String nameGender;

    public GenderDTO() {
    }

    public GenderDTO(Gender gender) {
        this.id = gender.getId();
        this.nameGender = gender.getNameGender();
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
