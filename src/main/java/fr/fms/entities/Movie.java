package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String director;
    private String actor;
    private String synopsis;
    private int duration;
    private Date date = new Date();
    //private String picture;

    @OneToMany(mappedBy = "movie")
    private Collection<CinemaStreeming> cinemaStreemings;
}
