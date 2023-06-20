package fr.fms.business;

import fr.fms.entities.City;
import fr.fms.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBusiness {
    Page<Movie> getMoviesPages(String kw, int page);

    Movie getMovieById(Long id);

    void saveMovie(Movie movie);

    void deleteArticle(Long id);

    List findAll();
}
