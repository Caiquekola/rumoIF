/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean;

/**
 *
 * @author Caio Rievers
 */
public abstract class Funcionario extends Usuario{
    private double salario;
    
    public Funcionario(String Usuario, String senha) {
        super(Usuario, senha);
    }
    
    public Funcionario(String nome,String email,String usuario, String senha){
        super(nome, email, usuario,  senha);
    }
    
    public Funcionario(String nome,String email,String usuario){
        super(nome, email, usuario);
    }
    
    public void setSalario(double sal){
        this.salario = sal;
    }

    public double getSalario(){
        return this.salario;
    }
}
