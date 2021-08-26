package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case (1):
                Cli.hello(scanner);
                break;

            case (2):
                EvenGame.playEvenGame(scanner);
                break;

            case (3):
                CalcGame.playCalcGame(scanner);
                break;

            default:
                break;
        }
    }
}
