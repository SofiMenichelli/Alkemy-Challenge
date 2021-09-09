package com.example.demo.dtos;

import com.example.demo.models.Character;
import java.util.HashSet;
import java.util.Set;


public class CharacterDTO {
    private long id;
    private String image;
    private String name;
    private int age;
    private String history;
    private Set<CharacterMovieDTO> characterMovieSetDto= new HashSet<>();

    public CharacterDTO(){}

    public CharacterDTO(Character character){
        this.id = character.getId();
        this.image=character.getImage();
        this.name= character.getName();
        this.age = character.getAge();
        this.history = character.getHistory();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Set<CharacterMovieDTO> getCharacterMovieSetDto() {
        return characterMovieSetDto;
    }

    public void setCharacterMovieSetDto(Set<CharacterMovieDTO> characterMovieSetDto) {
        this.characterMovieSetDto = characterMovieSetDto;
    }
}
