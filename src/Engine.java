import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.Formatter;

public class Engine {
	StockInterface stockSelection;
	private final List<String[]> stockItems;

	public Engine(StockInterface stockSelection){
		this.stockSelection = stockSelection;
		stockItems = this.stockSelection.getFileData();
	}

	public void menuOutput() {
		HashMap<String, String> menu = new HashMap<String, String>();
		menu.put("1", "1: List CPUs");
		menu.put("2", "2: List GPUs");
		menu.put("3", "3: Buy Hardware (CPU & GPU)");
		menu.put("4", "4: Exit");
		menu.values().stream().forEach(System.out::println);
	}

	public boolean itemSelect() {
		int userChoice = Input.getInt(0, stockItems.size());
		String[] purchasedItem = stockItems.get(userChoice);
		System.out.println(purchasedItem[1] + " has been purchased for " + purchasedItem[2] + "!");
		sendOrderConfirmationEmail();
		return true;
	}

	public void sendOrderConfirmationEmail() {
		System.out.println("Order Confirmed - Receipt sent!"); // get user email if login/registration
																		// implemented?
	}

	public void itemDisplay() {
		int id = 0;
		for (String[] item : this.stockItems) {
			System.out.println(id + ": " + item[1] + ", " + item[2]);
			id++;
		}
	}

	public void cpuDisplay() {
		int id = 0;
		for(String[] item : this.stockItems) {
			if (item[3].equals("CPU")) {
				System.out.println(id + ": " + item[1] + ", " + item[2]);
				id++;
			}
		}
	}

	public void gpuDisplay() {
		int id = 0;
		for(String[] item : this.stockItems) {
			if (item[3].equals("GPU")) {
				System.out.println(id + ": " + item[1] + ", " + item[2]);
				id++;
			}
		}
	}
}