package fr.fms.dao;

import fr.fms.entities.Cinema;
import fr.fms.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Transactional
    @Query("select r from Room r where r.cinema.id= :x")
    List<Room> findCinemaIdContains(@Param("x")Long id);
}
