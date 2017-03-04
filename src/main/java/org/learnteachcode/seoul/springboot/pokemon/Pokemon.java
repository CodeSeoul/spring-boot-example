package org.learnteachcode.seoul.springboot.pokemon;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int level;
    private String name;
    private String type;
    private String color;
    //private List<Pokemon> nextEvolution; // List == a generic collection

    @Builder
    private Pokemon(int level, String name, String type, String color) {
        this.color = color;
        this.name = name;
        this.type = type;
        this.level = level;
    }
}
