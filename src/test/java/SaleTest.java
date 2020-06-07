import com.java.assignment.ReadingFile;
import com.java.assignment.Sale;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleTest {

    @org.junit.jupiter.api.Test
    void getSalesCount() throws IOException {
        String absPath = "/home/bay/Documents/workSpace/javaAssignment/src/main/resources/";

        // Sales part
        String salesFileName = absPath + "sales.txt";
        ReadingFile fileSale = new ReadingFile(salesFileName);
        assertEquals(7, fileSale.getLineCount());
    }

    @org.junit.jupiter.api.Test
    void getSale() throws IOException {
        String absPath = "/home/bay/Documents/workSpace/javaAssignment/src/main/resources/";

        // Sales part
        Set<Sale> saleList = new HashSet<>();
        String salesFileName = absPath + "sales.txt";
        ReadingFile fileSale = new ReadingFile(salesFileName);
        List<String[]> allSales = fileSale.getAllLines();
        for(String[] sale: allSales){
            // productName|price
            String productName = sale[0];
            int price = parseInt(sale[1]);

            saleList.add(new Sale(productName, price));
        }
        System.out.println(saleList);
    }

}
