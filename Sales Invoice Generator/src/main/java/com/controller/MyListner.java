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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static com.view.SalesFrame.displayHeaderLineDataFromChooser;


public class MyListner implements ActionListener{

    private SalesFrame frameObj  ;
      Date date = Calendar.getInstance().getTime();  
DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
String strDate = dateFormat.format(date);  
FileOperations f = new FileOperations();
    
    
   public MyListner(SalesFrame frameObj) throws Exception {
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

                  try {

  JFileChooser fObj = new JFileChooser();
        int result = fObj.showOpenDialog(frameObj);
        if(result==JFileChooser.APPROVE_OPTION)
                {
                String pathHeader = fObj.getSelectedFile().getPath();
                if(pathHeader != "")
                {
                      JFileChooser fObj2 = new JFileChooser();
        int result2 = fObj2.showOpenDialog(frameObj);
        if(result2==JFileChooser.APPROVE_OPTION)
                {
                String pathLine = fObj2.getSelectedFile().getPath();
                 //   frameObj = new SalesFrame();
                    displayHeaderLineDataFromChooser(loadFileHeader(pathHeader,pathLine),loadFileItem(pathHeader,pathLine));
                }
                }
                }

                  } catch (Exception ex) {
ex.printStackTrace();


                  }
              

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

     public Object[][] readToTable(ArrayList<InvoiceHeader> invoiceItemsData) throws IOException, ParseException, Exception {

        FileOperations f = new FileOperations();
     //   invoiceItemsData=  f.readFile();
        int column = 4;
        Object[][] invoicesTableData = new String[invoiceItemsData.size()][column];

        

                    for (int row = 0; row < invoicesTableData. length; row++) {
                        if(invoiceItemsData.get(row).getInvoiceNum() != 0) {
                            invoicesTableData[row][0] = String.valueOf(invoiceItemsData.get(row).getInvoiceNum());
                            invoicesTableData[row][2] = invoiceItemsData.get(row).getCustomerName();
                            invoicesTableData[row][1] = String.valueOf(invoiceItemsData.get(row).getInvoiceDate());
                            invoicesTableData[row][3] = String.valueOf(invoiceItemsData.get(row).getWholeInvoiceTotal());
                        }


            }
       return invoicesTableData;
    }
    public String[][] readToScondTable(int sizeObject,ArrayList<InvoiceHeader> invoiceItemsData) throws IOException, ParseException, Exception {

        FileOperations f = new FileOperations();
    //  ArrayList<InvoiceHeader> invoiceItemsData=  f.readFile();
        int column = 4;
        int size = invoiceItemsData.get(sizeObject).getInvoiceLines().size();
      //  int invoiceLinesSize= invoiceItemsData.size()-1;
        String[][] invoicesItemsData = new String[size][column];


       


                    for (int row = 0; row < invoicesItemsData. length; row++) {
                        if(!invoiceItemsData.get(sizeObject).getInvoiceLines().isEmpty())
                        invoicesItemsData[row][0] = String.valueOf(invoiceItemsData.get(sizeObject).getInvoiceLines().get(row).getItemName());
                        invoicesItemsData[row][1] = String.valueOf(invoiceItemsData.get(sizeObject).getInvoiceLines().get(row).getItemPrice());
                        invoicesItemsData[row][2] = String.valueOf(invoiceItemsData.get(sizeObject).getInvoiceLines().get(row).getCount());
                        invoicesItemsData[row][3] = String.valueOf(invoiceItemsData.get(sizeObject).getInvoiceLines().get(row).getItemTotal());
                        
                      /*  invoicesItemsData[row][2] = invoiceItemsData.get(row).getCustomerName();
                        invoicesItemsData[row][1] = invoiceItemsData.get(row).getInvoiceDate();*/


            }
       return invoicesItemsData;
    }


    public int getalllineItemSize () throws Exception {


         int totalSize = 0;
        ArrayList<InvoiceHeader> invoiceHeaders=f.readFile();

        for (int j = 0;j<invoiceHeaders.size();j++){


                totalSize+=invoiceHeaders.get(j).getInvoiceLines().size();


            }
        return totalSize;
    }
    private void newInvoice() {
    }

    private void saveFile() {
    }

    public Object[][] loadFileHeader(String pathHeader, String pathLine) throws ParseException, Exception {
        Object[][] headerData= null;
      //  frameObj = new SalesFrame();
        ArrayList<InvoiceHeader> invoiceItemsData=  f.readFileFromChooser(pathHeader, pathLine);
        headerData= readToTable(invoiceItemsData);
       // this.frameObj.displayHeaderDataFromChooser(headerData);
        return headerData;
           
    }
    
     private Object[][] loadFileItem(String pathHeader,String pathLine) throws ParseException, Exception {
        Object[][] itemData= null;
     //   frameObj = new SalesFrame();
        ArrayList<InvoiceHeader> invoiceItemsData=  f.readFileFromChooser(pathHeader, pathLine);
        int sizeall = invoiceItemsData.size()-1;
        itemData= readToScondTable(sizeall,invoiceItemsData);
      //  this.frameObj.displayItemDataFromChooser(itemData);
           return itemData;
    }

    private void cancelInvoice() {
                         System.exit(0);
    }

    private void saveInvoice() {
    }

    private void deleteInvoice() {
    }
}
