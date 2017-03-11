package org.learnteachcode.seoul.springboot.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.learnteachcode.seoul.springboot.pokemon.type.Type;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String color;

    @ManyToMany
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id")
    )
    List<Type> types;

    @JsonIgnore
    @OneToOne
    private Pokemon challenger;

    @JsonIgnore
    @OneToOne(mappedBy = "challenger")
    private Pokemon challengedBy;

    @Builder
    private Pokemon(int level,
                    String name,
                    String color,
                    Pokemon challenger,
                    List<Type> types) {
        this.color = color;
        this.name = name;
        this.level = level;
        this.challenger = challenger;
        if(types == null)
            this.types = new ArrayList<>();
        else
            this.types = types;
    }
}
