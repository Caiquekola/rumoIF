package rumoif.control;

import rumoif.connection.ConnectionFactory;
import rumoif.view.Login;
import java.sql.*;
import rumoif.model.bean.Aluno;
import rumoif.model.bean.Professor;
import rumoif.model.dao.AlunoDAO;
import rumoif.model.dao.LoginDAO;
import rumoif.model.dao.ProfessorDAO;

public class LoginController {
    
    public int loginUsuario(Login view) throws SQLException{
        LoginDAO login = new LoginDAO();
        System.out.println(login.login((view.getjTextField1().getText()), view.getjPasswordField1().getText()));
        return login.login((view.getjTextField1().getText()), view.getjPasswordField1().getText());
    }
    public Professor nomeProfessor(Login view) throws SQLException{
        ProfessorDAO pdao = new ProfessorDAO();
        Professor p = new Professor((view.getjTextField1().getText()), view.getjPasswordField1().getText());
        return pdao.readUnit(p);
    }
    public Aluno nomeAluno(Login view) throws SQLException{
        AlunoDAO adao = new AlunoDAO();
        Aluno a = new Aluno((view.getjTextField1().getText()), view.getjPasswordField1().getText());
        return adao.read(a);
    }
}
