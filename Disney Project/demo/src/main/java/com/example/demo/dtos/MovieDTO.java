package com.example.demo.dtos;

import com.example.demo.models.Movie;
import java.util.HashSet;
import java.util.Set;

public class MovieDTO {
    private Long id;
    private GenderDTO genderDTO;
    private String imageMovie;
    private String tituloMovie;
    private int calification;
    private Set<CharacterMovieDTO> characterMovieDTOS = new HashSet<>();

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.genderDTO = new GenderDTO(movie.getGender());
        this.imageMovie = movie.getImageMovie();
        this.tituloMovie = movie.getTittleMovie();
        this.calification = movie.getCalification();
    }

    public Long getId() {
        return id;
    }

    public GenderDTO getGenderDTO() {
        return genderDTO;
    }

    public void setGenderDTO(GenderDTO genderDTO) {
        this.genderDTO = genderDTO;
    }

    public String getImageMovie() {
        return imageMovie;
    }

    public void setImageMovie(String imageMovie) {
        this.imageMovie = imageMovie;
    }

    public String getTituloMovie() {
        return tituloMovie;
    }

    public void setTituloMovie(String tituloMovie) {
        this.tituloMovie = tituloMovie;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public Set<CharacterMovieDTO> getCharacterMovieDtos() {
        return characterMovieDTOS;
    }

    public void setCharacterMovieDtos(Set<CharacterMovieDTO> characterMovieDTOS) {
        this.characterMovieDTOS = characterMovieDTOS;
    }
}
