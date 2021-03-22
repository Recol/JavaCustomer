import java.util.Scanner;

public class Input {
    public static int getInt(Scanner scanner, int minRange, int maxRange){
        int number;
        do {
            System.out.println("Please make your selection.");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
            }
            number = scanner.nextInt();
        } while (number < minRange && number > maxRange);
        return number;
    }
}