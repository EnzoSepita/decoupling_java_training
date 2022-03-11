package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


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
        logger.log("Guess was : " + num);
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

    public void loopUntilPlayerSucceed(long max_iter) {
        boolean res;
        long start = System.currentTimeMillis();
        long i = 0;
        do{
            res = nextRound();
            i++;
            if(i >= max_iter) {
                break;
            }
        }while (res == false);
        long end = System.currentTimeMillis();
        Date time = new Date(end-start);
        DateFormat format = new SimpleDateFormat("mm:ss.SSS");
        System.out.println("La partie s'est terminé en :" + format);
        if (res)
        {
            System.out.println("Vous avez trouvé la solution en " + i + " fois.");
        }
        else
        {
            System.out.println("Vous n'avez pas trouvé la solution avant la limite");
        }
    }
}
