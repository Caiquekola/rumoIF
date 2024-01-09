/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rumoif.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Professor;
import rumoif.model.dao.ProfessorDAO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ADMIN
 */
public class DiretorProfessorEditar extends javax.swing.JFrame {

    /**
     * Creates new form DiretorSProfessor
     */
    public DiretorProfessorEditar() {
        initComponents();
        jtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                        editar(obterProfessor());
                    
                }
                

            }
        });

        jtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                        editar(obterProfessor());
                    
                }
                

            }
        });
        jtSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                        editar(obterProfessor());
                    
                }
                
            }
        });
        jtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                        editar(obterProfessor());
                    
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
        ProfessorDAO udao = new ProfessorDAO();

        for (Professor a : udao.read()) {

            modelo.addRow(new Object[]{
                a.getUsuario(),
                a.getNome(),
                a.getEmail(),
                a.getSenha()

            });

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

        jtUsuario = new javax.swing.JTextField();
        Usuario = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jtSenha = new javax.swing.JTextField();
        Senha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jbEditar = new javax.swing.JButton();
        Imagem = new javax.swing.JLabel();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtUsuario.setBackground(new java.awt.Color(0, 0, 0));
        jtUsuario.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 210, 30));

        Usuario.setFont(new java.awt.Font("League Spartan", 0, 18)); // NOI18N
        Usuario.setForeground(new java.awt.Color(204, 204, 204));
        Usuario.setText("Usuário (Não editável)");
        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        Email.setFont(new java.awt.Font("League Spartan", 0, 24)); // NOI18N
        Email.setForeground(new java.awt.Color(204, 204, 204));
        Email.setText("E-mail");
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        Nome.setFont(new java.awt.Font("League Spartan", 0, 24)); // NOI18N
        Nome.setForeground(new java.awt.Color(204, 204, 204));
        Nome.setText("Nome");
        getContentPane().add(Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jtNome.setBackground(new java.awt.Color(0, 0, 0));
        jtNome.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtNome.setForeground(new java.awt.Color(255, 255, 255));
        jtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 210, 30));

        jtEmail.setBackground(new java.awt.Color(0, 0, 0));
        jtEmail.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtEmail.setForeground(new java.awt.Color(255, 255, 255));
        jtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(jtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 210, 30));

        jtSenha.setBackground(new java.awt.Color(0, 0, 0));
        jtSenha.setFont(new java.awt.Font("League Spartan ExtraBold", 0, 18)); // NOI18N
        jtSenha.setForeground(new java.awt.Color(255, 255, 255));
        jtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 210, 30));

        Senha.setFont(new java.awt.Font("League Spartan", 0, 24)); // NOI18N
        Senha.setForeground(new java.awt.Color(204, 204, 204));
        Senha.setText("Senha");
        getContentPane().add(Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Nome", "Email", "Senha"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 450, 330));

        jbEditar.setBackground(new java.awt.Color(55, 0, 153));
        jbEditar.setFont(new java.awt.Font("League Spartan Black", 0, 24)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(255, 255, 255));
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 150, 60));

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rumoif/resources/DiretorProfessorEditar.png"))); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jbVoltar.setText("jButton1");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jbVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 530, 110, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailActionPerformed

    private void jtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNomeActionPerformed

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DiretorProfessor d = new DiretorProfessor();
        d.setVisible(true);
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        
            editar(obterProfessor());
        
    }//GEN-LAST:event_jbEditarActionPerformed
    public void selecaoTabela(){
        if (jtTabela.getSelectedRow() != -1) {
            jtUsuario.setText(jtTabela.getValueAt(jtTabela.getSelectedRow(), 0).toString());
            jtNome.setText(jtTabela.getValueAt(jtTabela.getSelectedRow(), 1).toString());
            jtEmail.setText(jtTabela.getValueAt(jtTabela.getSelectedRow(), 2).toString());
            jtSenha.setText(jtTabela.getValueAt(jtTabela.getSelectedRow(), 3).toString());

        }
    }
    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked
        // TODO add your handling code here:
        selecaoTabela();
    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSenhaActionPerformed
        // TODO add your handling code here:
        selecaoTabela();
    }//GEN-LAST:event_jtSenhaActionPerformed

    private void jtTabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseReleased
        // TODO add your handling code here:
        selecaoTabela();
    }//GEN-LAST:event_jtTabelaMouseReleased

    private void jtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtUsuarioActionPerformed
        // TODO add your handling code here:
        selecaoTabela();
    }//GEN-LAST:event_jtUsuarioActionPerformed
    private boolean usuarioExiste(Professor a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
        String sql = ("SELECT FROM rumoif.login WHERE usuario = ? AND nivel = 1");
        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getUsuario());
            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DiretorProfessorEditar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return existe;

    }

    private void editar(Professor a) {
        
            if (jtNome.getText().isBlank() || jtEmail.getText().isBlank() || jtSenha.getText().isBlank()||jtUsuario.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else if (usuarioExiste(a)) {
                ProfessorDAO dao = new ProfessorDAO();
                dao.update(a);
                readJTable();
                jtNome.setText("");
                jtUsuario.setText("");
                jtSenha.setText("");
                jtEmail.setText("");
                JOptionPane.showMessageDialog(null, "Professor editado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Professor não existente!");
            }
            readJTable();
        
        
        //Testar se usuário existe
    }

    private Professor obterProfessor() {

        Professor a = new Professor(jtNome.getText(), jtEmail.getText(), jtUsuario.getText(),jtSenha.getText());
        return a;

    }

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
            java.util.logging.Logger.getLogger(DiretorProfessorEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiretorProfessorEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiretorProfessorEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Imagem;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Senha;
    private javax.swing.JLabel Usuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtSenha;
    private javax.swing.JTable jtTabela;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables
}
