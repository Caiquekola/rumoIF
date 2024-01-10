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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Materia;
import rumoif.model.bean.Aluno;
import rumoif.model.bean.Faltas;
import rumoif.model.bean.Notas;
import rumoif.model.dao.MateriaDAO;
import rumoif.model.dao.AlunoDAO;
import rumoif.model.dao.FaltasDAO;
import rumoif.model.dao.NotasDAO;

/**
 *
 * @author ADMIN
 */
public class DiretorAlunoMateria extends javax.swing.JFrame {

    /**
     * Creates new form DiretorSAluno
     */
    public DiretorAlunoMateria() {
        initComponents();

        jtAluno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    adicionar(obterMateria(), obterAluno());

                }
            }
        });

        jtMateria.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    adicionar(obterMateria(), obterAluno());

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
        AlunoDAO pDao = new AlunoDAO();

        List<Materia> materias = mDao.read();
        List<Aluno> alunos = pDao.read();

        int maxSize = Math.max(materias.size(), alunos.size());

        for (int i = 0; i < maxSize; i++) {
            Object[] rowData = new Object[3]; // Array para armazenar dados de uma linha

            if (i < alunos.size()) {
                Aluno professor = alunos.get(i);
                rowData[0] = professor.getUsuario();
            }
            if (i < alunos.size()) {
                Aluno professor = alunos.get(i);
                rowData[1] = professor.getNome();
            }
            if (i < materias.size()) {
                Materia materia = materias.get(i);
                rowData[2] = materia.getNome_materia();
            }

            modelo.addRow(rowData);
        }
    }
    

    private boolean materiaAlunoExiste(Materia m, String p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
        boolean existe2 = false;
        if (m == null) {
            return false;
        }
        String sql = ("SELECT * FROM rumoif.materia WHERE nome_materia = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome_materia());

            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiretorAlunoMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = ("SELECT * FROM rumoif.login WHERE usuario = ?");
        rs = null;
        stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p);

            rs = stmt.executeQuery();
            if ((rs.next())) {
                existe2 = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiretorAlunoMateria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return existe & existe2;
    }

    private Materia obterMateria() {
        MateriaDAO mdao = new MateriaDAO();
        Materia m = mdao.read(jtMateria.getText());
        return m;
    }

    private String obterAluno() {
        String professorRa = jtAluno.getText();
        return professorRa;
    }

    private boolean relacaoJaCriada(Materia m, String p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.aluno_materia WHERE id_aluno = ? AND id_materia = ?");
        boolean ja = false;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p);
            stmt.setInt(2, m.getId_materia());
            rs = stmt.executeQuery();
            if (rs.next()) {
                ja = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiretorAlunoMateria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ja;
    }

    private void adicionarRelacao(Materia m, String p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("INSERT INTO rumoif.aluno_materia (id_aluno,id_materia) VALUES (?,?)");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p);
            stmt.setInt(2, m.getId_materia());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DiretorAlunoMateria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    private void materia() {
        Faltas f = new Faltas(obterAluno(), obterMateria());
        FaltasDAO fDao = new FaltasDAO();
        fDao.create(f);
        Notas n = new Notas(obterAluno(), obterMateria());
        NotasDAO nDao = new NotasDAO();
        nDao.create(n);
    }

    private void adicionar(Materia m, String p) {
        if (jtMateria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Matéria!");
        } else if (jtAluno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Aluno!");

        } else if (materiaAlunoExiste(obterMateria(), obterAluno())) {
            materia();
            if (relacaoJaCriada(m, p)) {
                JOptionPane.showMessageDialog(null, "Aluno já está inserido na matéria", "Aluno inserido", JOptionPane.QUESTION_MESSAGE);
            } else {
                adicionarRelacao(obterMateria(), obterAluno());
                JOptionPane.showMessageDialog(null, "Aluno inserido na matéria", "Aluno inserido", JOptionPane.QUESTION_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "ERRO! Aluno ou Matéria não existem", "Aluno não inserido", JOptionPane.QUESTION_MESSAGE);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jtAluno = new javax.swing.JTextField();
        Nome = new javax.swing.JLabel();
        Nome1 = new javax.swing.JLabel();
        jtMateria = new javax.swing.JTextField();
        Adicionar = new javax.swing.JButton();
        Imagem = new javax.swing.JLabel();
        jbVoltar = new javax.swing.JButton();
        Matéria1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuário", "Nome", "Matéria"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 460, 150));

        jtAluno.setBackground(new java.awt.Color(0, 0, 0));
        jtAluno.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtAluno.setForeground(new java.awt.Color(255, 255, 255));
        jtAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtAlunoActionPerformed(evt);
            }
        });
        getContentPane().add(jtAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 200, 40));

        Nome.setFont(new java.awt.Font("League Spartan Black", 0, 28)); // NOI18N
        Nome.setForeground(new java.awt.Color(255, 255, 255));
        Nome.setText("Aluno (R.A)");
        getContentPane().add(Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 200, -1));

        Nome1.setFont(new java.awt.Font("League Spartan Black", 0, 36)); // NOI18N
        Nome1.setForeground(new java.awt.Color(255, 255, 255));
        Nome1.setText("Matéria");
        getContentPane().add(Nome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jtMateria.setBackground(new java.awt.Color(0, 0, 0));
        jtMateria.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtMateria.setForeground(new java.awt.Color(255, 255, 255));
        jtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMateriaActionPerformed(evt);
            }
        });
        getContentPane().add(jtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 200, 40));

        Adicionar.setBackground(new java.awt.Color(55, 0, 153));
        Adicionar.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 14)); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(Adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, 30));

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumoif/resources/DiretorAluno.png"))); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jbVoltar.setText("jButton1");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jbVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 150, 40));

        Matéria1.setBackground(new java.awt.Color(0, 102, 0));
        Matéria1.setFont(new java.awt.Font("League Spartan", 1, 36)); // NOI18N
        Matéria1.setForeground(new java.awt.Color(255, 255, 255));
        Matéria1.setText("Matéria");
        Matéria1.setToolTipText("");
        Matéria1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Matéria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Matéria1ActionPerformed(evt);
            }
        });
        getContentPane().add(Matéria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 220, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DiretorS d = new DiretorS();
        d.setVisible(true);
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void Matéria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Matéria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Matéria1ActionPerformed

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jtTabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMousePressed
        // TODO add your handling code here

    }//GEN-LAST:event_jtTabelaMousePressed

    private void jtAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAlunoActionPerformed

    private void jtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMateriaActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        // TODO add your handling code here:
        adicionar(obterMateria(), obterAluno());
    }//GEN-LAST:event_AdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(DiretorAlunoMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiretorAlunoMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiretorAlunoMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiretorAlunoMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new DiretorAlunoMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton Matéria1;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Nome1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTextField jtAluno;
    private javax.swing.JTextField jtMateria;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables
}
