package rumoif.control;

import rumoif.connection.ConnectionFactory;
import rumoif.view.LoginScreen;
import java.sql.*;
import rumoif.model.dao.UsuarioDAO;

public class LoginController {
    
    public int loginUsuario(LoginScreen view) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        UsuarioDAO login = new UsuarioDAO();
        return login.login((view.getjTextField1().getText()), view.getjPasswordField1().getText());
    }
    
}
