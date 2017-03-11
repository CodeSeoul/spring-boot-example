package org.learnteachcode.seoul.springboot.pokemon;

import org.learnteachcode.seoul.springboot.pokemon.type.Type;
import org.learnteachcode.seoul.springboot.pokemon.type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private TypeRepository typeRepository;

    @RequestMapping("/pokemon")
    public List<Pokemon> getAllPokemon(
            @RequestParam(name = "name", defaultValue = "all")
            String pokemonName) {
        if(pokemonName.equals("all"))
            return pokemonRepository.findAll();
        return pokemonRepository.findByName(pokemonName);
    }

    @RequestMapping("/pokemon/create")
    public void getDefaultPokemon() {
        Type electric = new Type("electric");
        electric = typeRepository.save(electric);
        List<Type> typeList = new ArrayList<>();
        typeList.add(electric);

        Pokemon raichu = Pokemon.builder()
                .name("Raichu")
                .types(typeList)
                .color("yellow")
                .level(10)
                .build();
        pokemonRepository.save(raichu);

        Pokemon myPokemon = Pokemon.builder()
                .color("blue")
                .level(5)
                .name("Pikachu")
                .types(typeList)
                .challenger(raichu)
                .build();
        pokemonRepository.save(myPokemon);
    }
}
