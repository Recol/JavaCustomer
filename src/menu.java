

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		String option = "";
		
		/**
		 * This will load in the necessary class objects which will be accessed via instantiation.
		 */
			
			Engine engine_object = new Engine();
			CPU object_CPU = new CPU();
			GPU object_GPU = new GPU();
			
			engine_object.login_menu();
			identation();
			Scanner input = new Scanner(System.in);
			
			do {
				System.out.println("Hardware Shop");
				identation();
				
				engine_object.Menu_Output();
				option = input.nextLine();
				switch(option) {
				case "1":
					/**
					 * Load in the CPU class to load CPU entities which will be used for sale.
					 */
					object_CPU.CPU_Items();
					engine_object.itemSelect();
					break;
				case "2": 
					/**
					 * Load in the GPU class to load GPU entities which will be used for sale.
					 */
					object_GPU.GPU_Items();
					engine_object.itemSelect();
					break;
			case "3":
				/*
				 * Load in all the classes which hold hardware data for option 3.
				 */
				object_CPU.CPU_Items();
				object_GPU.GPU_Items();
				engine_object.itemSelect();

				break;
			case "4": 
				/**
				 * Exit the program
				 */
				System.out.println("System now shutting down");
				input.close();
				System.exit(0);
				break;
				}
			}while (!option.equals("4"));
			
		}
			public static void identation() {
				System.out.println("");
			/**
			 * Used as an accessible whitespace for the menu.
			 */
			}
	}


