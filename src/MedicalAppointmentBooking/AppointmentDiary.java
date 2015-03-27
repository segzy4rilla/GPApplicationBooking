
package MedicalAppointmentBooking;

import MedicalAppointmentBooking.Appointment;
import MedicalAppointmentBooking.javaconnect;
import com.apple.eawt.Application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
                                       

public class AppointmentDiary {

    static ImageIcon frameimg;
    ArrayList<Appointment> details;
    JTable diary = new JTable();
    JPanel footer = new JPanel();
    JComboBox GP = new JComboBox();
    JComboBox Time = new JComboBox();
    JButton filter = new JButton("Filter results");
    JButton cancel = new JButton("Cancel");
    String selectedgp;
    String time;
    JScrollPane scroll;
    JRadioButton gpname;
    JRadioButton aptime;
    ButtonGroup group;
    int currentdate;
    PreparedStatement pst;
    ResultSet rs;
    Connection conn;
     DefaultTableModel model;
     JFrame Diaryframe = new JFrame("Appointment Diary");
   
     AppointmentDiary(ArrayList<Appointment> appointmentdetails) {
 
        conn = javaconnect.ConnecrDb();
        details = appointmentdetails;
       

    }
    AppointmentDiary(){
         conn = javaconnect.ConnecrDb();
    }

    public void makeframe() {

        String[] Columnnames = {"Date", "Time", "Patient Name", "GP Name"};

      

         model = new DefaultTableModel();
        for (String Columnname : Columnnames) {
            model.addColumn(Columnname);
        }
        for (Appointment detail : details) {
            Object[] data = {detail.getDate(), detail.getTime(), detail.getPName(), detail.getGPName()};
            model.addRow(data);
        }
       try{
         currentdate = Integer.parseInt(details.get(0).getDate().substring(0, 2));
         Diaryframe.setTitle("Appointment Diary"+"("+details.get(0).getDate()+")");
       }catch(IndexOutOfBoundsException ex){
           JOptionPane.showMessageDialog(null, "There's no appointment booked today","Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
        diary = new JTable(model);
        diary.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                l.setBorder(new LineBorder(Color.BLACK, 1));
                l.setBackground(new Color(165, 205, 255));
                l.setForeground(Color.WHITE);
                l.setHorizontalAlignment(JLabel.CENTER);

                return l;
            }
        });

        cancel.addActionListener((ActionEvent e) -> {
            Diaryframe.dispose();

        });
KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((KeyEvent e) -> {
            if(e.getID()==KeyEvent.KEY_PRESSED){
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    nextappt();
                }
            }
            return false;
        });
         KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((KeyEvent e) -> {
             if(e.getID()==KeyEvent.KEY_PRESSED){
                 if(e.getKeyCode() == KeyEvent.VK_LEFT){
                     previousappt();
                 }
             }
             return false;
        });
        diary.getTableHeader().setPreferredSize(new Dimension(32, 32));

        //DefaultTableModel model = new DefaultTableModel(data,columnNames);
        diary.revalidate();
        diary.repaint();

        for (Appointment detail : details) {
            GP.addItem(detail.getGPName());
            Time.addItem(detail.getTime());
        }
        group = new ButtonGroup();
        gpname = new JRadioButton();
        aptime = new JRadioButton();

        group.add(gpname);
        group.add(aptime);
        footer.add(gpname);
        footer.add(GP);
        footer.add(aptime);
        footer.add(Time);
        footer.add(filter);
        footer.add(cancel);


        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        diary.setRowSorter(sorter);
        scroll = new JScrollPane(diary);

           
            
        
            
        filter.addActionListener((ActionEvent e) -> {

            String text = (String) GP.getSelectedItem();
            String texts = (String) Time.getSelectedItem();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                if (gpname.isSelected()) {
                sorter.setRowFilter(RowFilter.regexFilter(text));
                }else{
                     sorter.setRowFilter(RowFilter.regexFilter(texts));
                }
                
            }

        });

        footer.setBorder(BorderFactory.createTitledBorder("Filter By"));

        frameimg = new ImageIcon("logo.jpg");
        Diaryframe.setIconImage(frameimg.getImage());
        Application.getApplication().setDockIconImage(frameimg.getImage());

        scroll.setSize(200, 100);
        Diaryframe.getContentPane().add(scroll, BorderLayout.NORTH);
        Diaryframe.getContentPane().add(footer, BorderLayout.SOUTH);
        Diaryframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Diaryframe.setSize(800, 540);
        Diaryframe.setLocationRelativeTo(null);
        Diaryframe.setResizable(false);
        Diaryframe.setVisible(true);
    }
    
   
    
    public void nextappt(){
        GP.removeAllItems();
        Time.removeAllItems();
         currentdate=currentdate+1;
            if(currentdate<31){
               
                 model.setRowCount(0);
              try{
                 String sql  = "Select * from Appointment_Diary where Date = (?)";
                 pst=conn.prepareStatement(sql);
                pst.setString(1,currentdate+details.get(0).getDate().substring(2,details.get(0).getDate().length()));
                 rs=pst.executeQuery();
                 while(rs.next()){
                 String PatientName = rs.getString("PatientName");
                 String GPName = rs.getString("GPName");
                 String timE = rs.getString("Time");
                 String Date = rs.getString("Date");
                 Object[]data ={Date,timE,PatientName,GPName};
                  model.addRow(data);
                 GP.addItem(GPName);
                 Time.addItem(timE);
                 }
              Diaryframe.setTitle("Appointment Diary"+"("+currentdate+details.get(0).getDate().substring(2,details.get(0).getDate().length())+")");
              }catch(Exception ex){
                  
              }
          
                diary.repaint();
                diary.revalidate();
           }
    }
     public void editappt(String date){
         
                 model.setRowCount(0);
              try{
                 String sql  = "Select * from Appointment_Diary where Date = (?)";
                 pst=conn.prepareStatement(sql);
                pst.setString(1,date);
                 rs=pst.executeQuery();
                 while(rs.next()){
                 String PatientName = rs.getString("PatientName");
                 String GPName = rs.getString("GPName");
                 String timE = rs.getString("Time");
                 String Date = rs.getString("Date");
                 Object[]data ={Date,timE,PatientName,GPName};
                  model.addRow(data);
                 GP.addItem(GPName);
                 Time.addItem(timE);
                 }
              }catch(Exception ex){
                  
              }
          
                diary.repaint();
                diary.revalidate();
    }
    
  public void previousappt(){
       GP.removeAllItems();
        Time.removeAllItems();
       currentdate = currentdate-1;
            if(currentdate!=0){
               
                 model.setRowCount(0);
              try{
                 String sql  = "Select * from Appointment_Diary where Date = (?)";
                 pst=conn.prepareStatement(sql);
                pst.setString(1,currentdate+details.get(0).getDate().substring(2,details.get(0).getDate().length()));
                 rs=pst.executeQuery();
                 while(rs.next()){
                 String PatientName = rs.getString("PatientName");
                 String GPName = rs.getString("GPName");
                 String timE = rs.getString("Time");
                 String Date = rs.getString("Date");
                 Object[]data ={Date,timE,PatientName,GPName};
                  model.addRow(data);
                 GP.addItem(GPName);
                 Time.addItem(timE);
                 }
              Diaryframe.setTitle("Appointment Diary"+"("+currentdate+details.get(0).getDate().substring(2,details.get(0).getDate().length())+")");
              }catch(Exception ex){
                  
              }
          
                diary.repaint();
                diary.revalidate();
           }
        
    }
  
}
