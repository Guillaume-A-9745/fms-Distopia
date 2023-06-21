package fr.fms.dao;

import fr.fms.entities.CinemaStreeming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CinemaStreemingRepository extends JpaRepository<CinemaStreeming, Long> {

    @Transactional
    @Query("select c from CinemaStreeming c where c.room.id= :x")
    List<CinemaStreeming> findRoomIdContains(@Param("x")Long id);
}
