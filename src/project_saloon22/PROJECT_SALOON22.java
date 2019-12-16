/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_saloon22;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PROJECT_SALOON22 {
    ArrayList<Beauty> beautylist = new ArrayList<Beauty>();
    String header[] = new String[]{"ID","Name", "Phone"};
    DefaultTableModel dtm = new DefaultTableModel(header, 1);
    
    String header2[] = new String[]{"ID","Name", "Phone", "Date", "Address"};
    DefaultTableModel dtm2 = new DefaultTableModel(header2, 1);

    PROJECT_SALOON22(){
        
        JFrame framelg = new JFrame("Login");
        framelg.setSize(300, 300);
        
         //Username
        JLabel jlUsername = new JLabel("Username");
        jlUsername.setBounds(50, 70, 60, 20);
        framelg.add(jlUsername);
        
        JTextField jtfUsername = new JTextField();
        jtfUsername.setBounds(120, 70, 120, 20);
        framelg.add(jtfUsername);
        
        //Password
        JLabel jlPass = new JLabel("Password");
        jlPass.setBounds(50, 90, 60, 20);
        framelg.add(jlPass);
  
        JTextField jtfPass = new JTextField();
        jtfPass.setBounds(120, 90, 120, 20);
        framelg.add(jtfPass);
        
        JButton jbuttonOk = new JButton("OK");
        jbuttonOk.setBounds(140, 120, 70, 20);
        framelg.add(jbuttonOk);
        
        framelg.setResizable(false);
        framelg.setLocationRelativeTo(null);
        framelg.setLayout(null);
        framelg.setVisible(true);
        framelg.setDefaultCloseOperation(framelg.EXIT_ON_CLOSE);
        
        jbuttonOk.addMouseListener(new MouseAdapter() {        
        public void mouseClicked(MouseEvent e) { 
          
                String puname = jtfUsername.getText();
                String ppaswd = jtfPass.getText();
                if (puname.equals("ASDFG") && ppaswd.equals("12345")) {
                    
                    JFrame frame = new JFrame("Beauty Saloon Customer Registration");
                    frame.setSize(350, 600);
                    
                    JLabel jlabel = new JLabel("ID");
                    jlabel.setBounds(45, 10, 80, 20);
                    frame.add(jlabel);

                    JLabel jlabel2 = new JLabel("Name");
                    jlabel2.setBounds(45, 30, 80, 20);
                    frame.add(jlabel2);

                    JLabel jlabel3 = new JLabel("Phone");
                    jlabel3.setBounds(45, 50, 80, 20);
                    frame.add(jlabel3);

                    JLabel jlabel4 = new JLabel("Date");
                    jlabel4.setBounds(45, 70, 80, 20);
                    frame.add(jlabel4);

                    JLabel jlabel5 = new JLabel("Address");
                    jlabel5.setBounds(45, 90, 80, 20);
                    frame.add(jlabel5);
                    
                    JTextField jtfid = new JTextField();
                    jtfid.setBounds(110, 10, 180, 20);
                    frame.add(jtfid);

                    JTextField jtfname = new JTextField();
                    jtfname.setBounds(110, 30, 180, 20);
                    frame.add(jtfname);

                    JTextField jtfphone = new JTextField();
                    jtfphone.setBounds(110, 50, 180, 20);
                    frame.add(jtfphone);

                    JTextField jtfaddress = new JTextField();
                    jtfaddress.setBounds(110, 70, 180, 20);
                    frame.add(jtfaddress);

                    JTextField jtfdate = new JTextField();
                    jtfdate.setBounds(110, 90, 180, 20);
                    frame.add(jtfdate);
               
                    JButton jbuttoninsert = new JButton("INSERT");
                    jbuttoninsert.setBounds(110, 120, 85, 20);
                    frame.add(jbuttoninsert);
                    jbuttoninsert.setBackground(Color.WHITE);

                    JButton jbuttonUpdate = new JButton("UPDATE");
                    jbuttonUpdate.setBounds(205, 120, 85, 20);
                    frame.add(jbuttonUpdate);
                    jbuttonUpdate.setBackground(Color.WHITE);

                    JButton jbuttonDelete = new JButton("DELETE");
                    jbuttonDelete.setBounds(110, 145, 85, 20);
                    frame.add(jbuttonDelete);
                    jbuttonDelete.setBackground(Color.WHITE);

                    JButton jbuttonSearch = new JButton("SEARCH");
                    jbuttonSearch.setBounds(205, 145, 85, 20);
                    frame.add(jbuttonSearch);
                    jbuttonSearch.setBackground(Color.WHITE);
                    
                    JButton jbuttonDetails = new JButton("DETAILS");
                    jbuttonDetails.setBounds(205, 445, 85, 20);
                    frame.add(jbuttonDetails);
                    jbuttonDetails.setBackground(Color.WHITE);

                    //table creation
                    JTable jtable = new JTable();
                    jtable.setBounds(45, 190, 250, 250);
                    frame.add(jtable);
                    jtable.setModel(dtm);
                    JScrollPane scrollPane = new JScrollPane(jtable);
                    scrollPane.setBounds(45, 190, 250, 250);
                    frame.add(scrollPane);
                    jtable.getColumnModel().getColumn(0).setPreferredWidth(80);
                    jtable.getColumnModel().getColumn(1).setPreferredWidth(80);
                    jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
                    jtable.setBackground(Color.LIGHT_GRAY);
                    
                    jbuttoninsert.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            String id = jtfid.getText();
                            if (!isInteger(id)) {
                                JOptionPane.showMessageDialog(frame, "ID should only contain integer!!!");
                                return;
                            }
                            String name = jtfname.getText().toUpperCase();
                            String phone = jtfphone.getText();
                            if (!isInteger(phone)) {
                                JOptionPane.showMessageDialog(frame, "Phone should only contain integer!!!");
                                return;
                            }
                            String address = jtfaddress.getText();
                            String date = jtfdate.getText();

                            Beauty beauty = new Beauty(id, name, phone, address, date);
                            beautylist.add(beauty);//create object list array
                            writeData();
                        }
                    });
                    
                    
                    
                    jbuttonDelete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            String id = JOptionPane.showInputDialog("ID number to delete?");
                            if (id != null) {
                                System.out.println("not null");
                                for (int i = 0; i < beautylist.size(); i++) {
                                    if (beautylist.get(i).getid().equalsIgnoreCase(id)) {
                                        beautylist.remove(i);
                                    }
                                }
                                writeData();
                            }
                        }
                    });
                     jbuttonSearch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            String iD = JOptionPane.showInputDialog("Enter ID Number?");
                            if (iD != null) {
                                for (int i = 0; i < beautylist.size(); i++) {
                                    if (beautylist.get(i).getid().equalsIgnoreCase(iD)) {
                                        JOptionPane.showMessageDialog(frame, "Found!!!");
                                        jtfid.setText(beautylist.get(i).getid());
                                        jtfname.setText(beautylist.get(i).getname());
                                        jtfphone.setText(beautylist.get(i).getphone());
                                        jtfaddress.setText(beautylist.get(i).getaddress());
                                        jtfdate.setText(beautylist.get(i).getdate());

                                        return;
                                    }
                                }
                                JOptionPane.showMessageDialog(frame, "Not Found!!!");
                            }
                        }
                    });
                     
                    jbuttonUpdate.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            String id = jtfid.getText();
                            String name = jtfname.getText();
                            String phone = jtfphone.getText();
                            String address = jtfaddress.getText();
                            String date = jtfdate.getText();

                            if (id != null) {
                                for (int i = 0; i < beautylist.size(); i++) {
                                    if (beautylist.get(i).getid().equalsIgnoreCase(id)) {
                                        beautylist.get(i).setname(name);
                                        beautylist.get(i).setphone(phone);

                                        JOptionPane.showMessageDialog(frame, "Updated!!!");
                                    }
                                }
                            }
                            writeData();
                        }
                    });
                     readData();
                    jtable.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int row = jtable.getSelectedRow();

                            jtfid.setText(dtm.getValueAt(row, 0).toString());
                            jtfname.setText(dtm.getValueAt(row, 1).toString());
                            jtfphone.setText(dtm.getValueAt(row, 2).toString());
                            jtfaddress.setText(dtm.getValueAt(row, 3).toString());
                            jtfdate.setText(dtm.getValueAt(row, 4).toString());
                            
                        }
                    });
                    
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setLayout(null);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    jbuttonDetails.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            JFrame frameD = new JFrame("DETAILS");
                            frameD.setSize(700, 250);
                            frameD.getContentPane().setBackground(Color.lightGray);
                            
                            JButton jbuttonBack = new JButton("BACK");
                            jbuttonBack.setBounds(20, 165, 85, 20);
                            frameD.add(jbuttonBack);
                            jbuttonBack.setBackground(Color.WHITE);
                            
                            //table creation
                            JTable jtable2 = new JTable();
                            jtable2.setBounds(20, 10, 650, 150);
                            frameD.add(jtable2);
                            jtable2.setModel(dtm2);
                            JScrollPane scrollPane = new JScrollPane(jtable2);
                            scrollPane.setBounds(20, 10, 650, 150);
                            frameD.add(scrollPane);
                            jtable2.getColumnModel().getColumn(0).setPreferredWidth(40);
                            jtable2.getColumnModel().getColumn(1).setPreferredWidth(180);
                            jtable2.getColumnModel().getColumn(2).setPreferredWidth(70);
                            jtable2.getColumnModel().getColumn(3).setPreferredWidth(50);
                            jtable2.getColumnModel().getColumn(4).setPreferredWidth(220);
                            
                            jbuttonDelete.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    String id = JOptionPane.showInputDialog("ID number to delete?");
                                    if (id != null) {
                                        System.out.println("not null");
                                        for (int i = 0; i < beautylist.size(); i++) {
                                            if (beautylist.get(i).getid().equalsIgnoreCase(id)) {
                                                beautylist.remove(i);
                                            }
                                        }
                                        writeData();
                                    }
                                }
                            });
                            
                             jbuttonBack.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    frameD.setVisible(false); //you can't see me!
                                    frameD.dispose();
                                }
                            });
                            
                            frameD.setResizable(false);
                            frameD.setLocationRelativeTo(null);
                            frameD.setLayout(null);
                            frameD.setVisible(true);
                            frameD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        });
        

                } else {

                    JOptionPane.showMessageDialog(null, "INVALID DATA");
                    jtfUsername.setText("");
                    jtfPass.setText("");
                    jtfUsername.requestFocus();
                }
            }
        });
    }

    public static void main(String[] args) {
         new PROJECT_SALOON22();
         
    }
       void readData() { 
        try {
            File file = new File("data.txt"); 
            file.createNewFile();
            FileReader f = new FileReader("data.txt");
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '-') {
                    System.out.println(sb);
                    String beautyarray[] = sb.toString().split(",");
                    Beauty beauty = new Beauty(beautyarray[0], beautyarray[1], beautyarray[2], beautyarray[3], beautyarray[4]);
                   beautylist.add(beauty);
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            dtm.setRowCount(0); 
            for (int i = 0; i < beautylist.size(); i++) {
                Object[] objs = {beautylist.get(i).getid(), beautylist.get(i).getname(), beautylist.get(i).getphone()
                        , beautylist.get(i).getaddress(), beautylist.get(i).getdate()};
                dtm.addRow(objs);

            }
            dtm2.setRowCount(0); 
            for (int i = 0; i < beautylist.size(); i++) {
                Object[] objs = {beautylist.get(i).getid(), beautylist.get(i).getname(), beautylist.get(i).getphone()
                       , beautylist.get(i).getaddress() , beautylist.get(i).getdate()};
                dtm2.addRow(objs);

            }
        } catch (IOException e) {
        }
    }

    private void writeData() { 
        try (FileWriter f = new FileWriter("data.txt")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < beautylist.size(); i++) {
                sb.append(beautylist.get(i).getid()+","+beautylist.get(i).getname()+","+beautylist.get(i).getphone()
                        +","+beautylist.get(i).getaddress()+","+beautylist.get(i).getdate()+"-");
            }
            f.write(sb.toString());
            f.close();
        } catch (IOException e) {
            return;
        }
        dtm.setRowCount(0); 
        for (int i = 0; i < beautylist.size(); i++) {
            Object[] objs = {beautylist.get(i).getid(),beautylist.get(i).getname(), beautylist.get(i).getphone()
                    , beautylist.get(i).getaddress(), beautylist.get(i).getdate()};
            dtm.addRow(objs);
        }
        dtm2.setRowCount(0); 
        for (int i = 0; i < beautylist.size(); i++) {
            Object[] objs = {beautylist.get(i).getid(),beautylist.get(i).getname(), beautylist.get(i).getphone()
                    , beautylist.get(i).getaddress(), beautylist.get(i).getdate()};
            dtm2.addRow(objs);
        }
    }
    public boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
}
