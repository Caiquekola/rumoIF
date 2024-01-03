/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rumoif.model.bean;


public class Professor extends Usuario{
    private final int nivel = 1;
    //CRIAR PROFESSOR
    public Professor(String nome, String email, String usuario, String senha) {
        super(nome, email, usuario, senha);
    }
    //REMOVER PROFESSOR - DIRETOR
    public Professor(String nome,String email,String usuario){
        super(nome,email,usuario);
    }
    public int getNivel() {
        return nivel;
    }
    
}
