package rumoif.model.dao;

import rumoif.model.bean.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Professor;

public class ProfessorDAO implements GenericDAO<Professor>{

    @Override
    public void create(Professor u) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO rumoif.login (nome,email,usuario,senha,nivel) VALUES (?,?,?,?,1)");

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getUsuario());
            stmt.setString(4, u.getSenha());

            stmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Professor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.login WHERE nivel = 1");
        List<Professor> professores = new ArrayList<Professor>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Professor p = new Professor(rs.getString("nome"), rs.getString("email"), rs.getString("usuario"), rs.getString("senha"));
                professores.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return professores;
    }
    public Professor readUnit(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Professor novo = p;
        String sql = ("SELECT * FROM rumoif.login WHERE usuario = ? AND senha = ?");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getUsuario());
            stmt.setString(2, p.getSenha());
            rs = stmt.executeQuery();
            if (rs.next()) {
                novo.setNome(rs.getString("nome"));
                novo.setUsuario(rs.getString("usuario"));
                novo.setEmail(rs.getString("email"));
                novo.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return novo;
    }
    public void update(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("UPDATE rumoif.login SET nome = ?, email = ?, senha = ? WHERE usuario = ? AND nivel = 1;");
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getSenha());
            stmt.setString(4, p.getUsuario());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Professor p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM rumoif.professor_materia WHERE id_professor = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getUsuario());
            stmt.executeUpdate();
            //String sql = "DELETE FROM rumoif.login WHERE nome = '"+a.getNome()+"' AND email = '"+a.getEmail()+"' AND usuario = '"+a.getUsuario()+"';";
            sql = "DELETE FROM rumoif.login WHERE nome = ? AND email = ? OR usuario = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2,p.getEmail());
            stmt.setString(3, p.getUsuario());
            stmt.executeUpdate();
             

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
