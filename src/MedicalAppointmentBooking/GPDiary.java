package MedicalAppointmentBooking;

import java.awt.BorderLayout;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

public class GPDiary {

    JFrame gpdiary = new JFrame();
    JPanel footer = new JPanel();
    JTable diary;
    JButton previous = new JButton("<---");
    JButton next = new JButton("--->");
    JButton back = new JButton("Back");
    Date dates = new Date();
    Connection conn;
    JScrollPane scroll;
    PreparedStatement pst;
    ResultSet rs;
    int xo = 1;
    int neg = -1;
    Date tomorrow;
    Date now = new Date();
    Calendar cal = Calendar.getInstance();
    JDateChooser x = new JDateChooser();

    public GPDiary(String name) {
        conn = javaconnect.ConnecrDb();
        String[] Columnnames = {"  Time  ", "  Date  ", "   Patient Name"};
        DefaultTableModel model = new DefaultTableModel();
        for (String Columnname : Columnnames) {
            model.addColumn(Columnname);
            gpdiary.setTitle(name+"'s Diary");
            
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
                l.setFont(new java.awt.Font("Geneva", 0, 12));

                return l;
            }
        });
        
        
        cal.setTime(dates);
        x.setDate(dates);

        x.getDateEditor().addPropertyChangeListener((PropertyChangeEvent e) -> {
            if ("date".equals(e.getPropertyName())) {
                SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-YYYY");
                String thedate = sdf.format((Date) e.getNewValue());
                String startDateString = thedate;

                // This object can interpret strings representing dates in the format MM/dd/yyyy
                DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");

                // Convert from String to Date
                Date startDate = null;
                try {
                    startDate = df.parse(startDateString);
                } catch (ParseException ex) {
                    Logger.getLogger(GPDiary.class.getName()).log(Level.SEVERE, null, ex);
                }

                String startDateString1 = df.format(startDate);
                String[] date = startDateString1.split("-");

                model.setRowCount(0);
                try {
                    String sql = "Select * from Appointment_Diary where Date = (?) and GPName = (?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, date[0] + date[1] + date[2]);
                    pst.setString(2, name);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        String PatientName = rs.getString("PatientName");
                        String timE = rs.getString("Time");
                        String Date = rs.getString("Date");
                        Object[] data = {Date, timE, PatientName};
                        model.addRow(data);
                    }

                    diary.repaint();
                    diary.revalidate();

                } catch (Exception ex) {

                }
            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((KeyEvent e) -> {
            if(e.getID()==KeyEvent.KEY_PRESSED){
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    frontmethod();
                }
            }
            return false;
        });
         KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((KeyEvent e) -> {
             if(e.getID()==KeyEvent.KEY_PRESSED){
                 if(e.getKeyCode() == KeyEvent.VK_LEFT){
                     backmethod();
                 }
             }
             return false;
        });
        next.addActionListener((ActionEvent e) -> {
           frontmethod();
        });

        previous.addActionListener((ActionEvent e) -> {
           backmethod();
        });

        back.addActionListener((ActionEvent e) -> {
            gpdiary.dispose();
        });
        scroll = new JScrollPane(diary);
        scroll.setSize(200, 100);
        footer.add(back);
        footer.add(previous);
        footer.add(x);
        footer.add(next);
        footer.setBorder(BorderFactory.createTitledBorder(" Dates "));

        gpdiary.getContentPane().add(footer, BorderLayout.NORTH);
        gpdiary.getContentPane().add(scroll, BorderLayout.CENTER);
       // gpdiary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gpdiary.setSize(400, 400);
        gpdiary.setLocationRelativeTo(null);
        //    gpdiary.setResizable(false);
        gpdiary.setVisible(true);
        gpdiary.setFont(new java.awt.Font("Geneva", 0, 15));

    }

    public final void backmethod() {
        try {
            tomorrow = cal.getTime();
            cal.add(Calendar.DAY_OF_MONTH, neg); // <--
            SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-YYYY");
            String thedate = sdf.format(tomorrow);
            String startDateString = thedate;

            // This object can interpret strings representing dates in the format MM/dd/yyyy
            DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");

                // Convert from String to Date
            Date startDate = df.parse(startDateString);

            x.setDate(startDate);

        } catch (ParseException ex) {
            Logger.getLogger(GPDiary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void frontmethod() {
        try {
                //
                tomorrow = cal.getTime();
                cal.add(Calendar.DAY_OF_YEAR, xo); // <--
                SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-YYYY");
                String thedate = sdf.format(tomorrow);
                String startDateString = thedate;

                // This object can interpret strings representing dates in the format MM/dd/yyyy
                DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");

                // Convert from String to Date
                Date startDate = df.parse(startDateString);

                x.setDate(startDate);

            } catch (ParseException ex) {
                Logger.getLogger(GPDiary.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
