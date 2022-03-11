package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player{
    Logger logger = LoggerFactory.getLogger("player");
    private long max;
    private long min;
    private long prev;
    private boolean isGreater;
    public ComputerPlayer(long max_count){
        max = max_count;
        min = -1;
        isGreater = false;
    }

    @Override
    public long askNextGuess(){
        long guess = -1;
        if(min == -1l){
            guess = max/2;
            min = 0;
        }else{
            min = isGreater ? prev : min;
            max = !isGreater ? prev : max;
            guess = (min+max)/2;
        }
        prev = guess;
        logger.log("Computer propose "+guess);
        return guess;
    }
    @Override
    public void respond(boolean lowerOrGreater){
        if (lowerOrGreater){
            logger.log("Plus grand");
        }
        else{
            logger.log("Plus petit");
        }
    }
}
