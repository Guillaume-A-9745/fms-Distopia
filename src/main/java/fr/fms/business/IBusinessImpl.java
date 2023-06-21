package fr.fms.business;

import fr.fms.dao.*;
import fr.fms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IBusinessImpl implements IBusiness{
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    CinemaStreemingRepository cinemaStreemingRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Page<Movie> getMoviesPages(String kw, int page) {
        return movieRepository.findByNameContains(kw , PageRequest.of(page, 5));
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> optional = movieRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteArticle(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List findAll() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    @Override
    public List<Cinema> findAllContainsCityId(Long id) {
        List<Cinema> cinemas = cinemaRepository.findCityIdContains(id);
        return cinemas;
    }

    @Override
    public List<Room> findAllContainsCinemaId(Long id) {
        List<Room> rooms = roomRepository.findCinemaIdContains(id);
        return rooms;
    }

    @Override
    public List<CinemaStreeming> findAllContainsRoomId(Long id) {
        List<CinemaStreeming> cinemaStreemings = cinemaStreemingRepository.findRoomIdContains(id);
        return cinemaStreemings;
    }

    @Override
    public CinemaStreeming getCinemaStreemingById(Long id) {
        Optional<CinemaStreeming> cinemaStreeming = cinemaStreemingRepository.findById(id);
        return cinemaStreeming.isPresent() ? cinemaStreeming.get() : null;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
