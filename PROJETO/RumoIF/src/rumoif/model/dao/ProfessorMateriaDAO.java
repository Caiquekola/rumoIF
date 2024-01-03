package rumoif.model.dao;

/**
 *
 * @author Caio Rievers
 */

import rumoif.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rumoif.model.bean.ProfessorMateria;

public class ProfessorMateriaDAO {
    
    public void create(ProfessorMateria profMateria){
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
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
