public enum Stock {
    RYZEN_7("AMD Ryzen 9 5900X", 829.95),
    RYZEN_5("AMD Ryzen 5 3600X", 199.00),
    INTEL_I5("Intel Core i5-10600K", 457.02),
    RTX_3060("Nvidia GeForce RTX 3060 Ti", 999.99),
    RX_5600("AMD Radeon RX 5600 XT", 800.00),
    RX_6800("AMD Radeon RX 6800", 769.98);

    private final String name;
    private final double price;

    Stock(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){  return name;  }
    public double getPrice(){  return price;  }
}
