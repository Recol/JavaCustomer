import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface StockInterface {
    public List<String[]> getFileData();

    public HashMap<String, String[]> setupProductCatalogue(List<String[]> stockItems);
}


