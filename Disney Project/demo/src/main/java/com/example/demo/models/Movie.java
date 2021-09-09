package com.example.demo.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String imageMovie;
    private String tittleMovie;
    //Calificacion podria ser un ENUM
    private int calification;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gender")
    private Gender gender;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private Set<CharacterMovie> characterMovie = new HashSet<>();

    public Movie(){}


    public Movie(String imageMovie, String tittleMovie, int calification, Gender gender) {
        this.imageMovie = imageMovie;
        this.tittleMovie = tittleMovie;
        this.calification = calification;
        this.gender=gender;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImageMovie() {
        return imageMovie;
    }

    public void setImageMovie(String imageMovie) {
        this.imageMovie = imageMovie;
    }

    public String getTittleMovie() {
        return tittleMovie;
    }

    public void setTittleMovie(String tittleMovie) {
        this.tittleMovie = tittleMovie;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public Set<CharacterMovie> getCharacterMovie() {
        return characterMovie;
    }

    public void setCharacterMovie(Set<CharacterMovie> characterMovie) {
        this.characterMovie = characterMovie;
    }
}
