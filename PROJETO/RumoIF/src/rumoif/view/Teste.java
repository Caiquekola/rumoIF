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
       Materia m = new Materia("Português");
       m.setId_materia(1);
       AlunoMateria aM = new AlunoMateria(a,m);
       AlunoDAO adao = new AlunoDAO();
       AlunoDAO.create(a);
       AlunoMateriaDAO dao = new AlunoMateriaDAO();
       dao.create(aM);
    }
    
}
