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
public class Materia {
    
    private int nAulas;
    private String nome;
    private ArrayList<Estudante> estudantes;

    public Materia(String nome, int nAulas) {
        this.nAulas = nAulas;
        this.nome = nome;
    }

    public int getnAulas() {
        return nAulas;
    }

    public void setnAulas(int nAulas) {
        this.nAulas = nAulas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estudante getEstudante(int index) {
        return estudantes.get(index);
    }
    
    public ArrayList<Estudante> getEstudantes(){
        return estudantes;
    }

    public void setEstudantes(ArrayList sala) {
        this.estudantes = sala;
    }
    
    public void insereAluno(Aluno aluno){
        Estudante e = new Estudante(aluno);
        estudantes.add(e);
    }
    
}
