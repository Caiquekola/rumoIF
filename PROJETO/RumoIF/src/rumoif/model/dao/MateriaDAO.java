/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.dao;

import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MateriaDAO {

    public void create(Materia materia) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("INSERT INTO rumoif.materia (nome_materia) VALUES ('?');");
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, materia.getNome_materia());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
