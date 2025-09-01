package org.example;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Player {


    private String name;
    Player(String name){
        this.name = name;
    }
}
