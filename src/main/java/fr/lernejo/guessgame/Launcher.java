package fr.lernejo.guessgame;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Launcher {
    public static void main(String[] args){
        if (args[0].equals("-interactive")){
            Simulation simu = new Simulation(new HumanPlayer());
            SecureRandom random = new SecureRandom();
            simu.initialize(random.nextInt(100));
            simu.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args[0].equals("-auto") && Pattern.compile("-?\\d+(\\.\\d+)?").matcher(args[1]).matches()){
            Simulation sim = new Simulation(new ComputerPlayer());
            SecureRandom random = new SecureRandom();
            sim.initialize(random.nextLong(Long.parseLong(args[1])));
            sim.loopUntilPlayerSucceed(1000);
        }
        else
        {
            System.out.println("""
                Arguments inconnus veuillez entrer en paramètre :
                -interactive pour deviner un chiffre\s
                -auto pour que l'ordinateur devine
                """);
        }
    }
}
