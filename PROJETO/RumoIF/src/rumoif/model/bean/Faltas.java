package rumoif.model.bean;

public class Faltas {
    private String id_aluno;
    private int id_materia;
    private int quantidade;

    public Faltas(String id_aluno, int id_materia, int quantidade) {
        this.id_aluno = id_aluno;
        this.id_materia = id_materia;
        this.quantidade = quantidade;
    }
    //Read do FaltasDAO com ALUNO!
    public Faltas(int id_materia, int quantidade) {
        this.id_materia = id_materia;
        this.quantidade = quantidade;
    }
    //Read do FaltasDAO com materia
    public Faltas(String id_aluno, int quantidade) {
        this.id_aluno = id_aluno;
        this.quantidade = quantidade;
    }
    //Utilizado na criação do aluno em diretor diretamente com faltas
    public Faltas(String id_aluno, Materia m) {
        this.id_aluno = id_aluno;
        this.quantidade = 0;
        this.id_materia = m.getId_materia();
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
