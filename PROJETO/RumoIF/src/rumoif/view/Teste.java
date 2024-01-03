/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rumoif.view;

import rumoif.model.bean.Aluno;
import rumoif.model.dao.AlunoDAO;


public class Teste {

    public static void main(String[] args) {
       String nome = "Paulo";
       String email = "paulo@gmail.com";
       String usuario = "Paulo";
       String senha = "123";
       String nivel;
       Aluno a = new Aluno(nome,email,usuario,senha);
       AlunoDAO dao = new AlunoDAO();
       //AlunoDAO.create(a);
       dao.delete(a);
      
    }
    
}
