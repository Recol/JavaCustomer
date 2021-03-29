import java.util.HashMap;

public class AuthenticationFromMemory implements AuthenticationInterface {
	HashMap<String, String> validDetails = new HashMap<String, String>();

	public AuthenticationFromMemory() {
		validDetails.put("username", "password");
		validDetails.put("admin", "12345");
	}

	public void loginMenu() {
		try {
			System.out.println("What is your username?");
			String user;
			do {
				user = Input.getString();
			} while (!userExists(user));

			System.out.println("What is your password?");
			String pass;
			do {
				pass = Input.getString();
			} while (!passwordMatches(user, pass));
			System.out.println("Login successful. Welcome, " + user + "!");
			System.out.println("");

		} catch (Exception ex) {
			System.out.println("A fatal exception has occurred.");
			ex.getStackTrace();
		}
	}

	public boolean passwordMatches(String username, String password) {
		if (!validDetails.get(username).equals(password)) {
			System.out.println("Password incorrect. Please try again");
			return false;
		}
		return true;
	}

	public boolean userExists(String username) {
		if (!validDetails.containsKey(username)) {
			System.out.println("User does not exist. Please try again.");
			return false;
		}
		return true;
	}

}
