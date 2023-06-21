package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class CinemaStreeming implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timetable;
    private double price;

    private LocalDate date;
    private int quantity = 1;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Movie movie  ;

    public String formattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return date.format(formatter);
    }

}
