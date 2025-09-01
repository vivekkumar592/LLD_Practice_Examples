package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Game {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String, Integer> currentPosition;
    int boardSize ;

    Game(Dice dice,Queue<Player> nextTurn,List<Jumper> snakes, List<Jumper> ladders, Map<String, Integer> currentPosition, int boardSize)
    {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.currentPosition = currentPosition;
        this.boardSize = boardSize;
    }
    void GameStart(){
        while(nextTurn.size() > 1){
            Player currentPlayer = nextTurn.poll();
            int nextRoll = dice.diceRoll();
            System.out.println("dice rolling......................"+ nextRoll);
            int nextPosition = currentPosition.get(currentPlayer.getName()) + nextRoll;
            if(nextPosition > boardSize)
                nextPosition = currentPosition.get(currentPlayer.getName());
            else {
                boolean notBitten = true;
                boolean firstInstance = true;
                while (firstInstance || !notBitten) {
                    notBitten=true;
                    for (int i = 0; i < snakes.size(); i++) {
                        if (i == snakes.size() - 1) firstInstance = false;
                        if (snakes.get(i).getStartPosition() == nextPosition) {
                            System.out.println(currentPlayer.getName() + " is bitten by snake at "+ nextPosition+ " and your new position is "+snakes.get(i).getEndPosition());
                            nextPosition = snakes.get(i).getEndPosition();

                            notBitten = false;
                        }
                    }
                }
                firstInstance = true;
                boolean ladderClimbed = false;
                while (firstInstance || ladderClimbed) {
                    ladderClimbed = false;
                    for (int i = 0; i < ladders.size(); i++) {
                        if (i == ladders.size() - 1) firstInstance = false;
                        if (snakes.get(i).getStartPosition() == nextPosition) {
                            System.out.println(currentPlayer.getName() + " has founder a ladder at "+ nextPosition+ " and your new position is "+ladders.get(i).getEndPosition());
                            nextPosition = ladders.get(i).getEndPosition();
                            ladderClimbed = true;
                        }
                    }
                }
            }
            if(nextPosition == boardSize)
            {System.out.println(currentPlayer.getName() + " has won the match.....");
                return;}
            System.out.println(currentPlayer.getName() + " is in "+nextPosition);
            currentPosition.put(currentPlayer.getName(), nextPosition);
            nextTurn.offer(currentPlayer);

        }
    }



}
