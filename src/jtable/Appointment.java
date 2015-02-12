/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import java.text.DateFormat;

import java.util.Date;


/**
 *
 * @author Godwinstuff
 */
interface Appointmentdet{
    
    public String getDate();
    public String  getTime();
    public String getPName();
    public String getGPName();
   
}
public final class Appointment implements Comparable,Appointmentdet {

    Date Appointmentdate;
    DateFormat formatter;
    String ApptDate;
    String ApptTime;
    String GP;
    String patient;    
    int Id;
    public Appointment(String Date, String Time, String GPName, String PatientName, int Appointmentid){
        
        ApptDate = Date;
        ApptTime = Time;
        GP = GPName;
        patient = PatientName;
        Id = Appointmentid;
     
    }
            
    

 
    @Override
    public String getDate() {
       return ApptDate;
    }

    @Override
    public String getTime() {
   
       return ApptTime;
    }
   
   
    @Override
   
    public String getPName() {
         System.out.println("");
        return patient;
      
    }

    @Override
    public String getGPName() {
     return GP;
        
    }
    
    public int getID(){
        return Id;
    }

    @Override
    public int compareTo(Object o) {
         int compareid = ((Appointment) o).getID();
          return this.getID()-compareid ;
    }


}
