package MedicalAppointmentBooking;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zayn
 */
public class main_menu1 extends javax.swing.JFrame {

    ArrayList<Appointment> Appt = new ArrayList<>();
    Connection conn;
    int id;
    PreparedStatement pst;
    ResultSet rs;
    Date dates = new Date();
    DateFormat curday;
    DateFormat curmonth;
    DateFormat curyear;
  

    /**
     * Creates new form main_menu
     */
    public main_menu1() {
        initComponents();
        String[] month = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        conn = javaconnect.ConnecrDb();
        curday = new SimpleDateFormat("dd");
        curmonth = new SimpleDateFormat("M");
        curyear = new SimpleDateFormat("YYYY");

        
        String sql = "select Time,GPName,Date,PatientName from Appointment_Diary where Date=?";
        try {

            pst = conn.prepareStatement(sql);
            pst.setString(1, curday.format(dates) + month[Integer.parseInt(curmonth.format(dates)) - 1] + curyear.format(dates));
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
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Collections.sort(Appt);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        patient_btn = new javax.swing.JButton();
        gp_diary = new javax.swing.JButton();
        appointment_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Geneva", 1, 24)); // NOI18N
        jLabel3.setText("Menu");

        patient_btn.setFont(new java.awt.Font("Geneva", 1, 24)); // NOI18N
        patient_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MedicalAppointmentBooking/People-Patient-Male-icon.png"))); // NOI18N
        patient_btn.setText("Patient Info");
        patient_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_btnActionPerformed(evt);
            }
        });

        gp_diary.setFont(new java.awt.Font("Geneva", 1, 24)); // NOI18N
        gp_diary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MedicalAppointmentBooking/Holiday-Diary-Book-icon.png"))); // NOI18N
        gp_diary.setText("GP Diary");
        gp_diary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gp_diaryActionPerformed(evt);
            }
        });

        appointment_btn.setFont(new java.awt.Font("Geneva", 1, 24)); // NOI18N
        appointment_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MedicalAppointmentBooking/Actions-appointment-new-icon.png"))); // NOI18N
        appointment_btn.setText("Appointment Diary");
        appointment_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointment_btnActionPerformed(evt);
            }
        });

        logout_btn.setFont(new java.awt.Font("Geneva", 1, 24)); // NOI18N
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MedicalAppointmentBooking/Log-Out-icon.png"))); // NOI18N
        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(appointment_btn)
                            .addComponent(patient_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(gp_diary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(167, 167, 167))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appointment_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gp_diary, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void patient_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_btnActionPerformed
        // TODO add your handling code here:
        patient_page s = new patient_page();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_patient_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
        login_page s = new login_page();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void appointment_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointment_btnActionPerformed
        AppointmentDiary diary = new AppointmentDiary(Appt);
        diary.makeframe();
    }//GEN-LAST:event_appointment_btnActionPerformed

    private void gp_diaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gp_diaryActionPerformed

     String[]GP= {"Dr. Julie","Dr. Sabha","Dr. Simmy","Dr. Zara","Dr. Amy","Dr. Helen","Dr. Smith","Dr. Jalooga"};
        JComboBox jcb = new JComboBox(GP);
        jcb.setEditable(true);
        JOptionPane.showMessageDialog(null, jcb, "Choose a GP", JOptionPane.QUESTION_MESSAGE);
      String GPNAME = (String)jcb.getSelectedItem();
        GPDiary a = new GPDiary(GPNAME);
    }//GEN-LAST:event_gp_diaryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main_menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_menu1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appointment_btn;
    private javax.swing.JButton gp_diary;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton patient_btn;
    // End of variables declaration//GEN-END:variables
}
