package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    Logger logger = LoggerFactory.getLogger("player");

    long min = 0;
    long max = Long.MAX_VALUE;

    public long askNextGuess() {
        this.logger.log(Long.toString((this.max + this.min) / 2));
        System.out.println((this.max + this.min) / 2);

        return (this.max + this.min) / 2;
    }

    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            this.max = (this.max+this.min) / 2;
        else
            this.min = (this.max+this.min) / 2;
    }
}
