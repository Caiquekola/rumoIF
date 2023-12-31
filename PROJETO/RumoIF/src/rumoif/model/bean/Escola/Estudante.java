/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean.Escola;

/**
 *
 * @author Caio Rievers
 */
class Estudante {
    
    private Aluno aluno;
    private int faltas;
    private float nota;

    public Estudante(Aluno aluno) {
        this.aluno = aluno;
        this.faltas = 0;
        this.nota = 0;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getFaltas() {
        return faltas;
    }

    public void darFalta() {
        this.faltas++;
    }
    
    public void removerFalta(){
        if (this.faltas > 0) this.faltas--;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    public void somaNota(float nota){
        this.nota += nota;
    }
    
}
