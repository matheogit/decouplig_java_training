package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args){
        if (args.length == 0){
            help();
            return;
        }

        switch (args[0]){
            case "-interactive":
                SecureRandom random = new SecureRandom();
                long randomNumber = random.nextInt(100);
                Simulation simulation_player = new Simulation(new HumanPlayer());
                simulation_player.initialize(randomNumber);
                simulation_player.loopUntilPlayerSucceed(Long.MAX_VALUE);
                break;
            case "-auto":
                try {
                    Simulation simulation_computer = new Simulation(new ComputerPlayer());
                    simulation_computer.initialize(Long.parseLong(args[1]));
                    simulation_computer.loopUntilPlayerSucceed(1000);
                } catch (NumberFormatException e) {
                    help();
                    return;
                }
                break;
            default:
                help();
        }
    }
    public static void help(){
        System.out.println("Use -interactive or -auto 'number'");
    }
}
