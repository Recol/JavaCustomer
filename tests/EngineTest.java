import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {
    @Test
    public void itemSelectionReturnsTrue(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Engine testEngine = new Engine();

        boolean testFine = testEngine.itemSelect();

        assertTrue(testFine);
    }
}
