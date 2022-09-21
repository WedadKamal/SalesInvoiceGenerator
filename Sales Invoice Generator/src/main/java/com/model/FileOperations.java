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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FileOperations {



  public   ArrayList<InvoiceHeader> readFile() throws IOException, ParseException, Exception {
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
                  invoiceLineObj.setItemName(values[1]);
                  invoiceLineObj.setItemPrice(Double.valueOf(values[2].trim()));
                  invoiceLineObj.setCount(Integer.valueOf(values[3]));

                  InvoiceLines.add(invoiceLineObj);
                  System.out.println(values[0] + "," + values[1] + "," + values[2] + "," + values[3]);

              }

              BufferedReader br = new BufferedReader(new FileReader(invoiceHeaderPath));
              System.out.println("invoice header is");
              while ((line= br.readLine()) != null){

                  String[] valuesHeader = line.split(",");

                  InvoiceHeader invoiceHeadObj = new InvoiceHeader();
                  invoiceHeadObj.setInvoiceNum(Integer.valueOf(valuesHeader[0]));
                  invoiceHeadObj.setInvoiceDate(parseDateFormat(valuesHeader[1]));
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


public static Date parseDateFormat(String dateValue ) throws Exception
    {
        
     //   String string = "January 2, 2010";
DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
Date date = format.parse(dateValue);


//        SimpleDateFormat  formatter = new SimpleDateFormat(oldFormat);
//        Date date =formatter.parse(dateValue);
//        formatter.applyPattern(newFormat);
      //  String parsedDateValue =formatter.format(date);
        return date;
    }


   public void writeFile(ArrayList<InvoiceHeader> InvoiceHeaders){

       InvoiceHeaders = new ArrayList<>();
        System.out.println("the writing file");


    }
}
