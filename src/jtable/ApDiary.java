
package jtable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JEANNE
 */
public class ApDiary extends javax.swing.JFrame {
ImageIcon frameimg;
  
    public ApDiary() {
        initComponents();
         frameimg = new ImageIcon("logo.jpg");
          ApDiaryTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
        
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
          
        ApDiaryTable.getTableHeader().setPreferredSize(new Dimension(32, 32));

    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ApDiaryContentPanel = new javax.swing.JPanel();
        ApDiaryTablePanel = new javax.swing.JPanel();
        ApDiaryScrollPane = new javax.swing.JScrollPane();
        ApDiaryTable = new javax.swing.JTable();
        ApDiaryTitlePanel = new javax.swing.JPanel();
        ApTitleLabel = new javax.swing.JLabel();
        ApDiaryButtonPanel = new javax.swing.JPanel();
        ApDiaryBackButton = new javax.swing.JButton();
        ApDiaryExitButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Telugu Sangam MN", 0, 13)); // NOI18N

        ApDiaryContentPanel.setBackground(new java.awt.Color(204, 204, 204));
        ApDiaryContentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        ApDiaryTablePanel.setBackground(java.awt.SystemColor.textHighlight);
        ApDiaryTablePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.SystemColor.textHighlight, java.awt.SystemColor.textHighlight, null, null));

        ApDiaryScrollPane.setBackground(new java.awt.Color(238, 238, 238));

        ApDiaryTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ApDiaryTable.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        ApDiaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Time", "Patient Name", "GP Name", "Attendance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ApDiaryTable.setGridColor(new java.awt.Color(0, 0, 0));
        ApDiaryTable.setRowHeight(20);
        ApDiaryTable.setSelectionBackground(new java.awt.Color(255, 255, 204));
        ApDiaryTable.setShowGrid(true);
        ApDiaryScrollPane.setViewportView(ApDiaryTable);

        ApDiaryTitlePanel.setBackground(java.awt.SystemColor.textHighlight);

        ApTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        ApTitleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        ApTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        ApTitleLabel.setText("Appointment Diary");

        javax.swing.GroupLayout ApDiaryTitlePanelLayout = new javax.swing.GroupLayout(ApDiaryTitlePanel);
        ApDiaryTitlePanel.setLayout(ApDiaryTitlePanelLayout);
        ApDiaryTitlePanelLayout.setHorizontalGroup(
            ApDiaryTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApDiaryTitlePanelLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(ApTitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ApDiaryTitlePanelLayout.setVerticalGroup(
            ApDiaryTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ApTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ApDiaryTablePanelLayout = new javax.swing.GroupLayout(ApDiaryTablePanel);
        ApDiaryTablePanel.setLayout(ApDiaryTablePanelLayout);
        ApDiaryTablePanelLayout.setHorizontalGroup(
            ApDiaryTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApDiaryTablePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ApDiaryTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ApDiaryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(ApDiaryTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        ApDiaryTablePanelLayout.setVerticalGroup(
            ApDiaryTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ApDiaryTablePanelLayout.createSequentialGroup()
                .addComponent(ApDiaryTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ApDiaryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ApDiaryButtonPanel.setBackground(java.awt.SystemColor.textHighlight);
        ApDiaryButtonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.SystemColor.textHighlight, java.awt.SystemColor.textHighlight, null, null));
        ApDiaryButtonPanel.setPreferredSize(new java.awt.Dimension(200, 53));

        ApDiaryBackButton.setBackground(java.awt.SystemColor.textHighlight);
        ApDiaryBackButton.setForeground(new java.awt.Color(255, 255, 255));
        ApDiaryBackButton.setText("Back");
        ApDiaryBackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.SystemColor.textHighlight, java.awt.SystemColor.textHighlight, null, null));
        ApDiaryBackButton.setPreferredSize(new java.awt.Dimension(75, 30));
        ApDiaryBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApDiaryBackButtonActionPerformed(evt);
            }
        });

        ApDiaryExitButton.setBackground(java.awt.SystemColor.textHighlight);
        ApDiaryExitButton.setForeground(new java.awt.Color(255, 255, 255));
        ApDiaryExitButton.setText("Exit");
        ApDiaryExitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.SystemColor.textHighlight, java.awt.SystemColor.textHighlight, null, null));
        ApDiaryExitButton.setPreferredSize(new java.awt.Dimension(75, 30));

        javax.swing.GroupLayout ApDiaryButtonPanelLayout = new javax.swing.GroupLayout(ApDiaryButtonPanel);
        ApDiaryButtonPanel.setLayout(ApDiaryButtonPanelLayout);
        ApDiaryButtonPanelLayout.setHorizontalGroup(
            ApDiaryButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApDiaryButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ApDiaryBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ApDiaryExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        ApDiaryButtonPanelLayout.setVerticalGroup(
            ApDiaryButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApDiaryButtonPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ApDiaryButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApDiaryBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApDiaryExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout ApDiaryContentPanelLayout = new javax.swing.GroupLayout(ApDiaryContentPanel);
        ApDiaryContentPanel.setLayout(ApDiaryContentPanelLayout);
        ApDiaryContentPanelLayout.setHorizontalGroup(
            ApDiaryContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApDiaryContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ApDiaryContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ApDiaryTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ApDiaryButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ApDiaryContentPanelLayout.setVerticalGroup(
            ApDiaryContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ApDiaryContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ApDiaryTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ApDiaryButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ApDiaryContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ApDiaryContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        ApDiaryContentPanel.getAccessibleContext().setAccessibleName("Doctor's Diary");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApDiaryBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApDiaryBackButtonActionPerformed
    //   DefaultTableModel table = (DefaultTableModel)ApDiaryTable.getModel();
   
     Object[]data = {"a","b","c","d"};
        for (int i = 0; i < data.length; i++) {

     ApDiaryTable.getModel().setValueAt(data[i], 0,i);
 
            }
        
             ApDiaryTable.revalidate();
       ApDiaryTable.repaint();
    }//GEN-LAST:event_ApDiaryBackButtonActionPerformed

    
    public void runframe() {
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
            java.util.logging.Logger.getLogger(ApDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new ApDiary().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApDiaryBackButton;
    private javax.swing.JPanel ApDiaryButtonPanel;
    private javax.swing.JPanel ApDiaryContentPanel;
    private javax.swing.JButton ApDiaryExitButton;
    private javax.swing.JScrollPane ApDiaryScrollPane;
    private javax.swing.JTable ApDiaryTable;
    private javax.swing.JPanel ApDiaryTablePanel;
    private javax.swing.JPanel ApDiaryTitlePanel;
    private javax.swing.JLabel ApTitleLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
