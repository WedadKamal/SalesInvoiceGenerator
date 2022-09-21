package com.controller;

import com.model.FileOperations;
import com.model.InvoiceHeader;
import com.view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyListner implements ActionListener{

    private SalesFrame frameObj;
      Date date = Calendar.getInstance().getTime();  
DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
String strDate = dateFormat.format(date);  
    
    
   public MyListner(SalesFrame frameObj){
   this.frameObj=frameObj;
   }
   
     public MyListner(){
   }
    @Override
    public void actionPerformed(ActionEvent e) {
       
          switch (e.getActionCommand()){

            case "Create New Invoice" :
                
                newInvoice();
//                try {
//                   // ArrayList<InvoiceHeader> InvoiceHeaders= File.readFile();
//                }catch (IOException error){
//                    error.printStackTrace();
//                }

                break;
            case "Delete Invoice" :
                deleteInvoice();

                break;
            case "Save" :

                saveInvoice();
                break;
            case "Cancel" :
                
                cancelInvoice();


                break;
            case "Load File" :
                loadFile();

                break;
            case "Save File" :
                
              saveFile();

                break;

        }

        System.out.println(" heeeeeeeeeeeeeeeeeeeeeeey");
    }
   /* @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"welcome ","title",JOptionPane.PLAIN_MESSAGE);
    }*/

     public Object[][] readToTable() throws IOException, ParseException, Exception {

        FileOperations f = new FileOperations();
        ArrayList<InvoiceHeader> invoiceItemsData=  f.readFile();
        int column = 4;
        Object[][] invoicesTableData = new String[invoiceItemsData.size()][column];


                    for (int row = 0; row < invoicesTableData. length; row++) {
                invoicesTableData[row][0] = String.valueOf(invoiceItemsData.get(row).getInvoiceNum());
                invoicesTableData[row][2] = invoiceItemsData.get(row).getCustomerName();
                invoicesTableData[row][1] = String.valueOf(invoiceItemsData.get(row).getInvoiceDate());  


            }
       return invoicesTableData;
    }
    public String[][] readToScondTable() throws IOException, ParseException, Exception {

        FileOperations f = new FileOperations();
        ArrayList<InvoiceHeader> invoiceItemsData=  f.readFile();
        int column = 4;
        int invoiceLinesSize= invoiceItemsData.size()-1;
        String[][] invoicesItemsData = new String[invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().size()][column];




                    for (int row = 0; row < invoicesItemsData. length; row++) {
                        invoicesItemsData[row][0] = String.valueOf(invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().get(row).getItemName());
                        invoicesItemsData[row][1] = String.valueOf(invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().get(row).getItemPrice());
                        invoicesItemsData[row][2] = String.valueOf(invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().get(row).getCount());
                        invoicesItemsData[row][3] = String.valueOf(invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().get(row).getItemTotal());

                      /*  invoicesItemsData[row][2] = invoiceItemsData.get(row).getCustomerName();
                        invoicesItemsData[row][1] = invoiceItemsData.get(row).getInvoiceDate();*/


            }
       return invoicesItemsData;
    }
    
    private void newInvoice() {
    }

    private void saveFile() {
    }

    private void loadFile() {
        
        JFileChooser fObj = new JFileChooser();
        int result = fObj.showOpenDialog(frameObj);
        if(result==JFileChooser.APPROVE_OPTION)
                {
                String path = fObj.getSelectedFile().getPath();
                    FileInputStream fis = null;
                
                }
    }

    private void cancelInvoice() {
                         System.exit(0);
    }

    private void saveInvoice() {
    }

    private void deleteInvoice() {
    }
}
