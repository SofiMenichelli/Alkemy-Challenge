package com.example.demo.repositories;

import com.example.demo.models.CharacterMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CharacterMovieRepository extends JpaRepository<CharacterMovie,Long> {
}
