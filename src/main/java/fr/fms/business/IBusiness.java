package fr.fms.business;

import fr.fms.entities.*;
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

    List<Cinema> findAllContainsCityId(Long id);

    List<Room> findAllContainsCinemaId(Long id);

    List<CinemaStreeming> findAllContainsRoomId(Long id);

    CinemaStreeming getCinemaStreemingById(Long id);

}
