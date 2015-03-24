/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import com.apple.eawt.Application;
import com.toedter.calendar.JDateChooser;

//import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Godwinstuff
 */
public final class Tablex {

    static Boolean past = false;
    static Connection conn = null;
    static JTable table;
    static JComboBox Month;
    static JComboBox Days;
    String patient;
    int id;
    Date dates = new Date();
    DateFormat curday;
    DateFormat curmonth;
    DateFormat curyear;

    Tablex(String patientname) {
        conn = javaconnected.ConnecrDb();

        patient = patientname;
        curday = new SimpleDateFormat("d");
        curmonth = new SimpleDateFormat("M");
        curyear = new SimpleDateFormat("YYYY");

        maketable();
    }
    String selectedday;
    String selectedyear;
    String selectedmonth;
    int dayindex = 0;

    int yearindex = 0;
    String x = "";
    int selection = 1;
    ArrayList<Appointment> Appt = new ArrayList<>();
    String t93010 = "FREE";
    String t101030 = "FREE";
    String t103011 = "FREE";
    String t1130 = "FREE";
    String t1302 = "FREE";
    String t2230 = "FREE";
    String Appttime;
    String ApptDate;
    String GPName;
    String GP_ID;
    String PatientID;
    String[] Julie = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] Sabha = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] Simmy = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] Zara = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] Amy = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] Helen = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] Smith = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] Jalooga = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};
    String[] month = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    ImageIcon frameimg;
    PreparedStatement pst;
    ResultSet rs;

    
    public void maketable() {

        JFrame fray = new JFrame("PickAdate");

        JButton view = new JButton("View Diary");
        JLabel appt = new JLabel("Appointment info : ");

        JPanel drop = new JPanel();
        JDateChooser date = new JDateChooser();

        view.setForeground(Color.red);
        frameimg = new ImageIcon("logo.jpg");

        drop.add(date, BorderLayout.NORTH);
        drop.add(view, BorderLayout.NORTH);

        fray.pack();

        fray.setIconImage(frameimg.getImage());
        Application.getApplication().setDockIconImage(frameimg.getImage());

        drop.setBackground(Color.WHITE);
        drop.setFont(new java.awt.Font("Geneva", 0, 18));
        //  fray.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fray.setResizable(false);
        fray.setSize(790, 300);

        fray.getContentPane().add(drop, BorderLayout.CENTER);

        fray.setLocationRelativeTo(null);
        fray.setVisible(true);
        fray.setFont(new java.awt.Font("Geneva", 0, 18));

        view.addActionListener((ActionEvent e) -> {

            if (((JTextField) date.getDateEditor().getUiComponent()).getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Date should be filled");
            } else {

                String d1 = ((JTextField) date.getDateEditor().getUiComponent()).getText();

                String[] Split = d1.split("-");
                selectedday = Split[0];
                String datechoose = Split[1];
                for (String month1 : month) {
                    if (datechoose.equals(month1.substring(0, 3))) {
                        selectedmonth = month1;
                    }
                }

                int monthpos = 0;
                for (int i = 0; i < month.length; i++) {
                    if (month[i].equals(selectedmonth)) {
                        monthpos = i;
                    }

                }

                selectedyear = Split[2];

                if (Integer.parseInt(selectedyear) < Integer.parseInt(curyear.format(dates))) {
                    past = true;
                } else if (Integer.parseInt(selectedyear) == Integer.parseInt(curyear.format(dates))) {
                    if (Integer.parseInt(curmonth.format(dates)) - 1 < monthpos) {
                        past = false;
                    } else if (Integer.parseInt(curmonth.format(dates)) - 1 == monthpos) {
                        if (Integer.parseInt(selectedday) < Integer.parseInt(curday.format(dates))) {
                            past = true;
                        } else if (Integer.parseInt(selectedday) == Integer.parseInt(curday.format(dates))) {
                            past = false;
                        } else {
                            past = false;
                        }
                    } else {
                        past = true;
                    }
                } else {
                    past = false;
                }

                fray.setVisible(false);

                for (int i = 0; i < 6; i++) {
                    Julie[i] = "FREE";
                    Sabha[i] = "FREE";
                    Simmy[i] = "FREE";
                    Zara[i] = "FREE";
                    Amy[i] = "FREE";
                    Helen[i] = "FREE";
                    Smith[i] = "FREE";
                    Jalooga[i] = "FREE";
                }
                searchdb();
                Mytable a = new Mytable(Julie, Sabha, Simmy, Zara, Amy, Helen, Smith, Jalooga, selectedday,
                        selectedmonth, selectedyear, Appt, patient, past);
             a.makeframe();

                //    System.out.println(selectedday + selectedmonth + selectedyear);
                fray.revalidate();
                fray.repaint();
            }
        });

    }

    public void searchdb() {

        //System.out.println(selectedday + selectedmonth + selectedyear);
        
        String sql = "select Time,GPName,Date,PatientName from Appointment_Diary where Date=?";
        try {

            pst = conn.prepareStatement(sql);
            pst.setString(1, selectedday + selectedmonth + selectedyear);
            rs = pst.executeQuery();
            while (rs.next()) {
                String result = rs.getString("Time");
                String Name = rs.getString("GPName");
                String Date = rs.getString("Date");
                String PName = rs.getString("PatientName");

                switch (result) {
                    case "9:30am-10:00am":
                        id = 0;
                        break;
                    case "10:00am-10:30am":
                        id = 1;
                        break;
                    case "10:30am-11:00am":
                        id = 3;
                        break;
                    case "13:00pm-13:30pm":
                        id = 4;
                        break;
                    case "13:30pm-14:00pm":
                        id = 5;
                        break;
                    default:
                        id = 6;
                        break;
                }
                Appt.add(new Appointment(Date, result, Name, PName, id));

                // System.out.println(result + Name + Date);
                if (Name.equals("Dr. Zara")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Zara[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Zara[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Zara[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Zara[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Zara[4] = "BOOKED";
                            break;
                        default:
                            Zara[5] = "BOOKED";
                            break;
                    }
                }
                if (Name.equals("Dr. Julie")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Julie[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Julie[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Julie[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Julie[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Julie[4] = "BOOKED";
                            break;
                        default:
                            Julie[5] = "BOOKED";
                            break;
                    }
                }
                if (Name.equals("Dr. Simmy")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Simmy[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Simmy[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Simmy[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Simmy[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Simmy[4] = "BOOKED";
                            break;
                        default:
                            Simmy[5] = "BOOKED";
                            break;
                    }

                }
                if (Name.equals("Dr. Sabha")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Sabha[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Sabha[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Sabha[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Sabha[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Sabha[4] = "BOOKED";
                            break;
                        default:
                            Sabha[5] = "BOOKED";
                            break;
                    }

                }
                if (Name.equals("Dr. Amy")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Amy[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Amy[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Amy[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Amy[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Amy[4] = "BOOKED";
                            break;
                        default:
                            Amy[5] = "BOOKED";
                            break;
                    }

                }
                if (Name.equals("Dr. Helen")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Helen[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Helen[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Helen[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Helen[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Helen[4] = "BOOKED";
                            break;
                        default:
                            Helen[5] = "BOOKED";
                            break;
                    }

                }
                if (Name.equals("Dr. Smith")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Smith[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Smith[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Smith[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Smith[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Smith[4] = "BOOKED";
                            break;
                        default:
                            Smith[5] = "BOOKED";
                            break;
                    }

                }
                if (Name.equals("Dr. Jalooga")) {
                    switch (result) {
                        case "9:30am-10:00am":
                            Jalooga[0] = "BOOKED";
                            break;
                        case "10:00am-10:30am":
                            Jalooga[1] = "BOOKED";
                            break;
                        case "10:30am-11:00am":
                            Jalooga[2] = "BOOKED";
                            break;
                        case "13:00pm-13:30pm":
                            Jalooga[3] = "BOOKED";
                            break;
                        case "13:30pm-14:00pm":
                            Jalooga[4] = "BOOKED";
                            break;
                        default:
                            Jalooga[5] = "BOOKED";
                            break;
                    }

                }

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }
}
