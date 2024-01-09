/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean;

/**
 *
 * @author Caio Rievers
 */
public class Notas {
    
    private int id_materia;
    private String id_aluno;
    private double nota;
    private String atividade;
    //criação dao
    public Notas(int id_materia, String id_aluno, double nota,String atividade) {
        this.id_materia = id_materia;
        this.id_aluno = id_aluno;
        this.nota = nota;
        this.atividade = atividade;
    }

    //read dao
    public Notas(String id_aluno, double nota) {
        this.id_aluno = id_aluno;
        this.nota = nota;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }
    
    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}
