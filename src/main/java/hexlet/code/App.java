package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        String choice = scanner.next();

        if (choice.equals("1")) {
            Cli.hello(scanner);
        } else if (choice.equals("2")) {
            EvenGame.playEvenGame(scanner);
        } else if (choice.equals("3")) {
            CalcGame.playCalcGame(scanner);
        } else if (choice.equals("4")) {
            GCDGame.playGCDGame(scanner);
        } else if (choice.equals("5")) {
            ProgressionGame.playProgressionGame(scanner);
        } else if (choice.equals("6")) {
            PrimeGame.playPrimeGame(scanner);
        }
    }
}
