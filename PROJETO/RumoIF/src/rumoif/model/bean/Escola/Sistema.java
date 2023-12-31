/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean.Escola;

/**
 *
 * @author Caio Rievers
 */
public interface Sistema {
    /*
    public void alterarNota(Materia materia, int indexAluno, float nota);
    
    public void somarNota(Materia materia, int indexAluno, float nota);
    
    public void atribuirFalta(Materia materia, int indexAluno);
    
    public void removerFalta(Materia materia, int indexAluno);
    
    public float verNota(Materia materia, int indexAluno);
    
    public int verFalta(Materia materia, int indexAluno);
    */
    
    public void somarNota(int indexMateria, int indexAluno, float nota);
    
    public void alterarNota(int indexMateria, int indexAluno, float nota);
    
    public void atribuirFalta(int indexMateria, int indexAluno);
    
    public void removerFalta(int indexMateria, int indexAluno);
    
    public float verNota(int indexMateria, int indexAluno);
    
    public int verFalta(int indexMateria, int indexAluno);
    
}
