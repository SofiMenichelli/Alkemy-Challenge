package com.example.demo.repositories;

import com.example.demo.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie,Long> {
    //Movie findByMovieByName(String name);
//    List<Movie> findByGender(Long idGender);
}
