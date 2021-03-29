import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StockFromFile implements StockInterface{

    public List<String[]> getFileData(){
        List<String[]> fileData = new ArrayList<>();
        try {
            File filePath = new File("src/resources/stock.csv");
            Scanner dataReader = new Scanner(filePath);
            while (dataReader.hasNextLine()) {
                String fileRow = dataReader.nextLine();
                fileData.add(fileRow.split(","));
            }
            dataReader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            e.printStackTrace();
        }
        return fileData;
    }

    public HashMap<String, String[]> setupProductCatalogue(List<String[]> stockItems){
        HashMap<String, String[]> productCatalogueMap = new HashMap<>();
        //stockItems is all products
        //full details of 1 product
        for (String[] product : stockItems) {
            String productID = product[0];
            String[] productAttributes = {product[1], product[2], product[3]};
            productCatalogueMap.put(productID, productAttributes);
        }
        return productCatalogueMap;
    }
}
