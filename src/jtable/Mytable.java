/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import com.apple.eawt.Application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import static jtable.Tablex.conn;

/**
 *
 * @author Godwinstuff
 */
public class Mytable {
    
    JTable table;
    JFrame tableframe = new JFrame("The timetable");
    JScrollPane tablescroll;
    String[] Julie;
    String[] Sabha;
    String[] Simmy;
    String[] Zara;
    String[] Amy;
    String[] Helen;
    String[] Smith;
    String[] Jalooga;
    String day;
    String month;
    String year;
    int selection = 1;
    JPanel Confirm = new JPanel();
    JLabel Apptinfo;
    JButton back;
    JButton confirm;
    String GPName;
    String PatientName;
    String ApptDate;
    String Appttime;
    PreparedStatement pst;
    ImageIcon frameimg;
    ArrayList<Appointment> Appointmentdetails = new ArrayList<>();
    String GP;
    String Patient;
    int bookedrow = 0;
    int bookedcolumn = 0;
    boolean pastdetails;
    int currentrow = 0;
    int currentcolumn = 0;
    JButton Diary;
    int saveclick = 0;
    
    Mytable(String[] Jul, String[] Seven, String[] Simran, String[] Zazu, String[] Amie, String[] hel,
            String[] Smi, String[] Jal, String Day, String Month, String Year, ArrayList<Appointment> APPoint, String PName, boolean pastdet) {
        
        Julie = Jul;
        Sabha = Seven;
        Simmy = Simran;
        Zara = Zazu;
        Amy = Amie;
        Helen = hel;
        Smith = Smi;
        Jalooga = Jal;
        day = Day;
        month = Month;
        year = Year;
        Appointmentdetails = APPoint;
        PatientName = PName;
        pastdetails = pastdet;
    }
    
