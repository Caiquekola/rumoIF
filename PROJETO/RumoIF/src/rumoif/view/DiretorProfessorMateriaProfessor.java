/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rumoif.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rumoif.model.bean.Materia;
import rumoif.model.dao.MateriaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import rumoif.connection.ConnectionFactory;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import rumoif.model.bean.Professor;
import rumoif.model.dao.ProfessorDAO;

/**
 *
 * @author ADMIN
 */
public class DiretorProfessorMateriaProfessor extends javax.swing.JFrame {

    /**
     * Creates new form DiretorProfessorMateria
     */
    public DiretorProfessorMateriaProfessor() {
        initComponents();
        jtProfessor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    adicionar(obterMateria(), obterProfessor());

                }
            }
        });

        jtMateria.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    adicionar(obterMateria(), obterProfessor());

                }
            }
        });
        DefaultTableModel modelo = (DefaultTableModel) jtTabela.getModel();
        jtTabela.setRowSorter(new TableRowSorter(modelo));

        readJTable();
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtTabela.getModel();
        modelo.setNumRows(0);

        MateriaDAO mDao = new MateriaDAO();
        ProfessorDAO pDao = new ProfessorDAO();

        List<Materia> materias = mDao.read();
        List<Professor> professores = pDao.read();

        int maxSize = Math.max(materias.size(), professores.size());

        for (int i = 0; i < maxSize; i++) {
            Object[] rowData = new Object[3]; // Array para armazenar dados de uma linha

            // Adiciona dados da matéria se existir na posição 'i' da lista de matérias
            if (i < materias.size()) {
                Materia materia = materias.get(i);
                rowData[0] = materia.getNome_materia();
            }

            // Adiciona dados do professor se existir na posição 'i' da lista de professores
            if (i < professores.size()) {
                Professor professor = professores.get(i);
                rowData[1] = professor.getUsuario();
            }
            if (i < professores.size()) {
                Professor professor = professores.get(i);
                rowData[2] = professor.getNome();
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

        jtMateria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jtProfessor = new javax.swing.JTextField();
        Adicionar = new javax.swing.JButton();
        Nome1 = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        Imagem = new javax.swing.JLabel();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtMateria.setBackground(new java.awt.Color(0, 0, 0));
        jtMateria.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtMateria.setForeground(new java.awt.Color(255, 255, 255));
        jtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMateriaActionPerformed(evt);
            }
        });
        getContentPane().add(jtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 200, 40));

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matéria", "Professor", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTabelaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 380, 120));

        jtProfessor.setBackground(new java.awt.Color(0, 0, 0));
        jtProfessor.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtProfessor.setForeground(new java.awt.Color(255, 255, 255));
        jtProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtProfessorActionPerformed(evt);
            }
        });
        getContentPane().add(jtProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 200, 40));

        Adicionar.setBackground(new java.awt.Color(55, 0, 153));
        Adicionar.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 14)); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(Adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, 30));

        Nome1.setFont(new java.awt.Font("League Spartan Black", 0, 36)); // NOI18N
        Nome1.setForeground(new java.awt.Color(255, 255, 255));
        Nome1.setText("Matéria");
        getContentPane().add(Nome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        Nome.setFont(new java.awt.Font("League Spartan Black", 0, 28)); // NOI18N
        Nome.setForeground(new java.awt.Color(255, 255, 255));
        Nome.setText("Professor (R.A)");
        getContentPane().add(Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 200, -1));

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

    private boolean materiaProfessorExiste(Materia m, String p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
        boolean existe2 = false;
        
        String sql = ("SELECT * FROM rumoif.materia WHERE nome_materia = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome_materia());

            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiretorProfessorMateriaProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = ("SELECT * FROM rumoif.login WHERE usuario = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p);

            rs = stmt.executeQuery();
            if (rs.next()) {
                existe2 = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiretorProfessorMateriaProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return existe2 & existe;
    }

    private Materia obterMateria() {
        MateriaDAO mDao = new MateriaDAO();
        Materia m = mDao.read(jtMateria.getText());
        return m;
    }

    private String obterProfessor() {
        String professorRa = jtProfessor.getText();
        return professorRa;
    }

    private boolean adicionarRelacao(Materia m, String p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("INSERT INTO rumoif.professor_materia (id_professor,id_materia) VALUES (?,?)");
        boolean certo = false;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p);
            stmt.setInt(2, m.getId_materia());
            stmt.executeUpdate();
            certo = true;
        } catch (SQLException ex) {
            Logger.getLogger(DiretorProfessorMateriaProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return certo;
    }

    private void adicionar(Materia m, String p) {
        if (jtMateria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Matéria!");
        } else if (jtProfessor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Professor!");

        } else if (materiaProfessorExiste(obterMateria(), obterProfessor())) {
                adicionarRelacao(obterMateria(),p);
                JOptionPane.showMessageDialog(this, "Relação criada com êxito!");

            
        }
        readJTable();

    }
    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DiretorProfessorMateria d = new DiretorProfessorMateria();
        d.setVisible(true);
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        // TODO add your handling code here:
        adicionar(obterMateria(), obterProfessor());
    }//GEN-LAST:event_AdicionarActionPerformed

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jtTabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMousePressed
        // TODO add your handling code here

    }//GEN-LAST:event_jtTabelaMousePressed

    private void jtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMateriaActionPerformed

    private void jtProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtProfessorActionPerformed

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
            java.util.logging.Logger.getLogger(DiretorProfessorMateriaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorMateriaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorMateriaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorMateriaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiretorProfessorMateriaProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JLabel Imagem;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Nome1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTextField jtMateria;
    private javax.swing.JTextField jtProfessor;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables
}
