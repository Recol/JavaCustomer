import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationFromMemoryFakeTest {
    @Test
    public void passwordMatchesReturnsTrueWhenValid(){
        AuthenticationFromMemoryFake testAuthenticate = new AuthenticationFromMemoryFake();

        boolean detailsMatch = testAuthenticate.passwordMatches("username","password");

        assertTrue(detailsMatch);
    }

    @Test
    public void passwordMatchesReturnsFalseWhenInvalid(){
        AuthenticationFromMemoryFake testAuthenticate = new AuthenticationFromMemoryFake();

        boolean noMatch = testAuthenticate.passwordMatches("username","wrong password");

        assertFalse(noMatch);
    }

    @Test
    public void passwordMatchesReturnsFalseWhenNull(){
        AuthenticationFromMemoryFake testAuthenticate = new AuthenticationFromMemoryFake();

        boolean noMatch = testAuthenticate.passwordMatches("username",null);

        assertFalse(noMatch);
    }

    @Test
    public void userExistsReturnsTrueWhenValid(){
        AuthenticationFromMemoryFake testAuthenticate = new AuthenticationFromMemoryFake();

        boolean detailsMatch = testAuthenticate.userExists("username");

        assertTrue(detailsMatch);
    }

    @Test
    public void userExistsReturnsFalseWhenInvalid(){
        AuthenticationFromMemoryFake testAuthenticate = new AuthenticationFromMemoryFake();

        boolean noMatch = testAuthenticate.userExists("no such user");

        assertFalse(noMatch);
    }

    @Test
    public void userExistsReturnsFalseWhenNull(){
        AuthenticationFromMemoryFake testAuthenticate = new AuthenticationFromMemoryFake();

        boolean noMatch = testAuthenticate.userExists(null);

        assertFalse(noMatch);
    }

    @Test
    public void registrationMenuAddsToValidDetails(){
        AuthenticationFromMemoryFake testAuthenticate = new AuthenticationFromMemoryFake();
        ByteArrayInputStream in = new ByteArrayInputStream("testUser\ntestPassword".getBytes());
        System.setIn(in);

        testAuthenticate.registerNewUser();
        HashMap<String, String> validDetails = testAuthenticate.getValidDetails();

        assertEquals(validDetails.get("testUser"),"testPassword");
    }

}
