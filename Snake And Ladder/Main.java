package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

         Player vivek= new Player("vivek") ;
         Player aditi = new Player("aditi");
         Dice dice = new Dice(2);
         List<Jumper> snakes = new ArrayList<>();
        List<Jumper> ladders = new ArrayList<>();
        Map<String, Integer> currentPosition= new HashMap<>();
         Jumper snake1 = new Jumper(5,3);
         Jumper snake2 = new Jumper(8,2);
         Jumper ladder1 = new Jumper(4,9);
         Jumper ladder2 = new Jumper(6,7);

         snakes.add(snake1);
         snakes.add(snake2);

         ladders.add(ladder1);
         ladders.add(ladder2);
        Queue<Player> nextTurn = new LinkedList<>();
        nextTurn.offer(vivek);
        nextTurn.offer(aditi);
        currentPosition.put("vivek",0);
        currentPosition.put("aditi",0);

         Game game = new Game(dice,nextTurn,snakes,ladders,currentPosition,10);
         game.GameStart();


    }
}