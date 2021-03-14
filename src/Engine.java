import java.util.HashMap;
import java.util.Scanner;

public class Engine {
	Display display_object = new Display();
	
	public void Menu_Output() {
	HashMap<String, String >menu = new HashMap<String, String>();
	menu.put("1", "1: Buy a CPU");
	menu.put("2", "2: Buy a GPU");
	menu.put("3", "3: List all hardware");
	menu.put("4", "4: Exit");

	menu.values().stream().forEach(System.out::println);
	}

	public void login_menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your email address?");
		String user = scan.nextLine();
		System.out.println("What is your password?");
		String pass = scan.nextLine(); // looks at selected file in scan

		String inpUser = user;
		String inpPass = pass; // gets input from user

		if (inpUser.equals(user) && inpPass.equals(pass)) {
			System.out.print("Input validated.");
			System.out.println();
			System.out.println("Welcome: " + user);
		} else {
			System.out.print("Invalid login.");
			login_menu();
			scan.close();
		}
		
	}

	//TODO Integrate with how items displayed in Engine
	public void itemSelect(){
		// Engine.SelectionOutput(); // placeholder for menu
		Scanner itemPicker = new Scanner(System.in);
		System.out.println("Please select the item you wish to buy:");
		String userChoice = itemPicker.nextLine();

		/*
		 if (itemList.contains(userchoice){
			Engine.purchase(userChoice)
			Cart.addToCart(userChoice) // if cart implemented
		*/
		System.out.println(userChoice + " has been purchased!");
		itemPicker.close();
	}
}
