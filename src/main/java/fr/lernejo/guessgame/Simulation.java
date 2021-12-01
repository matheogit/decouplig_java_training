package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

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
        long nb = this.player.askNextGuess();
        if (nb == numberToGuess)
            return false;
        else if (nb > numberToGuess)
            this.player.respond(true);
        else
            this.player.respond(false);
        return true;
    }

    public void loopUntilPlayerSucceed() {
        boolean quit = true;
        while (quit){
            quit = nextRound();
        }
        this.logger.log("You got it !");
    }
}
