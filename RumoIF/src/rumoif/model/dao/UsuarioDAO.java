/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.dao;

import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Usuario;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    public void create(Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuarios (usuario,senha) VALUES (?,?)");
            stmt.setInt(1, u.getUsuario());
            stmt.setString(2, u.getSenha());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuário criado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
    }
}
