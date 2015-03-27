    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalAppointmentBooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class writetodb {
    static Connection conn=javaconnect.ConnecrDb();
   
          static  String[] Carmake = new String[57]; 
         static  String[] Carmodel = new String[57]; 
         static  String[] Carbodytype = new String[57]; 
         static  String[] Carprice = new String[57];
         static  String[] Cartransmission = new String[57]; 
         static  String[] Cardoor = new String[57]; 
         static  String[] Carfueltype = new String[57]; 
           static  String[] Carengine = new String[57]; 
          static  String[] Carclass = new String[57]; 


    public static void main(String[] args) {
         try {
             

             
         
                int filecount = 0;
            try {
                try (Scanner readfile = new Scanner ( new BufferedReader ( new FileReader("make.txt")))) {
                    while (readfile.hasNext()) {
                        Carmake[filecount] = readfile.nextLine();
                        filecount++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
          
              
              int filecountone = 0;
            try {
                try (Scanner filetwo = new Scanner ( new BufferedReader ( new FileReader("model.txt")))) {
                    while (filetwo.hasNext()) {
                        Carmodel[filecountone] = filetwo.nextLine();
                        filecountone++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
           
             
              
                int filecounttwo = 0;
            try {
                try (Scanner filethree = new Scanner ( new BufferedReader ( new FileReader("price.txt")))) {
                    while (filethree.hasNext()) {
                        Carprice[filecounttwo] = filethree.nextLine();
                        filecounttwo++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
      
                int filecountthree = 0;
            try {
                try (Scanner filefour = new Scanner ( new BufferedReader ( new FileReader("BodyType.txt")))) {
                    while (filefour.hasNext()) {
                        Carbodytype[filecountthree] = filefour.nextLine();
                        filecountthree++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
      
                int filecountfour = 0;
            try {
                try (Scanner filefive = new Scanner ( new BufferedReader ( new FileReader("Transmission.txt")))) {
                    while (filefive.hasNext()) {
                        Cartransmission[filecountfour] = filefive.nextLine();
                        filecountfour++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
      
                int filecountfive = 0;
            try {
                try (Scanner filesix = new Scanner ( new BufferedReader ( new FileReader("Door.txt")))) {
                    while (filesix.hasNext()) {
                        Cardoor[filecountfive] = filesix.nextLine();
                        filecountfive++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
      
                int filecountsix = 0;
            try {
                try (Scanner fileseven = new Scanner ( new BufferedReader ( new FileReader("FuelType.txt")))) {
                    while (fileseven.hasNext()) {
                        Carfueltype[filecountsix] = fileseven.nextLine();
                        filecountsix++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
      
                int filecountseven = 0;
            try {
                try (Scanner fileeight = new Scanner ( new BufferedReader ( new FileReader("EngineSize.txt")))) {
                    while (fileeight.hasNext()) {
                        Carengine[filecountseven] = fileeight.nextLine();
                        filecountseven++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
      
                int filecounteight = 0;
            try {
                try (Scanner filenine = new Scanner ( new BufferedReader ( new FileReader("Class.txt")))) {
                    while (filenine.hasNext()) {
                        Carclass[filecounteight] = filenine.nextLine();
                        filecounteight++;
                    }   }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
       }
     
          PreparedStatement pstmt = conn.prepareStatement(

                "INSERT INTO universities (name) VALUES(?)");
            for (int i=0; i < Carclass.length; i++) {

                pstmt.setString(1, Carclass[i]);

                pstmt.addBatch();

            }
            pstmt.executeBatch();
          
            conn.close();

        } catch (SQLException e) {
             System.out.println(e);
        }

    }
}

    
