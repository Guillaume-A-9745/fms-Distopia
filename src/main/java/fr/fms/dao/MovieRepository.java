package fr.fms.dao;

import fr.fms.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Page<Movie> findByNameContains(String kw, PageRequest of);
}
