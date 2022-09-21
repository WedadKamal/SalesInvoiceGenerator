package com.model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {


    private  int invoiceNum;
    private  Date invoiceDate;
    private  String customerName;
    private ArrayList <InvoiceLine> InvoiceLines; // min 1:05

    public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }
    
   

   public InvoiceHeader() {
    }
    
        public Double getWholeInvoiceTotal()
    {

        Double total= 0.0;
        
        for(InvoiceLine item: InvoiceLines)
        {
            total += item.getItemTotal();
        
        
        }
        return total;
    }


    public int getInvoiceNum() {
        return invoiceNum;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNum=" + invoiceNum + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + ", InvoiceLines=" + InvoiceLines + '}';
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }



    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        if(InvoiceLines== null){
        InvoiceLines=new ArrayList();
        }
        return InvoiceLines;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        InvoiceLines = invoiceLines;
    }








}
