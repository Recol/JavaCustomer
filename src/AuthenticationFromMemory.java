import java.io.*;
import java.util.Formatter;
import java.util.HashMap;

public class AuthenticationFromMemory implements AuthenticationInterface {
	HashMap<String, String> validDetails = new HashMap<String, String>();

	public AuthenticationFromMemory() {
		validDetails.put("username", "password");
		validDetails.put("admin", "12345");
	}

	public void loginMenu() {
		System.out.println("Are you an existing user? (Y for yes, N for no)");
		String choice;
		do{
			choice = Input.getString();
		} while(!(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")));

		switch(choice){
			case("Y"):
				existingUserLogin();
				return;
			case("N"):
				registerNewUser();
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

	public void registerNewUser() {
		System.out.println("Registration Page");
		System.out.print("Please enter your desired username: ");
		String user = Input.getString();
		String pass;
		do {
			System.out.print("Please enter your desired password: ");
			pass = Input.getString();
		} while(!passwordSecureFromMemory(pass));
		validDetails.put(user,pass);
		System.out.println("User successfully registered! Please log in with your details");
	}

	public void existingUserLogin(){
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
		} catch (Exception ex) {
			System.out.println("A fatal exception has occurred.");
			ex.getStackTrace();
		}
	}

	public boolean passwordSecureFromMemory(String pass) {
		int length = pass.length();
		if (length < 6) {
			System.out.println("Password is too short - ensure your password is 6 characters or more");
			return false;
		}
		return true;
	}

	//Deprecated - no user file used (so far)
	public boolean passwordSecureFromFile(String user, String pass){
		try {
			File file;
			file = new File("C:"+File.separator + "Users"+File.separator + "Passwords"+File.separator + "Downloads"+File.separator + "accounts.txt");
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
		return true;
	}
}
