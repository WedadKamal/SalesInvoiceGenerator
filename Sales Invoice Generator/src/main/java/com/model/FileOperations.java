package com.model;

import Constants.GeneralConstants;
import com.view.View;

import javax.imageio.IIOException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {



  public   ArrayList<InvoiceHeader> readFile() throws IOException {
        ArrayList<InvoiceHeader> InvoiceHeaders = new ArrayList<>();
        ArrayList<InvoiceLine> InvoiceLines = new ArrayList<>();

      String invoiceHeaderPath =System.getProperty("user.dir") + GeneralConstants.INVOICEHEADERPATH;
      String invoiceLinepath =System.getProperty("user.dir") + GeneralConstants.INVOICELINEPATH;

          String line = "";
          try {

              BufferedReader brInLine = new BufferedReader(new FileReader(invoiceLinepath));
              System.out.println("invoice Line is");
              while ((line= brInLine.readLine()) != null){

                  String[] values = line.split(",");


                  InvoiceLine invoiceLineObj = new InvoiceLine();
                  invoiceLineObj.setItemName(values[0]);
                  invoiceLineObj.setItemPrice(values[1]);
                  invoiceLineObj.setCount(values[2]);
                  InvoiceLines.add(invoiceLineObj);
                  System.out.println(values[0] + "," + values[1] + "," + values[2]);

              }

              BufferedReader br = new BufferedReader(new FileReader(invoiceHeaderPath));
              System.out.println("invoice header is");
              while ((line= br.readLine()) != null){

                  String[] valuesHeader = line.split(",");

                  InvoiceHeader invoiceHeadObj = new InvoiceHeader();
                  invoiceHeadObj.setInvoiceNum(valuesHeader[0]);
                  invoiceHeadObj.setInvoiceDate(valuesHeader[1]);
                  invoiceHeadObj.setCustomerName(valuesHeader[2]);
                  InvoiceHeaders.add(invoiceHeadObj);
                      System.out.println(valuesHeader[0] + "," + valuesHeader[1] + "," + valuesHeader[2]);



          }
              InvoiceHeader invoiceHeadObj = new InvoiceHeader();
              invoiceHeadObj.setInvoiceLines(InvoiceLines);
              InvoiceHeaders.add(invoiceHeadObj);


          }catch (FileNotFoundException e){

              e.printStackTrace();
          }catch (IIOException e) {

              e.printStackTrace();
          }

      return InvoiceHeaders;
      }





   public void writeFile(ArrayList<InvoiceHeader> InvoiceHeaders){

       InvoiceHeaders = new ArrayList<>();
        System.out.println("the writing file");


    }
}
