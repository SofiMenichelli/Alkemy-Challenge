package com.example.demo;

import com.example.demo.models.Character;
import com.example.demo.models.CharacterMovie;
import com.example.demo.models.Gender;
import com.example.demo.models.Movie;
import com.example.demo.repositories.CharacterMovieRepository;
import com.example.demo.repositories.CharacterRepository;
import com.example.demo.repositories.GenderRepository;
import com.example.demo.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DisneyApplication {

	public static void main(String[] args) {

		SpringApplication.run(DisneyApplication.class, args);
		System.out.println("Welcome Disney");
	}
// Command Line Runner//

    @Bean
	public CommandLineRunner initData(CharacterRepository characterRepository, GenderRepository genderRepository, MovieRepository movieRepository, CharacterMovieRepository characterMovieRepository){
		return args -> {


			Character minnie=new Character("assets/minnie","Minnie",500,"Su novio es Mickey Mouse");
			characterRepository.save(minnie);
			Character donald=new Character("assets/Donald","Donald",60,"Es el mejor personaje de Disney");
			characterRepository.save(donald);
			Character mickey=new Character("assets/mickey","Mickey Mouse",500,"Su novia es Minnie");
			characterRepository.save(mickey);
			Character hannah=new Character("assets/hannah","Hannah Montana",30,"Actriz Joven que inicio como personaje de Disney");
			characterRepository.save(hannah);

			Gender dibujos_animados=new Gender("Dibujos Animados");
			genderRepository.save(dibujos_animados);
			Gender comedia=new Gender("Comedia");
			genderRepository.save(comedia);
			Gender infantil=new Gender("Infantil");
			genderRepository.save(infantil);
			Gender musical=new Gender("Musical");
			genderRepository.save(musical);

		    Movie hockey_champ=new Movie("assets/hockeyChamp","Hockey Champ",5,dibujos_animados);
			movieRepository.save(hockey_champ);
			Movie hight_school_musical=new Movie("assets/highSchoolMusical","Hight School Musical",5,musical);
			movieRepository.save(hight_school_musical);
			Movie mickey_mouse_y_amigos=new Movie("assets/mickeyYAmigos","Mickey Mouse y Amigos",5,dibujos_animados);
			movieRepository.save(mickey_mouse_y_amigos);
			Movie laCasaDeMM=new Movie("assets/mickeyYAmigos","La Casa De Mickey Mouse",5,dibujos_animados);
			movieRepository.save(laCasaDeMM);
			Movie hannah_montana=new Movie("assets/hannahMontana","Hannah Montana",5,musical);
			movieRepository.save(hannah_montana);
			Movie hannah_montana2=new Movie("assets/hannahMontana","Hannah Montana 2",5,musical);
			movieRepository.save(hannah_montana2);

			CharacterMovie chrMov1=new CharacterMovie(mickey,mickey_mouse_y_amigos);
			characterMovieRepository.save(chrMov1);
			CharacterMovie chrMov2=new CharacterMovie(minnie,mickey_mouse_y_amigos);
			characterMovieRepository.save(chrMov2);
			CharacterMovie chrMov3=new CharacterMovie(hannah,hannah_montana);
			characterMovieRepository.save(chrMov3);
			CharacterMovie chrMov4=new CharacterMovie(hannah,hannah_montana2);
			characterMovieRepository.save(chrMov4);
			CharacterMovie chrMov5=new CharacterMovie(minnie,laCasaDeMM);
			characterMovieRepository.save(chrMov5);
			CharacterMovie chrMov6=new CharacterMovie(mickey,laCasaDeMM);
			characterMovieRepository.save(chrMov6);

		};
	}
}
