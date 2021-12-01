package fr.lernejo.guessgame;

import java.util.Scanner;

import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.logger.Logger;

public class HumanPlayer implements Player{
    Logger logger = LoggerFactory.getLogger("player");
    Scanner scanner = new Scanner(System.in);

    public long askNextGuess() {
        System.out.println("Enter number");
        return this.scanner.nextLong();
    }

    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            this.logger.log("Lower");
        else
            this.logger.log("Greater");
    }
}
