package com.view;

import Constants.GeneralConstants;
import com.model.FileOperations;
import com.model.InvoiceHeader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class View extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu FileMenu;
    private JRadioButtonMenuItem FileMenuradio;
    private JButton saveBtn;
    private JButton cancelBtn;
    private JButton deleteInvoiceBtn;
    private JButton createNewInvoiceBtn;
    private JMenuItem loadFileBtn;
    private JMenuItem saveFileBtn;
    private JTextField invoiceDate;
    private JTextField customerName;
    private JTextField invoiceTotal;
    private JTextField invoiceNumber;

    private JLabel invoiceDateLabel;
    private JLabel customerNameLabel;
    private JLabel invoiceTotalLabel;
    private JLabel invoiceNumberLabel;
    private JTable invoicesTable;
    private JTable invoiceItems;

    private JLabel invoicesTableLbl;
    private JLabel invoiceItemsLbl;
    private JLabel File;

    private String [] invoicesTableHeader = {"No.","Date","Customer","Total"};
    private String [] invoiceItemsHeader = {"No.","Item Name","Item Price","Item Total"};


 /*   private String [][] invoicesTableData = {
    {"1","5/5/2020","wedad kamal","500"},
    {"1","5/5/2020","wedad kamal2","600"},
    {"1","5/5/2020","wedad kamal3","700"}
    };*/
    private String [] [] invoiceItemsData =   {
            {"1","soap","22","22"},
            {"2","apple","33","33"},
            {"3","orange","44","44"}
    };

    private String []  testData =
            {"1","soap","22","22"};



    public View() throws IOException {

        super("Design Preview [new JFrame]");
       // JFrame F = new JFrame("Design Preview [new JFrame]");



        //menu
        FileMenuradio = new JRadioButtonMenuItem();
        menuBar = new JMenuBar();
        FileMenu= new JMenu("File");
        //buttons
     //   setLayout(new FlowLayout());

        saveBtn= new JButton("Save");
        cancelBtn= new JButton("Cancel");
        cancelBtn.addActionListener(this);
        cancelBtn.setActionCommand("C");
        deleteInvoiceBtn= new JButton("Delete Invoice");
        createNewInvoiceBtn= new JButton("Create New Invoice");
        loadFileBtn= new JMenuItem("Load File");
        loadFileBtn.setActionCommand("L");
        saveFileBtn= new JMenuItem("Save File");

        //text and label
        invoiceDateLabel= new JLabel("Invoice Date");
        customerNameLabel= new JLabel("Customer Name");
        invoiceTotalLabel= new JLabel("Invoice Total");
        invoiceNumberLabel= new JLabel("Invoice Number");



        invoicesTableLbl= new JLabel("invoices Table");
        invoiceItemsLbl= new JLabel("invoice Items");
        File= new JLabel("File");

        invoiceDate= new JTextField(30);
        customerName= new JTextField(30);
        invoiceTotal= new JTextField();
        invoiceNumber= new JTextField();


        //add Action Listener for the buttons



         saveBtn.addActionListener(this);
         cancelBtn.addActionListener(this);
         deleteInvoiceBtn.addActionListener(this);
         createNewInvoiceBtn.addActionListener(this);
         loadFileBtn.addActionListener(this);
         saveFileBtn.addActionListener(this);



        //       add(File);
        add(invoiceDateLabel);
        add(invoiceDate);

        add(customerNameLabel);
        add(customerName);
        add(invoiceTotalLabel);
        add(invoiceTotal);
        add(invoiceNumberLabel);
        add(invoiceNumber);


      // invoicesTable= new JTable();
        invoicesTable = new JTable(readToTable(),invoicesTableHeader);

    //    invoicesTable = new JTable ();
        invoiceItems = new JTable(readToScondTable(),invoiceItemsHeader);
//setLayout(new FlowLayout());

//        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
//        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
     //   setLayout(new BorderLayout());
        add(saveBtn);
        add(cancelBtn);
        add(deleteInvoiceBtn);
        add(createNewInvoiceBtn);
        add(loadFileBtn);
        add(saveFileBtn);

        add(invoicesTableLbl);
        add(new JScrollPane( invoicesTable));
        add(invoiceItemsLbl);
        add(new JScrollPane( invoiceItems));


        MyListner my = new MyListner();
        saveBtn.addActionListener(this);
        saveBtn.setActionCommand("c");
        deleteInvoiceBtn.addActionListener(this);


       setSize(700,500);
       setLocation(400,200);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //setVisible(true);
        setJMenuBar(menuBar);
        FileMenu.add(saveFileBtn);

        //   FileMenu.addSeparator();
        FileMenu.add(loadFileBtn);
        menuBar.add(FileMenu);
       // setLayout(new GridLayout(1,2));
        JPanel leftSidePanal = new JPanel();
     //   add(leftSidePanal);
      JPanel rightSidePanal = new JPanel();
      add(rightSidePanal,BorderLayout.EAST);
      rightSidePanal.add(invoicesTable);
        leftSidePanal.setLayout(new GridLayout(1,2));
        add(leftSidePanal,BorderLayout.WEST);

     //   rightSidePanal.add(deleteInvoiceBtn);
        leftSidePanal.add(saveBtn);
        leftSidePanal.add(cancelBtn);
        leftSidePanal.add(invoiceItems);

    }

    public String[][] readToTable() throws IOException {

        FileOperations f = new FileOperations();
        ArrayList<InvoiceHeader> invoiceItemsData=  f.readFile();
        int column = 4;
        String[][] invoicesTableData = new String[invoiceItemsData.size()][column];


                    for (int row = 0; row < invoicesTableData. length; row++) {
                invoicesTableData[row][0] = invoiceItemsData.get(row).getInvoiceNum();
                invoicesTableData[row][2] = invoiceItemsData.get(row).getCustomerName();
                invoicesTableData[row][1] = invoiceItemsData.get(row).getInvoiceDate();


            }
       return invoicesTableData;
    }
    public String[][] readToScondTable() throws IOException {

        FileOperations f = new FileOperations();
        ArrayList<InvoiceHeader> invoiceItemsData=  f.readFile();
        int column = 4;
        int invoiceLinesSize= invoiceItemsData.size()-1;
        String[][] invoicesItemsData = new String[invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().size()][column];




                    for (int row = 0; row < invoicesItemsData. length; row++) {
                        invoicesItemsData[row][0] = String.valueOf(invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().get(row).getItemName());
                        invoicesItemsData[row][1] = String.valueOf(invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().get(row).getItemPrice());
                        invoicesItemsData[row][2] = String.valueOf(invoiceItemsData.get(invoiceLinesSize).getInvoiceLines().get(row).getCount());
                      /*  invoicesItemsData[row][2] = invoiceItemsData.get(row).getCustomerName();
                        invoicesItemsData[row][1] = invoiceItemsData.get(row).getInvoiceDate();*/


            }
       return invoicesItemsData;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        //actionevent has the info of the buttons that have been clicked
        String name = customerName.getText();
        FileOperations File = new FileOperations();

        switch (e.getActionCommand()){

            case "L" :
                try {
                    ArrayList<InvoiceHeader> InvoiceHeaders= File.readFile();
                }catch (IOException error){
                    error.printStackTrace();
                }

                break;
            case "S" :

                break;
            case "C" :
               System.exit(0);
                break;

        }
        if(e.getActionCommand().equals("CAN")) {
            JOptionPane.showMessageDialog(this, "welcome save "+name, "title", JOptionPane.PLAIN_MESSAGE);
        }else if(e.getSource().equals(deleteInvoiceBtn))
        {
            JOptionPane.showMessageDialog(this, "welcome delete" +name, "title", JOptionPane.PLAIN_MESSAGE);

        }
    }
}
