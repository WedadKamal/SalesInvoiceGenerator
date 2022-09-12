package dataModel;

public class InvoicesDM {
    private  int Invoice_No;
    private  String Invoice_Date;
    private  String Customer_Name;
    private  int Total_amount;

    public int getInvoice_No() {
        return Invoice_No;
    }

    public void setInvoice_No(int invoice_No) {
        Invoice_No = invoice_No;
    }

    public String getInvoice_Date() {
        return Invoice_Date;
    }

    public void setInvoice_Date(String invoice_Date) {
        Invoice_Date = invoice_Date;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public int getTotal_amount() {
        return Total_amount;
    }

    public void setTotal_amount(int total_amount) {
        Total_amount = total_amount;
    }


}
