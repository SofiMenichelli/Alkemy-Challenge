package com.example.demo.dtos;

import com.example.demo.models.Movie;
import com.example.demo.models.Character;
import com.example.demo.models.CharacterMovie;


public class CharacterMovieDTO {
    private long id;
    private Character character;
    private Movie movie;

    public CharacterMovieDTO(CharacterMovie characterMovie){
        this.id= characterMovie.getId();
        this.character= characterMovie.getCharacter();
        this.movie= characterMovie.getMovie();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
