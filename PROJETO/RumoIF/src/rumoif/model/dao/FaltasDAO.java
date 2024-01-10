package rumoif.model.dao;

/**
 *
 * @author Caio Rievers
 */

import rumoif.model.bean.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Aluno;
import rumoif.model.bean.Materia;
import rumoif.model.bean.Faltas;

public class FaltasDAO implements GenericDAO<Faltas>{
    
    public void create(Faltas f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO rumoif.faltas (id_materia, id_aluno, quantidade) VALUES (?,?,?)");

            stmt.setInt(1, f.getId_materia());
            stmt.setString(2, f.getId_aluno());
            stmt.setInt(3, 0);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    //Tabela de professores
    public boolean acrescentarFalta(String aluno, Materia m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Boolean certo = false;
        Boolean certo2 = false;
        int quantidade = 0;
        //Pegar a quantidade de faltas
        String sql = ("SELECT * FROM rumoif.faltas WHERE id_aluno = ? AND id_materia = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno);
            stmt.setInt(2,m.getId_materia());
            rs = stmt.executeQuery();
            if (rs.next()) {
                quantidade = rs.getInt("quantidade");
                certo = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        sql = ("UPDATE rumoif.faltas SET quantidade = ? WHERE id_aluno = ? AND id_materia = ?;");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, quantidade+1);
            stmt.setString(2,aluno);
            stmt.setInt(3, m.getId_materia());
            stmt.executeUpdate();
            certo2 = true;
        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return certo;
    }public boolean diminuirFalta(String aluno, Materia m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Boolean certo = false;
        int quantidade = 0;
        //Pegar a quantidade de faltas
        String sql = ("SELECT * FROM rumoif.faltas WHERE id_aluno = ? AND id_materia = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno);
            stmt.setInt(2,m.getId_materia());
            rs = stmt.executeQuery();
            if (rs.next()) {
                quantidade = rs.getInt("quantidade");
                certo = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        if(quantidade<=0){
            quantidade = 1;
        }
        sql = ("UPDATE rumoif.faltas SET quantidade = ? WHERE id_aluno = ? AND id_materia = ?;");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, quantidade-1);
            stmt.setString(2,aluno);
            stmt.setInt(3, m.getId_materia());
            stmt.executeUpdate();
            certo = true;
        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return certo;
    }
    public List<Faltas> read(Aluno a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.faltas WHERE id_aluno = ? ORDER BY id_aluno");
        List<Faltas> faltas = new ArrayList<Faltas>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Faltas f = new Faltas(rs.getInt("id_materia"), rs.getInt("quantidade"));
                faltas.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return faltas;
    }
    public List<Faltas> read(Materia m) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.faltas WHERE id_materia = ? ORDER BY id_aluno");
        List<Faltas> faltas = new ArrayList<Faltas>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, m.getId_materia());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Faltas f = new Faltas(rs.getString("id_aluno"),rs.getInt("id_materia"), rs.getInt("quantidade"));
                faltas.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return faltas;
    }

    public void update(Faltas f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("UPDATE rumoif.faltas SET quantidade = ? WHERE id_aluno = ? AND id_materia = ?;");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getQuantidade());
            stmt.setString(2, f.getId_aluno());
            stmt.setInt(3, f.getId_materia());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FaltasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}
