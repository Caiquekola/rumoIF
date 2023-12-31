/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rumoif.view;



/**
 *
 * @author ADMIN
 */
public class DiretorProfessorMateria extends javax.swing.JFrame {

    /**
     * Creates new form DiretorProfessorMateria
     */
    public DiretorProfessorMateria() {
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

        jbAdicionar = new javax.swing.JButton();
        jbEditar1 = new javax.swing.JButton();
        Imagem = new javax.swing.JLabel();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAdicionar.setBackground(new java.awt.Color(55, 0, 153));
        jbAdicionar.setFont(new java.awt.Font("League Spartan", 1, 36)); // NOI18N
        jbAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        jbAdicionar.setText("Adicionar ou Remover");
        jbAdicionar.setToolTipText("");
        jbAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(jbAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 380, 60));

        jbEditar1.setBackground(new java.awt.Color(55, 0, 153));
        jbEditar1.setFont(new java.awt.Font("League Spartan", 1, 36)); // NOI18N
        jbEditar1.setForeground(new java.awt.Color(255, 255, 255));
        jbEditar1.setText("Matéria p/ Professor");
        jbEditar1.setToolTipText("");
        jbEditar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 380, 60));

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumoif/resources/DiretorProfessorMateria.png"))); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jbVoltar.setText("jButton1");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jbVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 150, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
   
   
    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DiretorProfessor d = new DiretorProfessor();
        d.setVisible(true);
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DiretorProfessorMateriaAdicionar d = new DiretorProfessorMateriaAdicionar();
        d.setVisible(true);
    }//GEN-LAST:event_jbAdicionarActionPerformed

    private void jbEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditar1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DiretorProfessorMateriaProfessor d = new DiretorProfessorMateriaProfessor();
        d.setVisible(true);
    }//GEN-LAST:event_jbEditar1ActionPerformed

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
            java.util.logging.Logger.getLogger(DiretorProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiretorProfessorMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton jbAdicionar;
    private javax.swing.JButton jbEditar1;
    private javax.swing.JButton jbVoltar;
    // End of variables declaration//GEN-END:variables
}
