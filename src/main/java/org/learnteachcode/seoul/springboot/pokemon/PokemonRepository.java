package org.learnteachcode.seoul.springboot.pokemon;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonRepository extends
        CrudRepository<Pokemon, Long>{
    List<Pokemon> findByName(String name);
}
