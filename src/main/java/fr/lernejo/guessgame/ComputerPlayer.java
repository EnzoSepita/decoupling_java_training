package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player{
    Logger logger = LoggerFactory.getLogger("player");
    private long max = Long.MAX_VALUE;
    private long min = Long.MIN_VALUE;

    @Override
    public long askNextGuess(){
        return(min + max)/2;
    }
    @Override
    public void respond(boolean lowerOrGreater){
        if (lowerOrGreater){
            logger.log("Plus grand");
            min = askNextGuess();
        }
        else{
            logger.log("Plus petit");
            max = askNextGuess();
        }
    }
}
