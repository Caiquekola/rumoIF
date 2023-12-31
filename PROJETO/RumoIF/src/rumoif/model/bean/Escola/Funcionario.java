/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean.Escola;

/**
 *
 * @author Caio Rievers
 */
public abstract class Funcionario extends Pessoa{
    
    private double salario;
    
    public Funcionario(String nome, String matricula, double salario) {
        super(nome, matricula);
        this.salario = salario;
    }
    
    public double verSalario(){
        return this.salario;
    }
}
