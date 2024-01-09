/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rumoif.model.bean;


public class Professor extends Usuario{
    //CRIAR PROFESSOR
    public Professor(String nome, String email, String usuario, String senha) {
        super(nome, email, usuario, senha);
        this.setNivel(1);
    }
    //REMOVER PROFESSOR - DIRETOR
    public Professor(String nome,String email,String usuario){
        super(nome,email,usuario);
        this.setNivel(1);
    }
    //PASSAR PROFESSOR PARA INTERFACE DE PROFESSOR APENAS COM USUARIO E LOGIN
    public Professor(String usuario, String senha){
        super(usuario,senha);
        this.setNivel(1);
    }
}
