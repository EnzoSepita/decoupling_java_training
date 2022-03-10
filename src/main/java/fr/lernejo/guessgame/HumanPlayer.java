package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    Logger logger = LoggerFactory.getLogger("player");
    @Override
    public long askNextGuess(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Entrer un nombre :");
       return scanner.nextInt();
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
