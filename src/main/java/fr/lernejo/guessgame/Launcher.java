package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(){
        Simulation simu = new Simulation(new HumanPlayer());
        SecureRandom random = new SecureRandom();
        simu.initialize(random.nextInt(100));
        simu.loopUntilPlayerSucceed();
    }
}
