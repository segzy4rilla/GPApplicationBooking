package jtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zayn
 */
import java.sql.*;
import javax.swing.*;
public class javaconnect {
    
   Connection conned = null;

    public static Connection ConnecrDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conned = DriverManager.getConnection("jdbc:sqlite:/Users/Godwinstuff/Downloads/medicalDBe.sqlite");
            return conned;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
 
    
}
}
