import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StockFile {

    public static List<String[]> getFileData(){
        List<String[]> fileData = new ArrayList<String[]>();
        try {
            File filePath = new File("src/stock.csv");
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

    public static HashMap<String, String[]> setupProductCatalogue(List<String[]> stockItems){
        HashMap<String, String[]> productCatalogueMap = new HashMap<>();
        //stockItems is all products
        for(int i = 0; i < stockItems.size(); i++){
            String[] product = stockItems.get(i); //full details of 1 product
            String productID = product[1];
            String[] productAttributes = {product[1], product[2], product[3]};
            productCatalogueMap.put(productID, productAttributes);
        }
        return productCatalogueMap;
    }

}
