/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean.Escola;

import java.util.ArrayList;

/**
 *
 * @author Caio Rievers
 */
public class Diretor extends Funcionario implements Punir{
    
    private ArrayList<Professor> profs;
    
    public Diretor(String nome, String matricula, double salario) {
        super(nome, matricula, salario);
    }
    
    public ArrayList<Professor> getProfs(){
        return profs;
    }
    
    public void admitirProf(String nome, String matricula, double salario){
        Professor prof = new Professor(nome, matricula, salario);
        profs.add(prof);
    }
    
    public boolean demiteProf(int indexProf){
        return (profs.remove(profs.get(indexProf)));
    }
    
    public void atribuirMateria(String nomeMateria, int nAulas, int indexProf){
        Materia materia = new Materia(nomeMateria, nAulas);
        profs.get(indexProf).insereMateria(materia);
    }

    @Override
    public void darAdvertencia(Aluno aluno) {
        aluno.darAdvertencia();
    }

    @Override
    public void expulsar(Aluno aluno) {
        aluno.setExpulso(true);
    }
    
}
