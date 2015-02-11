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
    public int  getTime();
    public void setDate(String date);
    public void setTime(String time);
            
}
public final class Appointment implements Comparable,Appointmentdet {

    Date Appointmentdate;
    DateFormat formatter;
    String ApptDate;
    String ApptTime;
    String GP;
    String patient;    
    
    public Appointment(String Date, String Time, String GPName, String PatientName){
        
        ApptDate = Date;
        ApptTime = Time;
        GP = GPName;
        patient = PatientName;
        
        setDate(ApptDate);
        setTime(ApptTime);
    }
            
     @Override
    public void setDate(String dates) {
       
    }

    @Override
    public void setTime(String time) {
     
    }
    @Override
    public String getDate() {
       return "p";
    }

    @Override
    public int getTime() {
       return 0;
    }
      @Override
    public int compareTo(Object o) {
        return 0;
    }

  

}
