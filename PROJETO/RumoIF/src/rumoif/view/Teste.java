/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rumoif.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rumoif.connection.ConnectionFactory;
import rumoif.model.bean.Usuario;
import rumoif.model.dao.UsuarioDAO;

/**
 *
 * @author Caiqu
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario userTeste = new Usuario("Jabaria","jabaria@hotmail.com","123",5);
        UsuarioDAO login = new UsuarioDAO();
        login.create(userTeste);
        
       
    }
    
}
