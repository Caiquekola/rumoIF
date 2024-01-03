
package rumoif.model.dao;

import rumoif.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rumoif.model.bean.AlunoMateria;

public class AlunoMateriaDAO {
    public void create(AlunoMateria alunoMateria){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("INSERT INTO rumoif.aluno_materia (id_materia,id_aluno) VALUES (?,?)");
        
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, alunoMateria.getId_materia());
            stmt.setString(2, alunoMateria.getId_aluno());
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deu certo!");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoMateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
