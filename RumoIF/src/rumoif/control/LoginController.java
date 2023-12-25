package rumoif.control;

import rumoif.connection.ConnectionFactory;
import rumoif.view.LoginScreen;
import java.sql.*;
import rumoif.model.dao.UsuarioDAO;

public class LoginController {
    public void loginUsuario(LoginScreen view) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        UsuarioDAO login = new UsuarioDAO();
        login.login(view.getJtUsuario(), view.getJpSenha());
    }
}
