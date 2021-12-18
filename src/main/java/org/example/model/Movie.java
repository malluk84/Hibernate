package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "MOVIE_TABLE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(unique = true)
    private String title;
    // PRODUCTION_YEAR
    @Column(name = "PRODUCTION_YEAR")
    private Integer productionYear;
    private String type;
    private Integer time;

    @OneToOne(mappedBy = "movie")
    private Reviewer reviewer;

    @ManyToOne
    private Author author;

    @ManyToMany
    private List<Actor> actors;

    public String toString() {
        return "Movie(id=" + this.getId() + ", title=" + this.getTitle() + ", productionYear=" + this.getProductionYear() + ", type=" + this.getType() + ", time=" + this.getTime() + ")";
    }


}
