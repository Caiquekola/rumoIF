package rumoif.model.bean;

/**
 * @author Caio Rievers
 */
public class Notas { //Base para o banco de dados
    
    private int id_materia;
    private String id_aluno;
    private double nota;
    //criação dao
    public Notas(int id_materia, String id_aluno, double nota) {
        this.id_materia = id_materia;
        this.id_aluno = id_aluno;
        this.nota = nota;
    }
    //criação materia dao
    public Notas(String s,Materia m) {
        this.id_materia = m.getId_materia();
        this.id_aluno = s;
        this.nota = 0;
    }
    //read dao
    public Notas(String id_aluno, double nota) {
        this.id_aluno = id_aluno;
        this.nota = nota;
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
