package com.model;

public class InvoiceLine {

    private String itemName;


    public InvoiceLine(String itemName, Double itemPrice, int count, InvoiceHeader inv) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.inv = inv;
    }
    
        public InvoiceLine() {

    }
    private  Double itemPrice;
    private  int count;
    private InvoiceHeader inv;

    
    public Double getItemTotal()
    {

        return count*itemPrice;
    }
    @Override
    public String toString() {
        return "InvoiceLine{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", count=" + count + ", inv=" + inv + '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }











}
