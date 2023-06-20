package fr.fms.business;

import fr.fms.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IBusiness {
    public Page<Movie> getMoviesPages(String kw, int page);

    Movie getMovieById(Long id);

    void saveMovie(Movie movie);
}
