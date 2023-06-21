package fr.fms.dao;

import fr.fms.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    @Transactional
    @Query("select c from Cinema c where c.city.id= :x")
    public List<Cinema> findCityIdContains(@Param("x")Long id);

}
