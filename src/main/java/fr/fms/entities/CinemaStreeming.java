package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class CinemaStreeming implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private Date date;
    private int quantity = 1;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Movie movie  ;

}
