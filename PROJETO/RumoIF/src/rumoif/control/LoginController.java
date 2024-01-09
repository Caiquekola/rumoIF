package rumoif.control;

import rumoif.connection.ConnectionFactory;
import rumoif.view.Login;
import java.sql.*;
import rumoif.model.bean.Professor;
import rumoif.model.dao.LoginDAO;
import rumoif.model.dao.ProfessorDAO;

public class LoginController {
    
    public int loginUsuario(Login view) throws SQLException{
        LoginDAO login = new LoginDAO();
        return login.login((view.getjTextField1().getText()), view.getjPasswordField1().getText());
    }
    public Professor nomeProfessor(Login view) throws SQLException{
        ProfessorDAO pdao = new ProfessorDAO();
        Professor p = new Professor((view.getjTextField1().getText()), view.getjPasswordField1().getText());
        return pdao.readUnit(p);
    }
}
