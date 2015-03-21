
package jtable;

import java.awt.BorderLayout;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GPdia {

    JFrame gpdiary = new JFrame();
    JPanel footer = new JPanel();
    JTable diary;
    JButton back = new JButton("BACK");
    JButton next = new JButton("NEXT");
    Date dates = new Date();
    Connection conn;
    JScrollPane scroll;
    PreparedStatement pst;
    ResultSet rs;
int xo = 1;
int neg = -1;

    public GPdia(String name) {
        conn  = javaconnected.ConnecrDb();
        String[] Columnnames = { "  Time  ","  Date  ","   Patient Name"};
          DefaultTableModel model = new DefaultTableModel();
        for (String Columnname : Columnnames) {
            model.addColumn(Columnname);
        }
        
        model.addRow(Columnnames);
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
         
      
        JDateChooser x = new JDateChooser();

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
          cal.setTime(dates);
        x.setDate(dates);
        
        next.addActionListener((ActionEvent e) -> {
             
            try {
                //
                
       Date tomorrow = cal.getTime();
      
            cal.add(Calendar.DAY_OF_YEAR, xo); // <--
           SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-YYYY"); 
           String thedate = sdf.format(tomorrow);               
                String startDateString = thedate;
                
                // This object can interpret strings representing dates in the format MM/dd/yyyy
                DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
                
                // Convert from String to Date
                Date startDate = df.parse(startDateString);
            
                String startDateString1 = df.format(startDate);
               String[]date = startDateString1.split("-");
              
                 
                x.setDate(startDate);                
                 model.setRowCount(0);
              try{
                 String sql  = "Select * from Appointment_Diary where Date = (?)";
                 pst=conn.prepareStatement(sql);
                pst.setString(1, date[0]+date[1]+date[2]);
                 rs=pst.executeQuery();
                 while(rs.next()){
                 String PatientName = rs.getString("PatientName");
                 String GPName = rs.getString("GPName");
                 String timE = rs.getString("Time");
                 String Date = rs.getString("Date");
                 Object[]data ={Date,timE,PatientName,GPName};
                  model.addRow(data);
       
                 }
                 
                diary.repaint();
                diary.revalidate();
                
              }catch(Exception ex){
                  
              }
          
            } catch (ParseException ex) {
                Logger.getLogger(GPdia.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        });
        back.addActionListener((ActionEvent e) -> {
  try {
        Date yesterday = cal.getTime();
      
            cal.add(Calendar.DAY_OF_YEAR, neg); // <--
            SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-YYYY"); 
           String thedate = sdf.format(yesterday);
           String startDateString = thedate;
                
                // This object can interpret strings representing dates in the format MM/dd/yyyy
                DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

                // Convert from String to Date
                Date startDate = df.parse(startDateString);
            
                String startDateString1 = df.format(startDate);
  
                x.setDate(startDate);
                      model.setRowCount(0);
              String[]date = startDateString1.split("-");
              try{
                 String sql  = "Select * from Appointment_Diary where Date = (?)";
                 pst=conn.prepareStatement(sql);
                pst.setString(1, date[0]+date[1]+date[2]);
                 rs=pst.executeQuery();
                 while(rs.next()){
                 String backPatientName = rs.getString("PatientName");
                 String backGPName = rs.getString("GPName");
                 String backtimE = rs.getString("Time");
                 String backDate = rs.getString("Date");
                 Object[]data ={backDate,backtimE,backPatientName,backGPName};
                  model.addRow(data);
       
                 }
                 
                diary.repaint();
                diary.revalidate();
              }catch(Exception ex){
                  
              }
          
            } catch (ParseException ex) {
                Logger.getLogger(GPdia.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
          scroll=new JScrollPane(diary);
          scroll.setSize(200, 100);
        footer.add(back);
        footer.add(x);
        footer.add(next);
        footer.setBorder(BorderFactory.createTitledBorder(" Dates "));

        gpdiary.getContentPane().add(footer, BorderLayout.NORTH);
        gpdiary.getContentPane().add(scroll, BorderLayout.CENTER);
        gpdiary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gpdiary.setSize(400, 400);
        gpdiary.setLocationRelativeTo(null);
        //    gpdiary.setResizable(false);
        gpdiary.setVisible(true);
   
    }

   
       
    
}
