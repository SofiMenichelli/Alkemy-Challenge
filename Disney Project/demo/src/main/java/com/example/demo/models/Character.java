package com.example.demo.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String image;
    private String name;
    private int age;
    private String history;

    @OneToMany(mappedBy="character", fetch=FetchType.EAGER)
    Set<CharacterMovie> characterMovies= new HashSet<>();

    public Character(){}

    public Character(String image, String name, int age, String history) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.history = history;
    }

    public Character(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<CharacterMovie> getCharacterMovies() {
        return characterMovies;
    }

    public void setCharacterMovies(Set<CharacterMovie> characterMovies) {
        this.characterMovies = characterMovies;
    }
}
