package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void hello(Scanner scanner) {
        System.out.print("May I have your name? ");

        String name = scanner.next();

        System.out.println("Hello, " + name + "!");
    }
}
