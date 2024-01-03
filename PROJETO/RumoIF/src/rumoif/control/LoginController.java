package rumoif.control;

import rumoif.connection.ConnectionFactory;
import rumoif.view.Login;
import java.sql.*;
import rumoif.model.dao.LoginDAO;

public class LoginController {
    
    public int loginUsuario(Login view) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        LoginDAO login = new LoginDAO();
        return login.login((view.getjTextField1().getText()), view.getjPasswordField1().getText());
    }
    
}
