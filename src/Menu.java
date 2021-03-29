public class Menu {
	private static final StockFromFile stockToUse = new StockFromFile();

	public static void main(String[] args) {
		Engine engineObject = new Engine(stockToUse);
		AuthenticationFromMemory auth = new AuthenticationFromMemory();
		indent();
		auth.loginMenu();
		System.out.println("Welcome to the store!");
		try {
			do {
				engineObject.menuOutput();
				int option = Input.getInt(1, 4);
				switch (option) {
				case 1:
					engineObject.cpuDisplay();
					indent();
					break;
				case 2:

					engineObject.gpuDisplay();
					indent();
					break;
				case 3:
					engineObject.itemSelect(stockToUse);
					indent();
					break;
				case 4:
					System.out.println("System now shutting down");
					System.exit(0);
				default:
					System.out.println("Invalid option - please try again.");
					break;
				}
			} while (true);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void indent() {
		System.out.println();
	}
}
