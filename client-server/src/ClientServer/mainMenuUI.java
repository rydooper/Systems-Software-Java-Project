/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.IOException;

/**
 *
 * @author nivee
 */
public class mainMenuUI extends javax.swing.JFrame {

    /**
     * Creates new form mainMenuUI
     */
	//String to be accessed by the UserClient. Used to indicate when data needs to be sent from the Client to the Sever
	static String dataRequest = "";
	static boolean buttonPressed = false;
    public mainMenuUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionsPanel = new javax.swing.JPanel();
        allUsrStationInfoBtn = new javax.swing.JButton();
        fieldInfoBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        menuLabel = new javax.swing.JLabel();
        LogOutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        allUsrStationInfoBtn.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 11)); // NOI18N
        allUsrStationInfoBtn.setText("View All User and Station Info");
        allUsrStationInfoBtn.setMaximumSize(new java.awt.Dimension(200, 23));
        allUsrStationInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allUsrStationInfoBtnActionPerformed(evt);
            }
        });

        fieldInfoBtn.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 11)); // NOI18N
        fieldInfoBtn.setText("View Field Information");
        fieldInfoBtn.setMaximumSize(new java.awt.Dimension(175, 23));
        fieldInfoBtn.setMinimumSize(new java.awt.Dimension(175, 23));
        fieldInfoBtn.setPreferredSize(new java.awt.Dimension(175, 23));
        fieldInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldInfoBtnActionPerformed(evt);
            }
        });

        jButton1.setText("View weather station(s)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, optionsPanelLayout.createSequentialGroup()
                        .addContainerGap(82, Short.MAX_VALUE)
                        .addComponent(fieldInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(allUsrStationInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(96, 96, 96)
                .addComponent(allUsrStationInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        menuLabel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        menuLabel.setText("Main Menu");

        LogOutBtn.setBackground(new java.awt.Color(255, 0, 0));
        LogOutBtn.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 11)); // NOI18N
        LogOutBtn.setForeground(new java.awt.Color(240, 240, 240));
        LogOutBtn.setText("Log Out");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOutBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOutBtn)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldInfoBtnActionPerformed
        this.dispose();
		dataRequest = "FIELD DATA";
		buttonPressed = true;
        FieldDataUI fieldScreen = new FieldDataUI();
        fieldScreen.setVisible(true);
		try{
		Thread.sleep(400);
		fieldScreen.fetchFieldData();
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}

		dataRequest = "";
    }//GEN-LAST:event_fieldInfoBtnActionPerformed

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        this.dispose();
        ClientLoginUI loginScreen = new ClientLoginUI();
        loginScreen.setVisible(true);
        //the frame is cleared form memory and a new instance of login screen 
        //is shown
    }//GEN-LAST:event_LogOutBtnActionPerformed

    private void allUsrStationInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allUsrStationInfoBtnActionPerformed
        this.dispose();
        AllDataUI allDataScreen = new AllDataUI();
        allDataScreen.setVisible(true);
    }//GEN-LAST:event_allUsrStationInfoBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		this.dispose();
		dataRequest = "WEATHER STATION";
		buttonPressed = true;
		StationDataDisplayUI stationScreen = new StationDataDisplayUI();
		stationScreen.fetchNumStations();
        stationScreen.setVisible(true);
		try{
			Thread.sleep(400);
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		dataRequest = "";
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(mainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenuUI().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton allUsrStationInfoBtn;
    private javax.swing.JButton fieldInfoBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JPanel optionsPanel;
    // End of variables declaration//GEN-END:variables
}
