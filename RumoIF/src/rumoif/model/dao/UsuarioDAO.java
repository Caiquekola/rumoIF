/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.dao;

import rumoif.model.bean.Usuario;
import rumoif.connection.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    public void create(Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO login (nome,email,senha,usuario) VALUES (?,?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getUsuario());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuário criado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    public void login(int usuario, String senha){
        try {
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT usuario,senha FROM login WHERE usuario = '"+usuario+"' AND senha = '"+senha+"'";
            System.out.println(sql);
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                System.out.println("Possui");
            }else{
                System.out.println("Não possui");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
    }
    
}
