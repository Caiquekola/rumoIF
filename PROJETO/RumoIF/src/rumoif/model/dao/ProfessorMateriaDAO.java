package rumoif.model.dao;

/**
 *
 * @author Caio Rievers
 */
import rumoif.model.bean.GenericDAO;
import rumoif.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rumoif.model.bean.Materia;
import rumoif.model.bean.Professor;
import rumoif.model.bean.ProfessorMateria;

public class ProfessorMateriaDAO implements GenericDAO<ProfessorMateria> {

    @Override
    public void create(ProfessorMateria profMateria) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("INSERT INTO rumoif.professor_materia (id_professor,id_materia) VALUES (?,?)");

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, profMateria.getId_professor());
            stmt.setInt(2, profMateria.getId_materia());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorMateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Materia> readUnit(Professor p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT m.id_materia, m.nome_materia "
                + "FROM rumoif.materia m "
                + "JOIN rumoif.professor_materia pm "
                + "ON m.id_materia = pm.id_materia "
                + "WHERE pm.id_professor = ?");
        List<Materia> materias = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Materia m = new Materia(rs.getString("nome_materia"), rs.getInt("id_materia"));
                materias.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorMateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return materias;
    }

    public void delete(ProfessorMateria profMateria) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = ("DELETE FROM rumoif.professor_materia WHERE id_professor = ?, id_materia = ?");
            stmt = con.prepareStatement(sql);
            stmt.setString(1, profMateria.getId_professor());
            stmt.setInt(2, profMateria.getId_materia());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
