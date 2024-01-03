/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rumoif.view;

import rumoif.model.bean.Aluno;
import rumoif.model.bean.AlunoMateria;
import rumoif.model.bean.Materia;
import rumoif.model.dao.AlunoDAO;
import rumoif.model.dao.AlunoMateriaDAO;


public class Teste {

    public static void main(String[] args) {
       Aluno a = new Aluno("nome","email","user");
       Materia m = new Materia("Matematica");
       m.setId_materia(99);
       AlunoMateria aM = new AlunoMateria(a,m);
       AlunoMateriaDAO dao = new AlunoMateriaDAO();
       dao.create(aM);
    }
    
}
