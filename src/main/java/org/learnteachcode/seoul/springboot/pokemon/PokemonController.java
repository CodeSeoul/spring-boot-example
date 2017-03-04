package org.learnteachcode.seoul.springboot.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @RequestMapping("/pokemon")
    public List<Pokemon> getAllPokemon(
            @RequestParam(name = "name", defaultValue = "all")
            String pokemonName) {
        if(pokemonName.equals("all"))
            return repository.findAll();
        return repository.findByName(pokemonName);
    }

    @RequestMapping("/pokemon/create")
    public void getDefaultPokemon() {
        Pokemon raichu = Pokemon.builder()
                .name("Raichu")
                .type("electric")
                .color("yellow")
                .level(10)
                .build();
        repository.save(raichu);

        Pokemon myPokemon = Pokemon.builder()
                .color("blue")
                .level(5)
                .name("Pikachu")
                .type("electric")
                .build();
        repository.save(myPokemon);
    }
}
