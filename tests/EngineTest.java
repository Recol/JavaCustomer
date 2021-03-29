import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTest {
    StockInterface stockFromStub = new StockFromStub();

    @Test
    public void itemSelectionReturnsTrueWithStub(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Engine testEngine = new Engine(stockFromStub);

        boolean testFine = testEngine.itemSelect(stockFromStub);

        assertTrue(testFine);
    }

    @Test
    public void itemSelectionReturnsTrueWithFile(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        StockInterface stockFromFile = new StockFromFile();
        Engine testEngine = new Engine(stockFromFile);

        boolean testFine = testEngine.itemSelect(stockFromFile);

        assertTrue(testFine);
    }

    @Test
    public void itemSelectionOutputIsCorrect(){
        //TODO - check output stream to match mock return from stock
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        StockInterface stockFromFile = new StockFromFile();
        Engine testEngine = new Engine(stockFromFile);

        assertEquals(outputStream, mockOutput);
    }

}
