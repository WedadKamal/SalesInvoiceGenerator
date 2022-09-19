import com.model.InvoiceHeader;
import com.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<InvoiceHeader> hjhjhjj;

    public static void main(String[] args) throws IOException {
        View V = new View();
        V.setVisible(true);
        V.readToTable();
        V.readToScondTable();

   /*     ViewInvoice V = new ViewInvoice();
        V.setVisible(true);
        V.readToTable();
        V.readToScondTable();
*/


    }
}
