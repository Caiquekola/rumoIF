/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rumoif.view;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import rumoif.model.bean.Aluno;
import rumoif.model.bean.Faltas;
import rumoif.model.bean.Materia;
import rumoif.model.bean.Notas;
import rumoif.model.dao.AlunoDAO;
import rumoif.model.dao.AlunoMateriaDAO;
import rumoif.model.dao.FaltasDAO;
import rumoif.model.dao.MateriaDAO;
import rumoif.model.dao.NotasDAO;

/**
 *
 * @author ADMIN
 */
public class AlunoMateria extends javax.swing.JFrame {

    /**
     * Creates new form Aluno
     */
    static Aluno aluno = null;
    
    public AlunoMateria(Aluno a) {
        initComponents();
        this.aluno = a;
       
        jNome.setText(aluno.getNome());
        
         DefaultTableModel modelo = (DefaultTableModel) jtTabela.getModel();
        jtTabela.setRowSorter(new TableRowSorter(modelo));

        readJTable();
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtTabela.getModel();
        modelo.setNumRows(0);

        NotasDAO mDao = new NotasDAO();
        FaltasDAO pDao = new FaltasDAO();
        AlunoDAO aDao = new AlunoDAO();
        AlunoMateriaDAO amDao = new AlunoMateriaDAO();
        MateriaDAO maDao = new MateriaDAO();
        
        List<Notas> notas = mDao.read(aluno);
        List<Faltas> faltas = pDao.read(aluno);
        List<Materia> materias = maDao.read(aluno);
        
        int minSize = Math.min(notas.size(),materias.size());

        for (int i = 0; i < minSize; i++) {
            Object[] rowData = new Object[3];
            //ID ALUNO ATIVIDADE NOTA FALTA

            if (i < notas.size()) {
                Notas nota = notas.get(i);
                Faltas falta = faltas.get(i);
                Materia materia = materias.get(i);
                rowData[0] = materia.getNome_materia();
                rowData[1] = notas.get(i).getNota();
                rowData[2] = faltas.get(i).getQuantidade();
            }


            modelo.addRow(rowData); // Adiciona a linha ao modelo da tabela
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

        jMateria = new javax.swing.JLabel();
        jNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        Imagem = new javax.swing.JLabel();
        jvoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMateria.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 36)); // NOI18N
        jMateria.setForeground(new java.awt.Color(255, 255, 255));
        jMateria.setText("Todas as matérias");
        getContentPane().add(jMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, 40));

        jNome.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 36)); // NOI18N
        jNome.setForeground(new java.awt.Color(255, 255, 255));
        jNome.setText("Caique Augusto");
        getContentPane().add(jNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, 40));

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matéria", "Nota", "Falta"
            }
        ));
        jScrollPane1.setViewportView(jtTabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 300, 720, -1));

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumoif/resources/Aluno.png"))); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jvoltar.setText("voltar");
        jvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jvoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jvoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 700, 130, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jvoltarActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jvoltarActionPerformed

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
            java.util.logging.Logger.getLogger(AlunoMateria.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlunoMateria.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlunoMateria.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunoMateria.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlunoMateria(aluno).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagem;
    private javax.swing.JLabel jMateria;
    private javax.swing.JLabel jNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabela;
    private javax.swing.JButton jvoltar;
    // End of variables declaration//GEN-END:variables
}
