/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import TabelData.DataGame;
import TabelData.TabelData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Yoffa
 */
public class MainForm extends javax.swing.JFrame {

    private String mf_idgame;
    private String mf_judulgame;
    private String mf_genre;
    private String mf_rilis;
    private String mf_developer;
    private String mf_kodeplatform;
    private String mf_platform;
    private String output;
    private TabelData tabeldata;
    private dbconnections c;
    private Statement script;
    
    private void Tampil(){
        try {
            int row = tabel.getRowCount();
            for(int i=0;i<row;i++){
                tabeldata.delete(0, row);
            }
            String sql="SELECT * from DB_GAME";
            ResultSet rsShow = c.script.executeQuery(sql);
            while(rsShow.next()){
                DataGame d = new DataGame();
                d.setIdgame(rsShow.getString("IDGAME"));
                d.setJudulgame(rsShow.getString("JUDULGAME"));
                d.setGenre(rsShow.getString("GENRE"));
                d.setRilis(rsShow.getString("RILIS"));
                d.setDeveloper(rsShow.getString("DEVELOPER"));
                d.setPlatform(rsShow.getString("PLATFORM"));
                d.setKodeplatform(rsShow.getString("KODEPLATFORM"));
                tabeldata.add(d);
            }
        }catch(Exception e){
            System.err.print(e);
        }
    } 
    public String showData(DataGame dm){
        idgame.setText(dm.getIdgame());
        judulgame.setText(dm.getJudulgame());
        genre.setText(dm.getGenre());
        rilis.setText (dm.getRilis());
        developer.setText (dm.getDeveloper());
        kodeplatform.setText (dm.getKodeplatform());
        insert.setEnabled(false);
        return dm.getIdgame();
    }
    private void insertData(){
        mf_judulgame = judulgame.getText();
        mf_genre = genre.getText();
        mf_rilis = rilis.getText();
        mf_developer = developer.getText();
        mf_kodeplatform = kodeplatform.getText();
        if(judulgame!=null&&genre!=null&&rilis!=null){
            try{
                String sql = "INSERT INTO GAME (idgame, judulgame, genre, rilis, developer, kodeplatform) values (SEQ_MODUL6.nextval+1,'" +mf_judulgame+ "','"+mf_genre+"','"+mf_rilis+"','" +mf_developer+ "',"+mf_kodeplatform+")";
                c.script.executeUpdate(sql);
            }catch(SQLException e){
                System.err.print(e);
            }
            Tampil();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
            clearForm();
        }else{
            JOptionPane.showMessageDialog(null,"Setiap kolom harus diisi!");
        }
    }
    private void deleteData(){
    int app;
    mf_idgame = idgame.getText();
    if ((app=JOptionPane.showConfirmDialog(null,"Yakin ingin hapus data?","Hapus Data", JOptionPane.YES_NO_OPTION))==0){
    try {
        String sqlid = "SELECT IDGAME from GAME where idgame="+mf_idgame+"";
        ResultSet rsShow = c.script.executeQuery(sqlid);
        while (rsShow.next()){
	output = rsShow.getString(1);
}
        String sql = "DELETE from GAME where idgame ="+mf_idgame+"";
        c.script.executeUpdate(sql);
        Tampil();
        JOptionPane.showMessageDialog (null,"Berhasil dihapus");
        clearForm();
        tampil1();
    }
    catch (SQLException e){
        System.err.print(e);
            }
        }
    }
    private void updateData(String mf_idgame){
        int app;
                       
        if((app = JOptionPane.showConfirmDialog(null, "Yakin ingin update date?","Ubah Data",JOptionPane.YES_NO_OPTION))==0){
        	try{ //Query untuk update pada table database
                    mf_idgame = idgame.getText();
                    mf_judulgame = judulgame.getText();
                    mf_genre = genre.getText();
                    mf_rilis = rilis.getText();
                    mf_developer = developer.getText();
                    mf_kodeplatform = kodeplatform.getText();	
                             
                    String sqlid = "SELECT IDGAME from GAME where idgame=" +mf_idgame+ "";
                    ResultSet rsShow = c.script.executeQuery(sqlid);
                    while (rsShow.next()){
                    output = rsShow.getString(1);
                    } 
                        String sql = "UPDATE GAME SET judulgame='"+mf_judulgame+"',genre='"+mf_genre+"',rilis='"+mf_rilis+"',developer='"+mf_developer+"',kodeplatform="+mf_kodeplatform+" where idgame="+mf_idgame+"" ;
       			c.script.executeUpdate(sql);
        		Tampil();
                        tampil1();
		//menampilkan message dialog bahwa data telah update
        	JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
        		clearForm();
        	}
        	catch(SQLException ex){
        	System.err.print(ex);
        }
    }}
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        c = new dbconnections();
        tabeldata = new TabelData();
        tabel.setModel(tabeldata);
        Tampil();

    }
    public void clearForm(){
        judulgame.setText(null);
        genre.setText(null);
        rilis.setText(null);
        developer.setText (null);
        kodeplatform.setText (null);
        idgame.setText(null);
        
    }
    public void tampil1(){
    	insert.setEnabled(true);
    	delete.setEnabled(true);
    	update.setEnabled(true);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        judulgame = new javax.swing.JTextField();
        genre = new javax.swing.JTextField();
        rilis = new javax.swing.JTextField();
        developer = new javax.swing.JTextField();
        kodeplatform = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        idgame = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jLabel1.setText("Judul Game");

        jLabel2.setText("Genre");

        jLabel3.setText("Tanggal Rilis");

        jLabel4.setText("Pengembang");

        jLabel5.setText("Kode Platform");

        judulgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulgameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(84, 84, 84)
                        .addComponent(kodeplatform))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(90, 90, 90)
                        .addComponent(developer, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(98, 98, 98)
                        .addComponent(judulgame, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(131, 131, 131)
                        .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(93, 93, 93)
                        .addComponent(rilis, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(judulgame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rilis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(developer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kodeplatform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        idgame.setText("ID:       0");

        insert.setText("INSERT");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(update)
                            .addComponent(insert)
                            .addComponent(delete))
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(idgame)
                        .addGap(190, 190, 190))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(idgame)
                .addGap(32, 32, 32)
                .addComponent(insert)
                .addGap(51, 51, 51)
                .addComponent(update)
                .addGap(52, 52, 52)
                .addComponent(delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void judulgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulgameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulgameActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        insertData();
    }//GEN-LAST:event_insertActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        mf_idgame = idgame.getText();
        updateData(mf_idgame);
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_deleteActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
         showData(this.tabeldata.get(tabel.getSelectedRow()));
         insert.setEnabled(false);
         delete.setEnabled(true);
         update.setEnabled(true);
    }
    }//GEN-LAST:event_tabelMouseClicked

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JTextField developer;
    private javax.swing.JTextField genre;
    private javax.swing.JLabel idgame;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judulgame;
    private javax.swing.JTextField kodeplatform;
    private javax.swing.JTextField rilis;
    private javax.swing.JTable tabel;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
