public class Menu {
	private static final StockFromFile stockToUse = new StockFromFile();
	private static final StockFromStub stubStock = new StockFromStub();

	private static void storeMenu(){
		Engine engineObject = new Engine(stubStock);
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
					engineObject.itemDisplay();
					engineObject.itemSelect();
					indent();
					break;
				case 4:
					System.out.println("Thank you for shopping - goodbye!");
					System.exit(0);
				default:
					System.out.println("Invalid option - please try again.");
					break;
			}
		} while (true);
	}

	public static void main(String[] args) {
		AuthenticationFromMemory auth = new AuthenticationFromMemory();
		auth.loginMenu();
		System.out.println("Welcome to the store!");
		try {
			storeMenu();
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void indent() {
		System.out.println();
	}
}
