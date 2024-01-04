/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
import rumoif.model.bean.Aluno;


public class AlunoDAO implements GenericDAO<Aluno>{
 
    
    public void create(Aluno u) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO rumoif.login (nome,email,usuario,senha,nivel) VALUES (?,?,?,?,?)");
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getUsuario());
            stmt.setString(4, u.getSenha());
            stmt.setInt(5,u.getNivel());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public  List<Aluno> read(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Aluno> alunos = new ArrayList<>();
            
            try {
                stmt = con.prepareStatement("SELECT * from rumoif.login WHERE nivel = 0");
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Aluno aluno = new Aluno(rs.getString("nome"),rs.getString("email"),
                    rs.getString("usuario"),rs.getString("senha"));
                    alunos.add(aluno);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
            return alunos;
            
        }
    
    public void update(Aluno a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = ("UPDATE rumoif.login SET nome = ?, email = ?,senha = ? WHERE usuario = ? AND nivel = 0;");
        
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getSenha());
            stmt.setString(4,a.getUsuario());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public void delete(Aluno a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            //String sql = "DELETE FROM rumoif.login WHERE nome = '"+a.getNome()+"' AND email = '"+a.getEmail()+"' AND usuario = '"+a.getUsuario()+"';";
            String sql = "DELETE FROM rumoif.login WHERE nome = ? AND email = ? OR usuario = ? AND nivel = 0;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2,a.getEmail());
            stmt.setString(3, a.getUsuario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }

    

    
}
