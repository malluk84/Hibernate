package org.example.model;

import lombok.*;

import javax.persistence.*;

//maybe dummy but we will try one to one
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @OneToOne
    private Movie movie;
}
