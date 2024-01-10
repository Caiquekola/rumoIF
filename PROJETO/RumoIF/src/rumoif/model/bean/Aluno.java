/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rumoif.model.bean;


public class Aluno extends Usuario{
    //CRIAR ALUNO
    public Aluno(String nome, String email, String usuario, String senha) {
        super(nome, email, usuario, senha);
        this.setNivel(0);
    }
    //REMOVER ALUNO
    public Aluno(String nome, String email,String usuario){
        super(nome,email,usuario);
        this.setNivel(0);
    }
    //Tela de Login passando Aluno para frente
    public Aluno(String usuario, String senha){
        super(usuario,senha);
        this.setNivel(0);
    }
}
