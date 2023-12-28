/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rumoif.view;

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
        Usuario userTeste = new Usuario("Caique","caiquekola@hotmail.com","123",2);
        UsuarioDAO login = new UsuarioDAO();
        login.create(userTeste);
    }
    
}
