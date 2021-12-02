package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

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
        long nb = this.player.askNextGuess();
        if (nb == numberToGuess)
            return false;
        else if (nb > numberToGuess)
            this.player.respond(true);
        else
            this.player.respond(false);
        return true;
    }

    public void loopUntilPlayerSucceed(long max_iteration) {
        boolean quit = true;
        long iteration = 0;

        long start = System.currentTimeMillis();

        while (quit){
            quit = nextRound();
            iteration++;
            if (iteration == max_iteration){
                this.logger.log("You failed !");
                return;
            }
        }
        long end = System.currentTimeMillis();
        long time = end - start;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");
        String date = simpleDateFormat.format(new Date(time));

        this.logger.log("win" + date);
    }
}
