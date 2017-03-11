package org.learnteachcode.seoul.springboot.pokemon.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.learnteachcode.seoul.springboot.pokemon.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id")
    )
    @JsonIgnore
    List<Pokemon> pokemonList;

    public Type(String name) {
        this.name = name;
    }
}
