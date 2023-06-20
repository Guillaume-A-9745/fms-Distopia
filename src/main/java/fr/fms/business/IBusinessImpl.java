package fr.fms.business;

import fr.fms.dao.*;
import fr.fms.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
}
