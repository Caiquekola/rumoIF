package rumoif.model.dao;

import rumoif.connection.ConnectionFactory;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDAO { 
//Loga o usuário no sistema para acesso aos dados
 public int login(String usuario, String senha) {
        PreparedStatement stmt = null;
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        int nivel = -1;
        try {
            String sql = "SELECT * FROM rumoif.login WHERE usuario = ? AND senha = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
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
