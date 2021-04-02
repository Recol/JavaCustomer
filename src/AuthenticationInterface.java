public interface AuthenticationInterface {

    public boolean passwordMatches(String username, String password);

    public boolean userExists(String username);

}
