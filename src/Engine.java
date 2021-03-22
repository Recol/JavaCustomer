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

	public boolean itemSelect() {
		Stock.Stock_Items[] stockItems = Stock.Stock_Items.values();
		itemDisplay();
		int userChoice = Input.getInt(0, stockItems.length);
		Stock.Stock_Items purchasedItem = stockItems[userChoice];
		System.out.println(purchasedItem.getName() + " has been purchased for " + purchasedItem.getPrice() + "!");
		sendOrderConfirmationEmail();
		return true;
	}

	public void sendOrderConfirmationEmail(){
		System.out.println("Order Confirmed - Receipt sent to #####"); // get user email if login/registration implemented?
	}

	public void itemDisplay(){
		Stock.Stock_Items[] stockItems = Stock.Stock_Items.values();

		int id = 0;
		for (Stock.Stock_Items item : stockItems){
			System.out.println(id +": " + item.getName()+", " + item.getPrice());
			id++;
		}
	}

	public void cpuDisplay(){
		Stock.Stock_Items[] stockItems = Stock.Stock_Items.values();
		int id = 0;
		for (Stock.Stock_Items item : stockItems){
			if(item.getType().equals("CPU")) {
				System.out.println(id + ": " + item.getName() + ", " + item.getPrice());
				id++;
			}
		}
	}
	public void gpuDisplay(){
		Stock.Stock_Items[] stockItems = Stock.Stock_Items.values();
		int id = 0;
		for (Stock.Stock_Items item : stockItems){
			if(item.getType() == "GPU") {
				System.out.println(id + ": " + item.getName() + ", " + item.getPrice());
				id++;
			}
		}
	}
}