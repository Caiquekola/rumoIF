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
public class Professor extends Funcionario implements Sistema, Punir{
    
    private ArrayList<Materia> materias;

    public Professor(String nome, String matricula, double salario) {
        super(nome, matricula, salario);
    }
    
    protected void insereMateria(Materia materia){
        materias.add(materia);
    }
    
    @Override
    public void somarNota(int indexMateria, int indexAluno, float nota) {
        materias.get(indexMateria).getEstudante(indexAluno).somaNota(nota);
    }

    @Override
    public void alterarNota(int indexMateria, int indexAluno, float nota) {
        materias.get(indexMateria).getEstudante(indexAluno).setNota(nota);
    }

    @Override
    public void atribuirFalta(int indexMateria, int indexAluno) {
        materias.get(indexMateria).getEstudante(indexAluno).darFalta();
    }

    @Override
    public void removerFalta(int indexMateria, int indexAluno) {
        materias.get(indexMateria).getEstudante(indexAluno).removerFalta();
    }

    @Override
    public float verNota(int indexMateria, int indexAluno) {
        return materias.get(indexMateria).getEstudante(indexAluno).getNota();
    }

    @Override
    public int verFalta(int indexMateria, int indexAluno) {
        return materias.get(indexMateria).getEstudante(indexAluno).getFaltas();
    }

    @Override
    public void darAdvertencia(Aluno aluno) {
        aluno.darAdvertencia();
    }
    
    public void insereAluno(int nMateria, Aluno aluno){
        materias.get(nMateria).insereAluno(aluno);
    }
    
    @Override
    public void expulsar(Aluno aluno) {
        aluno.setExpulso(true);
    }
    
}
