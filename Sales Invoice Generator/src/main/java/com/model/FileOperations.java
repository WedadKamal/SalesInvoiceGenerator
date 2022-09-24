package com.model;

import Constants.GeneralConstants;

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



    public   String invoiceHeaderPath =System.getProperty("user.dir") + GeneralConstants.INVOICEHEADERPATH;
   public    String invoiceLinepath =System.getProperty("user.dir") + GeneralConstants.INVOICELINEPATH;

  public   ArrayList<InvoiceHeader> readFile() throws IOException, ParseException, Exception {
        ArrayList<InvoiceHeader> InvoiceHeaders = new ArrayList<>();
        ArrayList<InvoiceLine> InvoiceLines = new ArrayList<>();

          String line = "";
          try {

              BufferedReader brInLine = new BufferedReader(new FileReader(invoiceLinepath));
              System.out.println("invoice Line is");
              while ((line= brInLine.readLine()) != null){

                  String[] values = line.split(",");


                  InvoiceLine invoiceLineObj = new InvoiceLine();
                  InvoiceHeader invoiceHeaderObj = new InvoiceHeader();
                  invoiceHeaderObj.setInvoiceNum(Integer.valueOf(values[0]));
                  invoiceLineObj.setInv(invoiceHeaderObj);
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
                  invoiceHeadObj.setInvoiceDate((valuesHeader[1]));
                  invoiceHeadObj.setCustomerName(valuesHeader[2]);
                  InvoiceHeaders.add(invoiceHeadObj);
                      System.out.println(valuesHeader[0] + "," + valuesHeader[1] + "," + valuesHeader[2]);



          }
              

          
              for(int j = 0 ; j < InvoiceHeaders.size();j++){
                  ArrayList<InvoiceLine> InvoiceLinesRelated = new ArrayList<>();
              for (int i = 0 ; i < InvoiceLines.size(); i ++){
              if(InvoiceLines.get(i).getInv().getInvoiceNum()==InvoiceHeaders.get(j).getInvoiceNum())
              {
              InvoiceLinesRelated.add( InvoiceLines.get(i));
              InvoiceHeaders.get(j).setInvoiceLines(InvoiceLinesRelated);
              
              }
              }}
            

              
             for ( int i = 0 ; i<InvoiceHeaders.size();i++)
             {
                                  System.out.println("kooooooooool el objects ely ray7a");

                 System.out.println(InvoiceHeaders.get(i).getInvoiceNum());
                                  System.out.println(InvoiceHeaders.get(i).getInvoiceLines());

             }

          }catch (FileNotFoundException e){

              e.printStackTrace();
          }catch (IIOException e) {

              e.printStackTrace();
          }

      return InvoiceHeaders;
      }


  public   ArrayList<InvoiceHeader> readFileFromChooser(String invoiceHeaderPath,String invoiceLinepath) throws IOException, ParseException, Exception {
        ArrayList<InvoiceHeader> InvoiceHeaders = new ArrayList<>();
        ArrayList<InvoiceLine> InvoiceLines = new ArrayList<>();

          String line = "";
          try {

              BufferedReader brInLine = new BufferedReader(new FileReader(invoiceLinepath));
              System.out.println("invoice Line is");
              while ((line= brInLine.readLine()) != null){

                  String[] values = line.split(",");


                  InvoiceLine invoiceLineObj = new InvoiceLine();
                  InvoiceHeader invoiceHeaderObj = new InvoiceHeader();
                  invoiceHeaderObj.setInvoiceNum(Integer.valueOf(values[0]));
                  invoiceLineObj.setInv(invoiceHeaderObj);
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
                  invoiceHeadObj.setInvoiceDate((valuesHeader[1]));
                  invoiceHeadObj.setCustomerName(valuesHeader[2]);
                  InvoiceHeaders.add(invoiceHeadObj);
                      System.out.println(valuesHeader[0] + "," + valuesHeader[1] + "," + valuesHeader[2]);



          }
              
//               ic InvoiceHeader invoiceHeadObj = new InvoiceHeader();
//              invoiceHeadObj.setInvoiceLines(InvoiceLines);
//              InvoiceHeaders.add(invoiceHeadObj
          
              for(int j = 0 ; j < InvoiceHeaders.size();j++){
                  ArrayList<InvoiceLine> InvoiceLinesRelated = new ArrayList<>();
              for (int i = 0 ; i < InvoiceLines.size(); i ++){
              if(InvoiceLines.get(i).getInv().getInvoiceNum()==InvoiceHeaders.get(j).getInvoiceNum())
              {
              InvoiceLinesRelated.add( InvoiceLines.get(i));
              InvoiceHeaders.get(j).setInvoiceLines(InvoiceLinesRelated);
              
              }
              }}
            

              
             for ( int i = 0 ; i<InvoiceHeaders.size();i++)
             {
                                  System.out.println("kooooooooool el objects ely ray7a");

                 System.out.println(InvoiceHeaders.get(i).getInvoiceNum());
                                  System.out.println(InvoiceHeaders.get(i).getInvoiceLines());

             }

          }catch (FileNotFoundException e){

              e.printStackTrace();
          }catch (IIOException e) {

              e.printStackTrace();
          }


      InvoiceHeader invoiceHeadObj = new InvoiceHeader();
      invoiceHeadObj.setInvoiceLines(InvoiceLines);
      InvoiceHeaders.add(invoiceHeadObj);
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
