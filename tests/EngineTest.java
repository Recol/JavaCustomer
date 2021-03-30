import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EngineTest {
    StockInterface stockFromStub = new StockFromStub();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void itemSelectionReturnsTrueWithStub(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Engine testEngine = new Engine(stockFromStub);

        boolean testFine = testEngine.itemSelect();

        assertTrue(testFine);
    }

    @Test
    public void itemSelectionReturnsTrueWithFile(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        StockInterface stockFromFile = new StockFromFile();
        Engine testEngine = new Engine(stockFromFile);

        boolean testFine = testEngine.itemSelect();

        assertTrue(testFine);
    }

    @Test
    public void itemSelectionOutputIsCorrectWithMockFile(){
        StockFromFile stockMock = mock(StockFromFile.class);
        List<String[]> testData = new ArrayList<>();
        testData.add(new String[]{"INTEL_I5","Intel Core i5-10600k","457.02","CPU"});
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        when(stockMock.getFileData()).thenReturn(testData);

        Engine testEngine = new Engine(stockMock);
        boolean testFine = testEngine.itemSelect();

        assertTrue(testFine);
    }

}
