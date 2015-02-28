/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class writetodb {
    static Connection conn=javaconnected.ConnecrDb();
   
          static  String[] Uniname = new String[4]; 
           static String[] Uniadd = new String[4];
           static String[] Unirev = new String[4];

    public static void main(String[] args) {
         try {
             

             
         
                int filecount = 0;
            try {
                try (Scanner readfile = new Scanner ( new BufferedReader ( new FileReader("universitynames.txt")))) {
                    while (readfile.hasNext()) {
                        Uniname[filecount] = readfile.nextLine();
                        filecount++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
          
              
              int filecountone = 0;
            try {
                try (Scanner filetwo = new Scanner ( new BufferedReader ( new FileReader("universityadd.txt")))) {
                    while (filetwo.hasNext()) {
                        Uniadd[filecountone] = filetwo.nextLine();
                        filecountone++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
           
             
              
                int filecounttwo = 0;
            try {
                try (Scanner filethree = new Scanner ( new BufferedReader ( new FileReader("unireview.txt")))) {
                    while (filethree.hasNext()) {
                        Unirev[filecounttwo] = filethree.nextLine();
                        filecounttwo++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
     
          PreparedStatement pstmt = conn.prepareStatement(

                "INSERT INTO University (Universityname,Universityaddress ,Univeristyreview) VALUES(?,?,?)");
            for (int i=0; i < Uniname.length; i++) {

                pstmt.setString(1, Uniname[i]);

                pstmt.setString(2,Uniadd[i]);
                
                pstmt.setString(3, Unirev[i]);

          
             
                pstmt.addBatch();

            }
            pstmt.executeBatch();
          
            conn.close();

        } catch (SQLException e) {
             System.out.println(e);
        }

    }
}

    
