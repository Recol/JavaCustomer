

import java.util.HashMap;

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
	
}
