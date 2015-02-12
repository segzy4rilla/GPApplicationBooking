package jtable;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Godwinstuff
 */
public class javaconnected {
    
    Connection conn = null;

    public static Connection ConnecrDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Godwinstuff/Documents/jtable/Medical Bookng.sqlite");
           // JOptionPane.showMessageDialog(null, "Connected to Database");
            return conn;
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
}
}