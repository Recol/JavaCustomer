import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockFromStub implements StockInterface{

    public List<String[]> getFileData() {
        List<String[]> stubData = new ArrayList<>();
        stubData.add(new String[]{"Ryzen_9","CPU", "Ryzen","450"});
        stubData.add(new String[]{"GTX_1660","GPU", "Nvidia","600"});
        return stubData;
    }

    public HashMap<String, String[]> setupProductCatalogue(List<String[]> stockItems) {
        HashMap<String, String[]> stubHashmap = new HashMap<>();
        stubHashmap.put("Ryzen_9", new String[]{"CPU", "Ryzen", "450"});
        stubHashmap.put("GTX_1660", new String[]{"GPU", "Nvidia","600"});
        return stubHashmap;
    }
}
