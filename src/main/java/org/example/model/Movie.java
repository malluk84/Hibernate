package org.example.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "MOVIE_TABLE")
public class Movie {
    @Id
    @GeneratedValue()
    private Integer id;
    @Column(unique = true)
    private String title;
    // PRODUCTION_YEAR
    @Column(name = "PRODUCTION_YEAR")
    private Integer productionYear;
    private String type;
    private Integer time;
}
