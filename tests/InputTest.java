import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    @Test
    public void getIntReturnsCorrectInt(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        int testFine = Input.getInt(1, 5);

        assertEquals(1, testFine);
    }

    @Test
    public void getIntReturnsCorrectIntWhenTooHighInitially(){
        ByteArrayInputStream in = new ByteArrayInputStream("10\n1".getBytes());
        System.setIn(in);

        int testFine = Input.getInt(1, 5);

        assertEquals(1, testFine);
    }

    @Test
    public void getIntReturnsCorrectIntWhenTooLowInitially(){
        ByteArrayInputStream in = new ByteArrayInputStream("-1\n1".getBytes());
        System.setIn(in);

        int testFine = Input.getInt(1, 5);

        assertEquals(1, testFine);
    }

    @Test
    void getStringReturnsCorrectString() {
        ByteArrayInputStream in = new ByteArrayInputStream("test string".getBytes());
        System.setIn(in);

        String testString = Input.getString();

        assertEquals("test string", testString);
    }

    @Test
    void getStringReturnsCorrectStringWhenInitiallyEmpty() {
        ByteArrayInputStream in = new ByteArrayInputStream("\n\ntest string".getBytes());
        System.setIn(in);

        String testString = Input.getString();

        assertEquals("test string", testString);
    }
}
