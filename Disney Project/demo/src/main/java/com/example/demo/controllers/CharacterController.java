package com.example.demo.controllers;

import com.example.demo.dtos.CharacterDTO;
import com.example.demo.dtos.CharacterMovieDTO;
import com.example.demo.dtos.MovieDTO;
import com.example.demo.models.Character;
import com.example.demo.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CharacterController {
    @Autowired
    CharacterRepository characterRepository;

    //Busco todos los personajes
    @GetMapping("/characters")
    public List<CharacterDTO> getListCharacters() {
        return characterRepository.findAll().stream().map(CharacterDTO::new).collect(Collectors.toList());
    }

    //Busco un personaje por id
    @GetMapping("/character/{id}")
    public CharacterDTO getCharacter(@PathVariable Long id) {
        return new CharacterDTO(characterRepository.findById(id).orElse(null));
    }

    @GetMapping("/characName/{name}")
    public CharacterDTO getCharactersByName(@PathVariable("name") String name) {
        System.out.println(name);
        return new CharacterDTO(characterRepository.findByName(name));
    }

    @GetMapping("/characAge/{age}")
    public List<Character> getCharactersByAge(@PathVariable("age") int age) {
        return new ArrayList<>(characterRepository.findByAge(age));
    }
    @GetMapping("/characMovies/{movies}")
    public List<MovieDTO> getCharactersByMovie(@PathVariable("movies") Long idCharacter) {
        Character character = characterRepository.findById(idCharacter).orElse(null);
        if(character != null) {
            return character.getCharacterMovies().stream().map(x -> new MovieDTO(x.getMovie())).collect(Collectors.toList());
        }
        return null;
    }

    //Agrego un nuevo personaje
    @PostMapping("/addCharacter")
    public ResponseEntity<?> addCharacter(@RequestParam String image,
                                          @RequestParam String name,
                                          @RequestParam int age,
                                          @RequestParam String history
                                          ) {

        if (image == null || name == null || age <= 0 || history == null) {
            return new ResponseEntity<>("Complete all fills", HttpStatus.FORBIDDEN);
        }

        characterRepository.save(new Character(image, name, age, history));
        return new ResponseEntity<>("Character created", HttpStatus.CREATED);
    }

    //Modifico algun dato de un personaje
    @PutMapping("/editCharacter")
    public ResponseEntity<?> editCharacter(@RequestParam Long id,
                                           @RequestParam String image,
                                           @RequestParam String history,
                                           @RequestParam int age) {

        Character character = characterRepository.findById(id).orElse(null);

        if (character == null) {
            return new ResponseEntity<>("The character don't exist", HttpStatus.NOT_FOUND);
        }

        character.setImage(image);
        character.setHistory(history);
        character.setAge(age);
        characterRepository.save(character);

        return new ResponseEntity<>("Character modified correctly", HttpStatus.ACCEPTED);

    }

    //Borramos el personaje, solamente si no tiene relacion con una pelicula.
    @DeleteMapping("/deleteCharacter")
    public ResponseEntity<?> deleteCharacter(@RequestParam Long id) {

        Character character = characterRepository.findById(id).orElse(null);

        if (character == null) {
            return new ResponseEntity<>("The character don't exist", HttpStatus.NOT_FOUND);
        }
        characterRepository.delete(character);
        return new ResponseEntity<>("Confirm Delete", HttpStatus.ACCEPTED);
    }
}