/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rumoif.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Aluno;
import rumoif.model.bean.AlunoMateria;
import rumoif.model.bean.Faltas;
import rumoif.model.bean.Materia;
import rumoif.model.bean.Notas;
import rumoif.model.bean.Professor;
import rumoif.model.dao.AlunoDAO;
import rumoif.model.dao.AlunoMateriaDAO;
import rumoif.model.dao.FaltasDAO;
import rumoif.model.dao.MateriaDAO;
import rumoif.model.dao.NotasDAO;
import rumoif.model.dao.ProfessorDAO;

/**
 *
 * @author ADMIN
 */
public class ProfessorMateria extends javax.swing.JFrame {

    /**
     * Creates new form ProfessorMateria
     */
    static Materia materia;
    static Professor professor;

    public ProfessorMateria(Materia materia, Professor p) {
        initComponents();
        this.materia = materia;
        this.professor = p;
        this.jNomeProfessor.setText(p.getNome());
        this.jlNomeMateria.setText(materia.getNome_materia());

        jtNota.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                }
            }
        });
        jtAluno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

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

        NotasDAO mDao = new NotasDAO();
        FaltasDAO pDao = new FaltasDAO();
        AlunoDAO aDao = new AlunoDAO();
        AlunoMateriaDAO amDao = new AlunoMateriaDAO();

        List<AlunoMateria> alunoMateria = amDao.read(materia);
        List<Aluno> alunos = aDao.read(materia);
        List<Notas> notas = mDao.read(materia);
        List<Faltas> faltas = pDao.read(materia);

        int maxSize = alunos.size();

        for (int i = 0; i < maxSize; i++) {
            Object[] rowData = new Object[5];
            //ID ALUNO ATIVIDADE NOTA FALTA
           
            if (i < alunos.size()) {
                Aluno aluno = alunos.get(i);
                rowData[0] = aluno.getUsuario();
                rowData[1] = aluno.getNome();
            }
            

            if (i < notas.size()) {
                Notas nota = notas.get(i);
                rowData[2] = String.valueOf(nota.getNota());
            }

            if (i < faltas.size()) {
                Faltas falta = faltas.get(i);
                rowData[3] = String.valueOf(falta.getQuantidade());
            }

            modelo.addRow(rowData); // Adiciona a linha ao modelo da tabela
        }

    }

   

    private boolean AlunoExiste(String p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
        String sql = ("SELECT * FROM rumoif.login WHERE usuario = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p);

            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiretorAlunoMateria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return existe;
    }

    private String obterAluno() {
        String professorRa = jtAluno.getText();
        return professorRa;
    }

    private double obterNota() {
        double nota = Double.parseDouble(jtNota.getText());
        return nota;
    }

    private void adicionarNota() {
        if (jtAluno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Aluno!");
        } else if (jtNota.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nota!");

        } else if (AlunoExiste(jtAluno.getText())) {
            NotasDAO notasDao = new NotasDAO();
            if (notasDao.acrescentarNota(obterAluno(), obterNota(), materia)) {
                JOptionPane.showMessageDialog(null, "Aluno inserido na matéria", "Aluno inserido", JOptionPane.QUESTION_MESSAGE);

            }

        }
        readJTable();
    }

    private void adicionarFalta() {
        if (jtAluno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Aluno!");
        } else if (jtNota.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nota!");

        } else if (AlunoExiste(jtAluno.getText())) {
            FaltasDAO faltasDao = new FaltasDAO();
            if (faltasDao.acrescentarFalta(obterAluno(), materia)) {
                JOptionPane.showMessageDialog(null, "Aluno inserido na matéria", "Aluno inserido", JOptionPane.QUESTION_MESSAGE);

            }

        }
        readJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Aluno = new javax.swing.JLabel();
        jtNota = new javax.swing.JTextField();
        Nota = new javax.swing.JLabel();
        EditarNota = new javax.swing.JButton();
        AdicionarNota = new javax.swing.JButton();
        AdicionarFalta1 = new javax.swing.JButton();
        jtAluno = new javax.swing.JTextField();
        jlNomeMateria = new javax.swing.JLabel();
        jNomeProfessor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        IMAGEM = new javax.swing.JLabel();
        jvoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Aluno.setFont(new java.awt.Font("League Spartan Black", 1, 36)); // NOI18N
        Aluno.setForeground(new java.awt.Color(102, 102, 102));
        Aluno.setText("Aluno");
        getContentPane().add(Aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, -1, -1));

        jtNota.setBackground(new java.awt.Color(0, 0, 0));
        jtNota.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jtNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 270, 40));

        Nota.setFont(new java.awt.Font("League Spartan Black", 1, 36)); // NOI18N
        Nota.setForeground(new java.awt.Color(102, 102, 102));
        Nota.setText("Nota");
        getContentPane().add(Nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, -1, -1));

        EditarNota.setBackground(new java.awt.Color(102, 102, 102));
        EditarNota.setFont(new java.awt.Font("League Spartan", 0, 14)); // NOI18N
        EditarNota.setText("Editar Nota");
        EditarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarNotaActionPerformed(evt);
            }
        });
        getContentPane().add(EditarNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 720, 140, 30));

        AdicionarNota.setBackground(new java.awt.Color(102, 102, 102));
        AdicionarNota.setFont(new java.awt.Font("League Spartan", 0, 14)); // NOI18N
        AdicionarNota.setText("Adicionar Nota");
        AdicionarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarNotaActionPerformed(evt);
            }
        });
        getContentPane().add(AdicionarNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 670, 140, 30));

        AdicionarFalta1.setBackground(new java.awt.Color(102, 102, 102));
        AdicionarFalta1.setFont(new java.awt.Font("League Spartan", 0, 14)); // NOI18N
        AdicionarFalta1.setText("Adicionar Falta");
        AdicionarFalta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarFalta1ActionPerformed(evt);
            }
        });
        getContentPane().add(AdicionarFalta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 670, 150, 30));

        jtAluno.setBackground(new java.awt.Color(0, 0, 0));
        jtAluno.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jtAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 280, 270, 40));

        jlNomeMateria.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 36)); // NOI18N
        jlNomeMateria.setForeground(new java.awt.Color(255, 153, 102));
        jlNomeMateria.setText("Matemática");
        getContentPane().add(jlNomeMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        jNomeProfessor.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 36)); // NOI18N
        jNomeProfessor.setForeground(new java.awt.Color(255, 153, 102));
        jNomeProfessor.setText("Caique Augusto");
        getContentPane().add(jNomeProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Aluno", "Notas", "Faltas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtTabelaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 230, 730, -1));

        IMAGEM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumoif/resources/ProfessorMateira.png"))); // NOI18N
        getContentPane().add(IMAGEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        ProfessorS pS = new ProfessorS(professor);
        pS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jvoltarActionPerformed

    private void AdicionarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarNotaActionPerformed
        // TODO add your handling code here:
        adicionarNota();

    }//GEN-LAST:event_AdicionarNotaActionPerformed

    private void EditarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarNotaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EditarNotaActionPerformed

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jtTabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jtTabelaMouseReleased

    private void AdicionarFalta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarFalta1ActionPerformed
        // TODO add your handling code here:
        adicionarFalta();
    }//GEN-LAST:event_AdicionarFalta1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorMateria(materia, professor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarFalta1;
    private javax.swing.JButton AdicionarNota;
    private javax.swing.JLabel Aluno;
    private javax.swing.JButton EditarNota;
    private javax.swing.JLabel IMAGEM;
    private javax.swing.JLabel Nota;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jNomeProfessor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlNomeMateria;
    private javax.swing.JTextField jtAluno;
    private javax.swing.JTextField jtNota;
    private javax.swing.JTable jtTabela;
    private javax.swing.JButton jvoltar;
    // End of variables declaration//GEN-END:variables
}
