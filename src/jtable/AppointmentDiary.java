/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import com.apple.eawt.Application;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Godwinstuff
 */
public class AppointmentDiary {

    static ImageIcon frameimg;
    JTable diary = new JTable();

    ; 

    public void makeframe() {

        String[] Columnnames = {"Doctors Name", "9:30am-10:00am", "10:00am-10:30am", "10:30am-11:00am", "13:00pm-13:30pm", "13:30pm-14:00pm", "14:00pm-14:30pm"};

        JFrame Diaryframe = new JFrame("Appointment Diary");

        Object data[][] = {
            {"Dr. Sabha", "a", "a", "a", "a", "a", "a"},
            {"Dr. Simmy", "a", "a", "a", "a", "a", "a"},
            {"Dr. Zara", "a", "a", "a", "a", "a", "a"},
            {"Dr. Amy", "a", "a", "a", "a", "a", "a"},
            {"Dr. Helen", "a", "a", "a", "a", "a", "a"},
            {"Dr. Julie", "a", "a", "a", "a", "a", "a"},
            {"Dr.Smith", "a", "a", "a", "a", "a", "a"},
            {"Dr. Jalooga", "a", "a", "a", "a", "a", "a"}

        };

        diary = new JTable(data, Columnnames);
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

        diary.getTableHeader().setPreferredSize(new Dimension(32, 32));

    //DefaultTableModel model = new DefaultTableModel(data,columnNames);
        diary.revalidate();
        diary.repaint();

        frameimg = new ImageIcon("logo.jpg");
        Diaryframe.setIconImage(frameimg.getImage());
        Application.getApplication().setDockIconImage(frameimg.getImage());
        JScrollPane scroll = new JScrollPane(diary);

        scroll.setSize(200, 100);
        Diaryframe.getContentPane().add(scroll);
        Diaryframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Diaryframe.setSize(400, 400);
        Diaryframe.setVisible(true);
    }

}
