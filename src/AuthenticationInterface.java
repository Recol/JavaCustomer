public interface AuthenticationInterface {

    public boolean validUser(String username, String password);

    public boolean userExists(String username);

}
