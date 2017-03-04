package org.learnteachcode.seoul.springboot.pokemon;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Pokemon {
    private int level;
    private String name;
    private String type;
    private String color;
    private String nextEvolution;
}
