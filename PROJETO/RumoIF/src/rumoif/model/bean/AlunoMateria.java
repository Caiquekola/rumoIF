/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rumoif.model.bean;


public class AlunoMateria {
    
    private int id_materia;
    private String id_aluno;
    
    public AlunoMateria(Aluno aluno, Materia materia){
        this.id_aluno = aluno.getUsuario();
        this.id_materia = materia.getId_materia();
    }

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }
    
    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }
    
    
}
