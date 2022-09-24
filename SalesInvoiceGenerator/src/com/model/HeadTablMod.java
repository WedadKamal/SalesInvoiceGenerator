/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.view.SalesInvFrame;

/**
 *
 * @author DELL
 */
public class HeadTablMod extends AbstractTableModel {
    private String[] cols = {"Num", "Customer", 
        "Date", "Total"};
    private List<InvoiceHeader> invoices;
    
    public HeadTablMod(List<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }
    
    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return cols[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader inv = invoices.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getNum();
            case 1: return inv.getCustomer();
            case 2: return SalesInvFrame.sdf.format(inv.getDate());
            case 3: return inv.getTotal();
        }
        return "";
        //return "(" + rowIndex + ", " + columnIndex + ")";
    }
    
}