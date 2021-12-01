package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args){
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        Simulation simulation = new Simulation(new HumanPlayer());
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();
    }
}