    public void makeframe() {
        
        String[] Columnnames = {"Doctors Name", "9:30am-10:00am", "10:00am-10:30am", "10:30am-11:00am", "13:00pm-13:30pm", "13:30pm-14:00pm", "14:00pm-14:30pm"};
        Apptinfo = new JLabel("Appointment Info:");
        
        Object data[][] = {
            {"Dr. Sabha", Sabha[0], Sabha[1], Sabha[2], Sabha[3], Sabha[4], Sabha[5]},
            {"Dr. Simmy", Simmy[0], Simmy[1], Simmy[2], Simmy[3], Simmy[4], Simmy[5]},
            {"Dr. Zara", Zara[0], Zara[1], Zara[2], Zara[3], Zara[4], Zara[5]},
            {"Dr. Amy", Amy[0], Amy[1], Amy[2], Amy[3], Amy[4], Amy[5]},
            {"Dr. Helen", Helen[0], Helen[1], Helen[2], Helen[3], Helen[4], Helen[5]},
            {"Dr. Julie", Julie[0], Julie[1], Julie[2], Julie[3], Julie[4], Julie[5]},
            {"Dr.Smith", Smith[0], Smith[1], Smith[2], Smith[3], Smith[4], Smith[5]},
            {"Dr. Jalooga", Jalooga[0], Jalooga[1], Jalooga[2], Jalooga[3], Jalooga[4], Jalooga[5]}
        
        };
        
        table = new JTable(data, Columnnames);
        
        frameimg = new ImageIcon("logo.jpg");
        
        back = new JButton("BACK");
        table.setGridColor(Color.BLUE);
        confirm = new JButton(" Save ");
        confirm.setEnabled(false);
        table.setBackground(Color.white);
        table.setCellSelectionEnabled(true);
        table.setSelectionForeground(Color.red);
        table.setSelectionBackground(Color.white);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
                    int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                switch (value.toString()) {
                    case "BOOKED":
                        setForeground(Color.red);
                        break;
                    case "FREE":
                        setForeground(Color.blue);
                        break;
                    default:
                        setForeground(Color.black);
                        break;
                }
                
                return this;
            }
        });
        table.addMouseListener(new MouseListener() {
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                if (!pastdetails && saveclick == 0) {
                    Point point = e.getPoint();
                    
                    int row, column;
                    row = table.rowAtPoint(point);
                    column = table.columnAtPoint(point);
                    
                    if (column != 0) {
                        if (!table.getValueAt(row, column).equals("BOOKED")) {
                            if (currentrow == 0 && currentcolumn == 0) {
                                
                                currentrow = row;
                                currentcolumn = column;
                                
                            } else {
                                
                                table.setValueAt("FREE", currentrow, currentcolumn);
                                currentrow = row;
                                currentcolumn = column;
                                table.revalidate();
                                table.repaint();
                            }
                        }
                    }
                    
                    if (table.getValueAt(row, column).equals("FREE") || table.getValueAt(row, column).equals("BOOKED")) {
                        if (table.getValueAt(row, column).equals("BOOKED")) {
                            
                            for (Appointment Appointmentdetail : Appointmentdetails) {
                                if (Appointmentdetail.getGPName().equals(table.getValueAt(row, 0))) {
                                    if (Appointmentdetail.getTime().equals(table.getColumnName(column))) {
                                        GP = Appointmentdetail.getGPName();
                                        Patient = Appointmentdetail.getPName();
                                    }
                                }
                            }
                            int choice = JOptionPane.showOptionDialog(null, "Patient Name:" + " " + Patient + "\n GP Name:" + " " + GP + " \n Time:" + " " + table.getColumnName(column) + "\n Date:" + " " + day + " " + month + " " + year + "\n",
                                    "Appointment Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                    null, new String[]{"Close", "Cancel Appointment"}, "default");
                            
                            if (choice == JOptionPane.OK_OPTION) {
                                table.setValueAt("BOOKED", row, column);
                                confirm.setEnabled(true);
                            } else if (choice == JOptionPane.INFORMATION_MESSAGE) {
                                int secchoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Cancel this Appointment!!!");
                                if (secchoice == JOptionPane.OK_OPTION) {
                                    table.setValueAt("FREE", row, column);
                                    try {
                                        String sql = "Delete From Appointment_Diary where GPName = (?) AND Time = (?)";
                                        pst = conn.prepareStatement(sql);
                                        
                                        pst.setString(1, GP);
                                        pst.setString(2, table.getColumnName(column));
                                        
                                        pst.execute();
                                    } catch (Exception exe) {
                                        System.out.println(exe);
                                    }
                                } else if (secchoice == JOptionPane.CANCEL_OPTION) {
                                    table.setValueAt("BOOKED", row, column);
                                }
                            }
                            Apptinfo.setText("Appointment Info:");
                            //   confirm.setEnabled(false);
                            table.revalidate();
                            table.repaint();
                        } else {
                            
                            table.setValueAt("BOOKED", row, column);
                            
                            table.setCellSelectionEnabled(true);
                            table.setRowSelectionAllowed(false);
                            table.setColumnSelectionAllowed(false);
                            table.setEditingRow(row);
                            confirm.setEnabled(true);
                        }
                        selection++;
                        Apptinfo.setForeground(Color.red);
                        Apptinfo.setText("Appointmemnt info : " + " " + table.getValueAt(row, 0) + " " + "at" + " " + table.getColumnName(column) + " " + "on" + " " + day + " " + month + " " + year);
                        
                        GPName = (String) table.getValueAt(row, 0);
                        ApptDate = (day + month + year);
                        Appttime = (String) table.getColumnName(column);
                    }
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        back.addActionListener((ActionEvent e) -> {
            Tablex tab = new Tablex(PatientName);
            tableframe.dispose();
            
        });
        Diary = new JButton(day + " " + month + " Diary");
        Diary.addActionListener((ActionEvent e) -> {
            Collections.sort(Appointmentdetails);
            
            AppointmentDiary diary = new AppointmentDiary(Appointmentdetails);
            diary.makeframe();
            
        });
        
        confirm.addActionListener((ActionEvent e) -> {
            int choice = JOptionPane.showOptionDialog(null, " Do you want to confirm this appointment",
                    "Appointment Information", JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION,
                    null, new String[]{"Cancel", "Confirm"}, "default");
            if (choice == JOptionPane.INFORMATION_MESSAGE) {
                try {
                    String sql = "Insert Into Appointment_Diary(PatientName,GPName,Time,Date) values (?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    
                    pst.setString(1, PatientName);
                    pst.setString(2, GPName);
                    pst.setString(3, Appttime);
                    pst.setString(4, ApptDate);
                    
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(null, "Appointment Booked");
                    saveclick++;
                    confirm.setEnabled(false);
                } catch (SQLException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } else {
                
            }
        });
        
        Confirm.add(Apptinfo);
        if (!pastdetails) {
            Confirm.add(confirm);
        }
        
        Confirm.add(Diary);
        Confirm.add(back);
        tablescroll = new JScrollPane(table);
        table.revalidate();
        table.repaint();
        tableframe.setTitle("Doctors Timetable" + " " + "(" + day + " " + month + " " + year + ")");
        tablescroll.setSize(200, 100);
        
        tableframe.setIconImage(frameimg.getImage());
        Application.getApplication().setDockIconImage(frameimg.getImage());
        //  tableframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableframe.getContentPane().add(tablescroll, BorderLayout.NORTH);
        tableframe.getContentPane().add(Confirm, BorderLayout.SOUTH);
        tableframe.setSize(750, 500);
        tableframe.setLocationRelativeTo(null);
        tableframe.setVisible(true);
    }
}
