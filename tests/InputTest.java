import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    @Test
    public void getInt_returnsCorrectInt(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        int testFine = Input.getInt(scanner,0,5);

        assertEquals(1, testFine);
    }
}
