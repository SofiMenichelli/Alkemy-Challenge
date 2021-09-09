package com.example.demo.controllers;

import com.example.demo.dtos.MovieDTO;
import com.example.demo.models.Gender;
import com.example.demo.models.Movie;
import com.example.demo.repositories.GenderRepository;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenderRepository genderRepository;

    @GetMapping("/movies")
    public List<MovieDTO> getListOfMovies() {
        return movieRepository.findAll().stream().map(MovieDTO::new).collect(Collectors.toList());
    }

    //Busco un personaje por id
    @GetMapping("/movie/{id}")
    public MovieDTO getMovie(@PathVariable Long id) {
        return new MovieDTO(movieRepository.findById(id).orElse(null));
    }

/*    @GetMapping("/movieName")
    public MovieDTO getMoviesByName(@PathVariable String name) {
        return new MovieDTO(movieRepository.findByMovieByName(name));
    }*/

   /* @GetMapping("/moviesIdGenero")
    public List<MovieDTO> getMoviesByGender(@PathVariable Long id) {
        Gender gender = genderRepository.findById(id).orElse(null);
        if(gender == null) {
            return null;
        }
        return movieRepository.findByGender(gender.getId());
    }
*/
    //Agrego una nueva pelicula o serie
   @PostMapping("/addMovie")
    public ResponseEntity<?> addCharacter(@RequestBody Movie movie) {

        if (movie.getImageMovie() == null || movie.getCalification() <= 0 || movie.getGender() == null || movie.getTittleMovie() == null) {
            return new ResponseEntity<>("Complete all fills", HttpStatus.UNAUTHORIZED);
        }

        movieRepository.save(new Movie(movie.getImageMovie(), movie.getTittleMovie(), movie.getCalification(), movie.getGender()));
        return new ResponseEntity<>("Movie created", HttpStatus.CREATED);
    }

    //Modifico algun dato de una pelicula
    @PutMapping("/editMovie")
    public ResponseEntity<?> editMovie(@RequestParam Long id,
                                           @RequestParam String image,
                                           @RequestParam int calification) {

        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie == null) {
            return new ResponseEntity<>("The movie don't exist", HttpStatus.NOT_FOUND);
        }

        movie.setImageMovie(image);
        movie.setCalification(calification);
        movieRepository.save(movie);

        return new ResponseEntity<>("The Movie has modified", HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteMovie")
    public ResponseEntity<?> deleteMovie(@RequestParam Long id) {

        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie == null) {
            return new ResponseEntity<>("The character don't exist", HttpStatus.NOT_FOUND);
        }
        movieRepository.delete(movie);
        return new ResponseEntity<>("Movie deleted", HttpStatus.ACCEPTED);
    }
}
