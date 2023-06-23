package fr.fms;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CityRepository;
import fr.fms.dao.MovieRepository;
import fr.fms.entities.City;
import fr.fms.entities.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class DistopiaTest {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    MovieRepository movieRepository;
    @MockBean
    IBusinessImpl iBusiness;

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
