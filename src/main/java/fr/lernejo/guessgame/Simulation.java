package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long num = player.askNextGuess();
        if (numberToGuess == num) {
            logger.log("gagné");
            return true;
        }
        if (numberToGuess > num){
            player.askNextGuess();
        }
        else
        {
            player.respond(false);
        }

        return false;
    }

    public void loopUntilPlayerSucceed() {
        boolean res;
        do{
            res = nextRound();
        }while (res == false);
    }
}
