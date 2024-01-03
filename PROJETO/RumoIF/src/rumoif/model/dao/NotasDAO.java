/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.dao;

/**
 *
 * @author Caio Rievers
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Aluno;
import rumoif.model.bean.Materia;
import rumoif.model.bean.Notas;

public class NotasDAO {
    
    public void create(Notas n) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO rumoif.faltas (id_materia, id_aluno, nota) VALUES (?,?,?)");

            stmt.setInt(1, n.getId_materia());
            stmt.setString(2, n.getId_aluno());
            stmt.setDouble(3, n.getNota());

            stmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Notas> read(Aluno a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.notas WHERE id_aluno = ?");
        List<Notas> notas = new ArrayList<Notas>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Notas n = new Notas(rs.getInt("id_materia"), rs.getDouble("nota"));
                notas.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return notas;
    }
    public List<Notas> read(Materia m) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.notas WHERE id_materia = ?");
        List<Notas> notas = new ArrayList<Notas>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, m.getId_materia());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Notas n = new Notas(rs.getString("id_aluno"), rs.getDouble("nota"));
                notas.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return notas;
    }

    public void update(Notas n) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("UPDATE rumoif.notas SET nota = ? WHERE id_aluno = ? AND id_materia = ?;");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, n.getNota());
            stmt.setString(2, n.getId_aluno());
            stmt.setInt(3, n.getId_materia());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
