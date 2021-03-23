import java.util.HashMap;

public class Engine {
	Display displayObject = new Display();

	public void menuOutput() {
		HashMap<String, String >menu = new HashMap<String, String>();
		menu.put("1", "1: Buy a CPU");
		menu.put("2", "2: Buy a GPU");
		menu.put("3", "3: List all hardware");
		menu.put("4", "4: Exit");
		menu.values().stream().forEach(System.out::println);
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
			if(item.getType().equals("GPU")) {
				System.out.println(id + ": " + item.getName() + ", " + item.getPrice());
				id++;
			}
		}
	}
}