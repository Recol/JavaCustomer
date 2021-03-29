import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationFromMemoryTest {

    @Test
    public void passwordMatchesReturnsTrueWhenValid(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean detailsMatch = testAuthenticate.passwordMatches("username","password");

        assertTrue(detailsMatch);
    }

    @Test
    public void passwordMatchesReturnsFalseWhenInvalid(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean noMatch = testAuthenticate.passwordMatches("username","wrong password");

        assertFalse(noMatch);
    }

    @Test
    public void passwordMatchesReturnsFalseWhenNull(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean noMatch = testAuthenticate.passwordMatches("username",null);

        assertFalse(noMatch);
    }

    @Test
    public void userExistsReturnsTrueWhenValid(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean detailsMatch = testAuthenticate.userExists("username");

        assertTrue(detailsMatch);
    }

    @Test
    public void userExistsReturnsFalseWhenInvalid(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean noMatch = testAuthenticate.userExists("no such user");

        assertFalse(noMatch);
    }

    @Test
    public void userExistsReturnsFalseWhenNull(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean noMatch = testAuthenticate.userExists(null);

        assertFalse(noMatch);
    }

}
