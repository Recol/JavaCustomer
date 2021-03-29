import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {
    StockInterface stockFromStub = new StockFromStub();

    @Test
    public void itemSelectionReturnsTrue(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Engine testEngine = new Engine(stockFromStub);

        boolean testFine = testEngine.itemSelect(stockFromStub);

        assertTrue(testFine);
    }
}
