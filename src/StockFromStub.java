import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockFromStub implements StockInterface{

    public List<String[]> getFileData() {
        List<String[]> stubData = new ArrayList<>();
        stubData.add(new String[]{"INTEL_I5","Intel Core i5-10600k","457.02","CPU"});
        stubData.add(new String[]{"RTX_3060","Nvidia GeForce RTX 3060 Ti","999.99","GPU"});
        return stubData;
    }

    public HashMap<String, String[]> setupProductCatalogue(List<String[]> stockItems) {
        HashMap<String, String[]> stubHashmap = new HashMap<>();
        stubHashmap.put("Ryzen_9", new String[]{"CPU", "Ryzen", "450"});
        stubHashmap.put("GTX_1660", new String[]{"GPU", "Nvidia","600"});
        return stubHashmap;
    }
}
