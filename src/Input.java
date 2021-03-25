import java.util.Scanner;

public class Input {
	static Scanner scanner = new Scanner(System.in);

	public static int getInt(int minRange, int maxRange) {
		int number = 0;

		do {
			try {
				System.out.println("Please make your selection:");
				while (!scanner.hasNextInt()) {
					System.out.println("Please enter a valid number!");
					scanner.nextLine();
				}
				number = scanner.nextInt();
			} catch (Exception ex) {
				System.out.println("A fatal exception has occurred.");
				ex.getStackTrace();
			}
		} while (number < minRange && number > maxRange);
		return number;
		/**
		 * Verify that the input range being targeted does not exceed the menu options.
		 */
	}

	public static String getString() {
		String inputString;
		while (!scanner.hasNextLine()) {
			scanner.nextLine();
		}
		inputString = scanner.nextLine();
		return inputString;
	}
}