package org.example;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Jumper {

    private int startPosition;
    private int endPosition;

    Jumper(int startPosition, int endPosition){
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

}
