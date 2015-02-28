package jtable;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zayn
 */
public class patient_page extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
 String add1;
  String add2;
    /**
     * Creates new form patient_page
     */
    public patient_page() {
        initComponents();
        conn = javaconnect.ConnecrDb();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        search_results.setVisible(false);
        patient_id.setVisible(false);


    }
    private void new_patient(){
                try {
            String sql = "Insert Into Patients (Title,FIRSTNAME,SURNAME,DOB,EMAIL_ADD,ADD_1,ADD_2,COUNTY,POSTCODE,TEL,E_TEL) values (?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            String title =(String)title_combo.getSelectedItem();
             pst.setString(1, title);
             pst.setString(2, FirstName.getText());
             pst.setString(3, Surname.getText());
             pst.setString(4, dob.getText());
             pst.setString(5, email.getText());
             pst.setString(6, add_1.getText());
             pst.setString(7, add_2.getText());
             pst.setString(8, town.getText());
             pst.setString(9, postcode.getText());
             pst.setString(10, mobile.getText());
             pst.setString(11, home.getText());            
             
             pst.execute();
            
            JOptionPane.showMessageDialog(null, "Patient Registered");
            new_patient.setVisible(false);
                    
                    
        
         }catch(Exception e ){
             JOptionPane.showMessageDialog(null, e);
         }
         finally {
        try{
        rs.close(); pst.close(); }
        catch(Exception e) 
        { } }
    
    
    }
    
    private void validation(){
    if (FirstName.getText().equals("")||Surname.getText().equals("")||dob.getText().equals("")||email.getText().equals("")||add_1.getText().equals("")||town.getText().equals("")||postcode.getText().equals("")||mobile.getText().equals("")||home.getText().equals("") ) {
    JOptionPane.showMessageDialog(null, "Please Complete All Feilds");
    }
    else {
        new_patient();
    
    }
    
    
    
    
    }
    
    private void view_patient(){
            view_title.setEnabled(false);
            view_firstname.setEditable(false);
            view_surname.setEditable(false);
            view_dob.setEditable(false);
            view_email.setEditable(false);
            view_add1.setEditable(false);
            view_add2.setEditable(false);
            view_town.setEditable(false);
            view_mobile.setEditable(false);
            view_home.setEditable(false);
            view_postcode.setEditable(false);
            cancel_btn.setVisible(false);
            delete_btn.setVisible(false);
            update_btn.setVisible(false);
            edit_btn.setVisible(true);


    
    
    }
    
    private void clear_search(){
    search_firstname.setText("");
    search_surname.setText("");
    search_dob.setText("");
    search_postcode.setText("");
    search_results.setVisible(false);

    
    
    
    }
    
    private void new_search(){
            try
        {
            int results = search_results.getRowCount();
            String sql="select Title,FIRSTNAME as 'First Name',SURNAME as 'Surname',DOB as 'Date of Birth',ADD_1 as 'Address',POSTCODE as 'Postcode' from Patients where FIRSTNAME LIKE ('%' || ? || '%') AND SURNAME LIKE ('%' || ? || '%') AND DOB LIKE ('%' || ? || '%') AND POSTCODE LIKE ('%' || ? || '%') ORDER BY FIRSTNAME"; 
            pst=conn.prepareStatement(sql);
            pst.setString(1,search_firstname.getText());
            pst.setString(2,search_surname.getText());
            pst.setString(3,search_dob.getText());
            pst.setString(4,search_postcode.getText());

            rs=pst.executeQuery();
            search_results.setModel(DbUtils.resultSetToTableModel(rs));
            if(results ==0){
        JOptionPane.showMessageDialog(null, "No Patient Record Found");   
        search_results.setVisible(false);
        
        }else{
           search_results.setVisible(true);          
            }
            
        }catch(Exception e){
        }
        finally {
        try{
        rs.close(); pst.close(); }
        catch(Exception e) { } }
    }


    
    private void search_final(){

        if(search_firstname.getText().equals("") && search_surname.getText().equals("") && search_dob.getText().equals("") && search_postcode.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Text to Search","Error",JOptionPane.ERROR_MESSAGE);
       /* }else if(results ==0){
            JOptionPane.showMessageDialog(null, "No Records Found");  

        */}
        else{
        new_search();
        }
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        new_patient = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        title_combo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();
        Surname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        add_2 = new javax.swing.JTextField();
        add_1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        town = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        postcode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        home = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        search_patient = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        search_results = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        search_firstname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        search_surname = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        search_dob = new javax.swing.JTextField();
        search_postcode = new javax.swing.JTextField();
        searchpatient_btn1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        view_patient = new javax.swing.JFrame();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        view_title = new javax.swing.JComboBox();
        view_firstname = new javax.swing.JTextField();
        view_surname = new javax.swing.JTextField();
        view_dob = new javax.swing.JTextField();
        view_email = new javax.swing.JTextField();
        view_add2 = new javax.swing.JTextField();
        view_add1 = new javax.swing.JTextField();
        view_home = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        view_mobile = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        view_town = new javax.swing.JTextField();
        view_postcode = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        edit_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        bookapp_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        patient_id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        new_btn = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel2.setText("Create New Patient");

        jLabel4.setText("Title:");

        title_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "Mr", "Mrs", "Miss", "Ms" }));

        jLabel5.setText("First Name:");

        jLabel6.setText("Surname:");

        FirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FirstNameKeyTyped(evt);
            }
        });

        Surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SurnameKeyTyped(evt);
            }
        });

        jLabel7.setText("Date of Birth:");

        jLabel8.setText("Address Line 1:");

        jLabel9.setText("Address Line 2:");

        jLabel10.setText("Town:");

        town.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                townKeyTyped(evt);
            }
        });

        jLabel11.setText("Postcode:");

        postcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                postcodeKeyTyped(evt);
            }
        });

        jLabel12.setText("Email:");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel13.setText("Mobile:");

        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileKeyTyped(evt);
            }
        });

        jLabel14.setText("Home:");

        home.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                homeKeyTyped(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout new_patientLayout = new javax.swing.GroupLayout(new_patient.getContentPane());
        new_patient.getContentPane().setLayout(new_patientLayout);
        new_patientLayout.setHorizontalGroup(
            new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(new_patientLayout.createSequentialGroup()
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(new_patientLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2))
                    .addGroup(new_patientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(new_patientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(new_patientLayout.createSequentialGroup()
                                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add_2)
                                    .addGroup(new_patientLayout.createSequentialGroup()
                                        .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(mobile, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(town, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(new_patientLayout.createSequentialGroup()
                                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(new_patientLayout.createSequentialGroup()
                                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(add_1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, new_patientLayout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        new_patientLayout.setVerticalGroup(
            new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(new_patientLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(title_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(add_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(add_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(town, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(new_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel3.setText("Search Patient");

        search_results.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title", "First Name", "Surname", "Date of Birth", "Address", "Postcode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        search_results.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_resultsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(search_results);

        jButton6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel27.setText("First Name:");

        search_firstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_firstnameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_firstnameKeyPressed(evt);
            }
        });

        jLabel28.setText("Surname:");

        search_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_surnameActionPerformed(evt);
            }
        });
        search_surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_surnameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_surnameKeyPressed(evt);
            }
        });

        jLabel29.setText("Postcode:");

        jLabel30.setText("DOB:");

        search_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_dobActionPerformed(evt);
            }
        });
        search_dob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_dobKeyPressed(evt);
            }
        });

        search_postcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_postcodeActionPerformed(evt);
            }
        });
        search_postcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_postcodeKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_postcodeKeyPressed(evt);
            }
        });

        searchpatient_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpatient_btn1ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton8.setText("Clear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout search_patientLayout = new javax.swing.GroupLayout(search_patient.getContentPane());
        search_patient.getContentPane().setLayout(search_patientLayout);
        search_patientLayout.setHorizontalGroup(
            search_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(search_patientLayout.createSequentialGroup()
                .addGroup(search_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(search_patientLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(search_patientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchpatient_btn1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_patientLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(275, 275, 275))
        );
        search_patientLayout.setVerticalGroup(
            search_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_patientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addGroup(search_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(search_patientLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(search_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(search_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(search_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(search_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(searchpatient_btn1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(search_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel15.setText("Patient Details");

        jLabel16.setText("Title:");

        jLabel17.setText("First Name:");

        jLabel18.setText("Surname:");

        jLabel19.setText("Date of Birth:");

        jLabel20.setText("Address Line 1:");

        jLabel21.setText("Address Line 2:");

        jLabel22.setText("Email:");

        view_title.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "Mr", "Mrs", "Miss", "Ms", " " }));

        jLabel23.setText("Home:");

        jLabel24.setText("Mobile:");

        jLabel25.setText("Postcode:");

        jLabel26.setText("Town:");

        edit_btn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        edit_btn.setText("Edit");
        edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btnActionPerformed(evt);
            }
        });

        delete_btn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        cancel_btn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        bookapp_btn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        bookapp_btn.setText("Book Appointment");
        bookapp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookapp_btnActionPerformed(evt);
            }
        });

        update_btn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        update_btn.setText("Save");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout view_patientLayout = new javax.swing.GroupLayout(view_patient.getContentPane());
        view_patient.getContentPane().setLayout(view_patientLayout);
        view_patientLayout.setHorizontalGroup(
            view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(view_patientLayout.createSequentialGroup()
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(view_patientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, view_patientLayout.createSequentialGroup()
                                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(view_add2)
                                    .addGroup(view_patientLayout.createSequentialGroup()
                                        .addComponent(view_town, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(view_postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, view_patientLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(view_patientLayout.createSequentialGroup()
                                        .addComponent(view_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(view_add1)))))
                    .addGroup(view_patientLayout.createSequentialGroup()
                        .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, view_patientLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(view_title, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(view_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(view_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(view_patientLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(125, 125, 125)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(view_email, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(view_patientLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(view_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(view_patientLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(view_home, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, view_patientLayout.createSequentialGroup()
                                        .addComponent(patient_id)
                                        .addGap(12, 12, 12)))))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(view_patientLayout.createSequentialGroup()
                        .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(edit_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bookapp_btn)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, view_patientLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(157, 157, 157))
        );
        view_patientLayout.setVerticalGroup(
            view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_patientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(view_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(view_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view_add1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(5, 5, 5)
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view_add2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patient_id)
                    .addGroup(view_patientLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(view_town, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addComponent(view_postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(view_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(view_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edit_btn)
                        .addComponent(delete_btn)
                        .addComponent(cancel_btn)
                        .addComponent(update_btn))
                    .addComponent(bookapp_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Patient");

        new_btn.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        new_btn.setText("New ");
        new_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_btnActionPerformed(evt);
            }
        });

        search_btn.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        logout_btn.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        logout_btn.setText("Back");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(new_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void new_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_btnActionPerformed
        // TODO add your handling code here:
         if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Add Patient?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new_patient.pack();
            new_patient.setVisible(true);} 
         else {
    // no option
    }
           
    }//GEN-LAST:event_new_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // TODO add your handling code here:
        search_patient.pack();
        search_patient.setVisible(true);
    }//GEN-LAST:event_search_btnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        validation();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FirstName.setText("");
        Surname.setText("");
        dob.setText("");
        email.setText("");
        add_1.setText("");
        add_2.setText("");
        town.setText("");
        postcode.setText("");
        mobile.setText("");
        home.setText(""); 

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new_patient.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
        main_menu1 s = new main_menu1();
            s.setVisible(true);
            dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        search_patient.setVisible(false);
        clear_search();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void search_resultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_resultsMouseClicked
        // TODO add your handling code here:
               try{
        int row = search_results.getSelectedRow();
        int results = search_results.getSelectedColumnCount();
        String table_click = (search_results.getModel().getValueAt(row, 1).toString());
        String table_click2 = (search_results.getModel().getValueAt(row, 2).toString());
        String table_click3 = (search_results.getModel().getValueAt(row, 3).toString());
       

        String sql="select * from Patients where FIRSTNAME='"+table_click+"' and SURNAME='"+table_click2+"' and DOB='"+table_click3+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
        
            String p_id=rs.getString("patient_id");
            patient_id.setText(p_id);
            String title=rs.getString("Title");
            view_title.addItem(title);
            add1=rs.getString("FIRSTNAME");
            view_firstname.setText(add1);
             add2=rs.getString("SURNAME");
            view_surname.setText(add2);
            String add3=rs.getString("DOB");
            view_dob.setText(add3);
            String add10=rs.getString("EMAIL_ADD");
            view_email.setText(add10);
            String add4=rs.getString("ADD_1");
            view_add1.setText(add4);
            String add5=rs.getString("ADD_2");
            view_add2.setText(add5);
            String add6=rs.getString("COUNTY");
            view_town.setText(add6);
            String add7=rs.getString("TEL");
            view_mobile.setText(add7);
            String add8=rs.getString("E_TEL");
            view_home.setText(add8);
            String add9=rs.getString("POSTCODE");
            view_postcode.setText(add9);

        search_patient.setVisible(false);
        view_patient.pack();
        view_patient.setVisible(true);
        view_patient();
        clear_search();
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        finally {
        try{
        rs.close(); pst.close(); }
        catch(Exception e) { } }

    }//GEN-LAST:event_search_resultsMouseClicked

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btnActionPerformed
        // TODO add your handling code here:
                view_title.setEnabled(true);
            view_firstname.setEditable(true);
            view_surname.setEditable(true);
            view_dob.setEditable(true);
            view_email.setEditable(true);
            view_add1.setEditable(true);
            view_add2.setEditable(true);
            view_town.setEditable(true);
            view_mobile.setEditable(true);
            view_home.setEditable(true);
            view_postcode.setEditable(true);
            cancel_btn.setVisible(true);
            delete_btn.setVisible(true);
            edit_btn.setVisible(false);
                        update_btn.setVisible(true);



    }//GEN-LAST:event_edit_btnActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        // TODO add your handling code here:
        view_patient();
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void bookapp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookapp_btnActionPerformed
          Tablex appt = new Tablex(add1+" "+add2);

    }//GEN-LAST:event_bookapp_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
               if (JOptionPane.showConfirmDialog(null, "Are you sure you want to update patient details?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    // yes option
           //String title =(String)title_combo.getSelectedItem();
          //String driver =(String)driver_combo.getSelectedItem();
            // pst.setString(1, title);
        try{
            String title =(String)view_title.getSelectedItem();
            String p_id = patient_id.getText();
            String firstname = view_firstname.getText();
            String surname = view_surname.getText();
            String dob1 = view_dob.getText();
            String add1 = view_add1.getText();
            String add2 = view_add2.getText();
            String town1 = view_town.getText();
            String postcode1 = view_postcode.getText();
            String home1 = view_home.getText();
            String mobile1 = view_mobile.getText();
            String email1 = view_email.getText();

            String sql="update Patients set Title='"+title+"',FIRSTNAME='"+firstname+"',SURNAME='"+surname+"',DOB='"+dob1+"',EMAIL_ADD='"+email1+"',ADD_1='"+add1+"',ADD_2='"+add2+"' ,COUNTY='"+town1+"',TEL='"+mobile1+"',E_TEL='"+home1+"', POSTCODE='"+postcode1+"' where patient_id='"+p_id+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Patient Details Updated"); 
            view_patient();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        finally {
        try{
        rs.close(); pst.close(); }
        catch(Exception e) { } }
        } else {
    // no option
        } 
    }//GEN-LAST:event_update_btnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        view_patient.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
               if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete Patient?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        String sql="delete from Patients where patient_id =?";
        try{
        pst=conn.prepareStatement(sql);
        pst.setString(1,patient_id.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Patient Deleted");
        view_patient.setVisible(false);
        
        
        
        }catch(Exception e ){
            
            
             JOptionPane.showMessageDialog(null, e);
        }
        finally {
        try{
        rs.close(); pst.close(); }
        catch(Exception e) { } }
          } else {
    // no option
    }
       
    }//GEN-LAST:event_delete_btnActionPerformed

    private void mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        getToolkit().beep();
        evt.consume();
        } 
    }//GEN-LAST:event_mobileKeyTyped

    private void homeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homeKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        getToolkit().beep();
        evt.consume();
        } 
    }//GEN-LAST:event_homeKeyTyped

    private void FirstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstNameKeyTyped
        // TODO add your handling code here:
               char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        evt.consume();
        } 
    }//GEN-LAST:event_FirstNameKeyTyped

    private void SurnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SurnameKeyTyped
        // TODO add your handling code here:
               char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        evt.consume();
        } 
    }//GEN-LAST:event_SurnameKeyTyped

    private void postcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_postcodeKeyTyped
        // TODO add your handling code here:
                char c=evt.getKeyChar();
        if(!(Character.isLetterOrDigit(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        evt.consume();
        } 
    }//GEN-LAST:event_postcodeKeyTyped

    private void townKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_townKeyTyped
        // TODO add your handling code here:
                char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        getToolkit().beep();
        evt.consume();
        } 
    }//GEN-LAST:event_townKeyTyped

    private void search_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_surnameActionPerformed

    private void search_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_dobActionPerformed

    private void search_postcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_postcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_postcodeActionPerformed

    private void searchpatient_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpatient_btn1ActionPerformed
        // TODO add your handling code here:
        search_final();
    }//GEN-LAST:event_searchpatient_btn1ActionPerformed

    private void search_firstnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_firstnameKeyPressed
        // TODO add your handling code here:
                    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    search_final();
               }
    }//GEN-LAST:event_search_firstnameKeyPressed

    private void search_surnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_surnameKeyPressed
        // TODO add your handling code here:
                    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    search_final();
               }
    }//GEN-LAST:event_search_surnameKeyPressed

    private void search_dobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_dobKeyPressed
        // TODO add your handling code here:
                    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    search_final();
               }
    }//GEN-LAST:event_search_dobKeyPressed

    private void search_postcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_postcodeKeyPressed
        // TODO add your handling code here:
                    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    search_final();
               }
    }//GEN-LAST:event_search_postcodeKeyPressed

    private void search_firstnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_firstnameKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        evt.consume();
        }
    }//GEN-LAST:event_search_firstnameKeyTyped

    private void search_surnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_surnameKeyTyped
        // TODO add your handling code here:
                char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        evt.consume();
    }   
    }//GEN-LAST:event_search_surnameKeyTyped

    private void search_postcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_postcodeKeyTyped
        // TODO add your handling code here:
                        char c=evt.getKeyChar();
        if(!(Character.isLetterOrDigit(c) || c==KeyEvent.VK_BACK_SPACE
        || c==KeyEvent.VK_DELETE)) {
        evt.consume();
        } 

    }//GEN-LAST:event_search_postcodeKeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        clear_search();
    }//GEN-LAST:event_jButton8ActionPerformed
    
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
            java.util.logging.Logger.getLogger(patient_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField Surname;
    private javax.swing.JTextField add_1;
    private javax.swing.JTextField add_2;
    private javax.swing.JButton bookapp_btn;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField dob;
    private javax.swing.JButton edit_btn;
    private javax.swing.JTextField email;
    private javax.swing.JTextField home;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTextField mobile;
    private javax.swing.JButton new_btn;
    private javax.swing.JFrame new_patient;
    private javax.swing.JLabel patient_id;
    private javax.swing.JTextField postcode;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_dob;
    private javax.swing.JTextField search_firstname;
    private javax.swing.JFrame search_patient;
    private javax.swing.JTextField search_postcode;
    private javax.swing.JTable search_results;
    private javax.swing.JTextField search_surname;
    private javax.swing.JButton searchpatient_btn1;
    private javax.swing.JComboBox title_combo;
    private javax.swing.JTextField town;
    private javax.swing.JButton update_btn;
    private javax.swing.JTextField view_add1;
    private javax.swing.JTextField view_add2;
    private javax.swing.JTextField view_dob;
    private javax.swing.JTextField view_email;
    private javax.swing.JTextField view_firstname;
    private javax.swing.JTextField view_home;
    private javax.swing.JTextField view_mobile;
    private javax.swing.JFrame view_patient;
    private javax.swing.JTextField view_postcode;
    private javax.swing.JTextField view_surname;
    private javax.swing.JComboBox view_title;
    private javax.swing.JTextField view_town;
    // End of variables declaration//GEN-END:variables
}
