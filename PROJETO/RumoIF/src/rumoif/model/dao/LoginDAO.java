/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.dao;

import rumoif.connection.ConnectionFactory;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDAO {
 public int login(String usuario, String senha) {
        PreparedStatement stmt = null;
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        int nivel = -1;
        try {
            String sql = "SELECT nivel FROM rumoif.login WHERE usuario = '" + usuario + "' AND senha = '" + senha + "'";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                nivel = rs.getInt("nivel");
                
            } else {
                System.out.println("Nao possui conta!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nivel;
    }
}
