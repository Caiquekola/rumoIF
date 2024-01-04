/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.dao;

import rumoif.model.bean.GenericDAO;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Materia;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MateriaDAO implements GenericDAO<Materia>{

    @Override
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
    
    public List<Materia> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.materia");
        List<Materia> materias = new ArrayList<Materia>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Materia m = new Materia(rs.getString("nome_materia"), rs.getInt("id_materia"));
                materias.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return materias;
    }
    
    public void update(Materia m) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("UPDATE rumoif.materia SET nome_materia = ? WHERE id_materia = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome_materia());
            stmt.setInt(2, m.getId_materia());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void delete(Materia m) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = ("DELETE FROM rumoif.materia WHERE nome_materia = ? AND id_materia = ?");
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome_materia());
            stmt.setInt(2, m.getId_materia());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
