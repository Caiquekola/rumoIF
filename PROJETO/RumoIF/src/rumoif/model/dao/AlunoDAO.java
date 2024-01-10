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
import rumoif.model.bean.AlunoMateria;
import rumoif.model.bean.Materia;


public class AlunoDAO implements GenericDAO<Aluno>{ //Implementa interface
 
    
    public void create(Aluno u) { //Adapta Aluno para o banco de dados
        Connection con = ConnectionFactory.getConnection(); //conecta com o banco de dados
        PreparedStatement stmt = null; //Declara comando para o banco de dados

        try { //Prepara as instruções do banco de dados
            stmt = con.prepareStatement("INSERT INTO rumoif.login (nome,email,usuario,senha,nivel) VALUES (?,?,?,?,?)");
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getUsuario());
            stmt.setString(4, u.getSenha());
            stmt.setInt(5,u.getNivel());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) { //Trata erro de manipulação no banco de dados
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexão com o banco de dados
        }

    }
    public List<Aluno> read() { //Retorna uma lista com todos os alunos
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * from rumoif.login WHERE nivel = 0"); //Filtro para seleção de somente alunos

            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("email"),
                        rs.getString("usuario"), rs.getString("senha"));
                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return alunos;

    }
    //Polimorfismo para procurar aluno pelo nome e devolver dados, utilizado na tabela de professor e materia
    public Aluno read(String usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Aluno alunon = null;

        try {
            stmt = con.prepareStatement("SELECT * from rumoif.login WHERE usuario = ?");
            stmt.setString(1,usuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                alunon = new Aluno(rs.getString("nome"), rs.getString("email"),
                        rs.getString("usuario"), rs.getString("senha"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return alunon;

    }
    //Polimorfismo Professor Tabela

    public List<Aluno> read(Materia m) { //Retorna todos os alunos de uma determinada matéria
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Aluno alunon = null;
        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT l.nome,l.usuario,l.email,l.senha FROM rumoif.login l JOIN rumoif.aluno_materia am ON l.usuario = am.id_aluno WHERE am.id_materia = ?");
            stmt.setInt(1,m.getId_materia());
            rs = stmt.executeQuery();

            while (rs.next()) {
                alunon = new Aluno(rs.getString("nome"), rs.getString("email"),
                        rs.getString("usuario"), rs.getString("senha"));
                alunos.add(alunon);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return alunos;

    }
    public void update(Aluno a){ //Atualizar os dados do Aluno
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
