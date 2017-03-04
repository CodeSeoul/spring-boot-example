package org.learnteachcode.seoul.springboot.pokemon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @RequestMapping("/pokemon")
    public Pokemon getDefaultPokemon() {
        Pokemon myPokemon = Pokemon.builder()
                .color("blue")
                .level(5)
                .nextEvolution("Raichu")
                .name("Pikachu")
                .type("electric")
                .build();

        return myPokemon;
    }
}
