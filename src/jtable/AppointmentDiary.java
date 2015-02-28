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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Godwinstuff
 */
public class AppointmentDiary {

    static ImageIcon frameimg;
    ArrayList<Appointment> details;
    JTable diary = new JTable();
    JPanel footer = new JPanel();
    JComboBox GP = new JComboBox();
    JComboBox Time = new JComboBox();
    JButton filter = new JButton("Filter results");
    JButton back = new JButton("Back");
    JButton cancel = new JButton("Cancel");
    String selectedgp;
    String time;
    JScrollPane scroll;
    JRadioButton gpname;
    JRadioButton aptime;
    ButtonGroup group;
    

    AppointmentDiary(ArrayList<Appointment> appointmentdetails) {

        details = appointmentdetails;

    }

    public void makeframe() {

        String[] Columnnames = {"Date", "Time", "Patient Name", "GP Name"};

        JFrame Diaryframe = new JFrame("Appointment Diary");

        DefaultTableModel model = new DefaultTableModel();
        for (String Columnname : Columnnames) {
            model.addColumn(Columnname);
        }
        for (Appointment detail : details) {
            Object[] data = {detail.getDate(), detail.getTime(), detail.getPName(), detail.getGPName()};
            model.addRow(data);
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

        back.addActionListener((ActionEvent e) -> {

            Diaryframe.dispose();

        });
        cancel.addActionListener((ActionEvent e) -> {
            Diaryframe.dispose();

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
        footer.add(back);

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

}
