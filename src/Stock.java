public class Stock {
	public enum Stock_Items {
		RYZEN_7("AMD Ryzen 9 5900X", 829.95, "CPU"), RYZEN_5("AMD Ryzen 5 3600X", 199.00, "CPU"),
		INTEL_I5("Intel Core i5-10600K", 457.02, "CPU"), RTX_3060("Nvidia GeForce RTX 3060 Ti", 999.99, "GPU"),
		RX_5600("AMD Radeon RX 5600 XT", 800.00, "GPU"), RX_6800("AMD Radeon RX 6800", 769.98, "GPU");

		private final String name;
		private final double price;
		private final String type;

		int cpu_price1 = 100;
		int cpu_price2 = 150;
		int gpu_price1 = 100;
		int gpu_price2 = 150;

		Stock_Items(String name, double price, String type) {
			this.name = name;
			this.price = price;
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public double getPrice() {
			return price;
		}

		public String getType() {
			return type;
		}

		Engine engine_object = new Engine();

	}
}
