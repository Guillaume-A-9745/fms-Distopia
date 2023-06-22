package fr.fms;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.*;
import fr.fms.entities.City;
import fr.fms.entities.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DistopiaApplicationTests {
	@Autowired
	CityRepository cityRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	CinemaStreemingRepository cinemaStreemingRepository;

	@Autowired
	IBusinessImpl iBusiness;

	@Test
	void contextLoads() {}

	@Test
	void test_add_movie() {
		//GIVEN
		Movie elementaire = movieRepository.save(new Movie(null,"Élémentaire","Peter Sohn","Leah Lewis, Mamoudou Athie, Ronnie Del Carmen","Dans la ville d’Element City, le feu, l’eau, la terre et l’air vivent dans la plus parfaite harmonie.",102,new Date(),null));

		//WHEN
		Movie movie = movieRepository.findByNameContains("Élémentaire");

		//THEN
		assertEquals("Peter Sohn", movie.getDirector());
	}

	@Test
	void test_add_city() {
		//GIVEN
		City Nice = cityRepository.save(new City(null,"Nice",null));

		//WHEN
		Iterable<City> cities = cityRepository.findAll();

		//THEN
		assertThat(cities).isNotEmpty();
	}
}
