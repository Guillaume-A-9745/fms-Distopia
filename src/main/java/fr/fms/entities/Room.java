package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int places;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "room")
    private Collection<CinemaStreeming> cinemaStreemings;
}
