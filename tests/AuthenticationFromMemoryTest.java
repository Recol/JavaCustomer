import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationFromMemoryTest {

    @Test
    public void validUserReturnsTrueWhenValid(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean detailsMatch = testAuthenticate.validUser("username","password");

        assertTrue(detailsMatch);
    }

    @Test
    public void validUserReturnsFalseWhenInvalid(){
        AuthenticationFromMemory testAuthenticate = new AuthenticationFromMemory();

        boolean noMatch = testAuthenticate.validUser("username","wrong password");

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

}
