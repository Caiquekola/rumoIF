
package rumoif.model.dao;

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
import rumoif.model.bean.Aluno;
import rumoif.model.bean.AlunoMateria;
import rumoif.model.bean.Materia;

public class AlunoMateriaDAO implements GenericDAO<AlunoMateria>{ 
    //Implementa interface
    @Override
    public void create(AlunoMateria alunoMateria){ //Método herdado da interface
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("INSERT INTO rumoif.aluno_materia (id_materia,id_aluno) VALUES (?,?)");
        
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, alunoMateria.getId_materia());
            stmt.setString(2, alunoMateria.getId_aluno());
            
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoMateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    public List<AlunoMateria> read(Materia materia){ //Retorna os alunos de uma matéria
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT * FROM rumoif.aluno_materia WHERE id_materia = ?");
        List<AlunoMateria> materias = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, materia.getId_materia());
            rs = stmt.executeQuery();
            while (rs.next()) {
                AlunoMateria alunoMateria = new AlunoMateria(rs.getInt("id_aluno"), rs.getString("id_materia"));
                materias.add(alunoMateria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoMateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return materias;
    }
    public List<Materia> read(Aluno aluno){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = ("SELECT m.id_materia, m.nome_materia "
                + "FROM rumoif.materia m "
                + "JOIN rumoif.aluno_materia am "
                + "ON m.id_materia = am.id_materia "
                + "WHERE am.id_aluno = ?");
        List<Materia> materias = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getUsuario());
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
}
