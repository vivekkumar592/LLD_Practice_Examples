package org.example;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Dice {

    private int noOfDice;

    Dice(int noOfDice){
        this.noOfDice = noOfDice;
    }

    public int diceRoll(){
        return ((int)(Math.random() * (6*noOfDice - 1*noOfDice))) + 1;
    }

}
