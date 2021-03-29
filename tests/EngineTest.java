import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {
    @Test
    public void itemSelectionReturnsTrue(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        StockInterface stockFromStub = new StockFromStub();
        Engine testEngine = new Engine(stockFromStub);

        boolean testFine = testEngine.itemSelect(stockFromStub);

        assertTrue(testFine);
    }
}
