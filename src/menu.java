

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		String option = "";
		/**
		 * This will load in the necessary class objects which will be accessed via instantiation.
		 */
		Engine engine_object = new Engine();
		Stock object_CPU = new Stock();
		Stock object_GPU = new Stock();
		engine_object.login_menu();
		indent();
		System.out.println("Hardware Shop");

		do {		Scanner input = new Scanner(System.in);

			engine_object.Menu_Output();
			option = input.nextLine();
			switch(option) {
			case "1":
				/**
				 * Load in the CPU class to load CPU entities which will be used for sale.
				 */
				engine_object.itemSelect();
				break;
			case "2":
				/**
				 * Load in the GPU class to load GPU entities which will be used for sale.
				 */
				engine_object.itemSelect();
				break;
			case "3":
				/*
				 * Load in all the classes which hold hardware data for option 3.
				 */
				engine_object.itemSelect();
				break;
			case "4":
				/**
				 * Exit the program
				 */
				System.out.println("System now shutting down");
				System.exit(0);
			default:
				System.out.println("Invalid option - please try again.");
				break;
			}
		} while (true); }

		public static void indent() {
			System.out.println();
		}
	}


