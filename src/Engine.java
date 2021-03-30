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

	public void register_menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("Registration Page");
		System.out.printf("Username: ");
		String user = input.next();
		System.out.printf("Password: ");
		String pass = input.next();
		System.out.printf("Confirm Password: ");
		String conf = input.next();
		int length = pass.length();
		int passInt = Integer.parseInt(pass);
		int confInt = Integer.parseInt(conf);
		File file = new File("C:"+File.separator + "Users"+File.separator + "Passwords"+File.separator + "Downloads"+File.separator + "accounts.txt");
		if (length < 6) {
			System.out.println("Too short password, password must be 6 characters or more");
		} else {
			if (passInt == confInt) {

				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String current;
					boolean checkname = false;
					while ((current = br.readLine()) != null) {
						if(current.equalsIgnoreCase(user)){
							checkname = true;
						}
					}
					if (checkname) {
						System.out.println("Username already exists, please type another one");
					} else {
						Formatter x = null;
						try {
							FileWriter f = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(f);
							bw.write(user);
							bw.close();
							x = new Formatter(f);
							x.format("%s %s%n", user.toUpperCase(), pass);
							System.out.println("You registered successfully");
							x.close();
							br.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				catch (Exception e) {
				}
			} else {
				System.out.println("Passwords are not matching");
			}
			input.close();
		}
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