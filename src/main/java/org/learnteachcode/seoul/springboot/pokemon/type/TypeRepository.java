package org.learnteachcode.seoul.springboot.pokemon.type;

import org.springframework.data.repository.CrudRepository;

public interface TypeRepository
        extends CrudRepository<Type, Long> {
}
