package org.learnteachcode.seoul.springboot.pokemon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokemonController {

    @RequestMapping("/pokemon")
    public Pokemon getDefaultPokemon() {
        List<Pokemon> evolutionList = new ArrayList<>();
        evolutionList.add(Pokemon.builder()
            .color("yellow")
            .name("Raichu")
            .type("electric")
            .build());

        Pokemon myPokemon = Pokemon.builder()
                .color("blue")
                .level(5)
                .nextEvolution(evolutionList)
                .name("Pikachu")
                .type("electric")
                .build();

        return myPokemon;
    }
}
