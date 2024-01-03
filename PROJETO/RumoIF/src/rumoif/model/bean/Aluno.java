/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rumoif.model.bean;


public class Aluno extends Usuario{
    private final int nivel = 0;
    //CRIAR ALUNO
    public Aluno(String nome, String email, String usuario, String senha) {
        super(nome, email, usuario, senha);
        
    }
    //REMOVER ALUNO
    public Aluno(String nome, String email,String usuario){
        super(nome,email,usuario);
    }
    
    public int getNivel() {
        return nivel;
    }
    
    
}
