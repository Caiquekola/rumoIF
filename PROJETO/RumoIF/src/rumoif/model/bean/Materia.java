/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rumoif.model.bean;


public class Materia { //Base para a identificação no banco de dados
    private int id_materia;
    private String nome_materia;
    
    //Usado no read
    public Materia(String nome, int id_materia){ //Sobrecarga de método
        this.nome_materia = nome;
        this.id_materia = id_materia;
    }
    
    //criação de materia e obtenção só com o nome
    public Materia(String nome){
        this.nome_materia = nome;
    }
    
    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    
    public String getNome_materia() {
        return nome_materia;
    }

    public void setNome_materia(String nome_materia) {
        this.nome_materia = nome_materia;
    }
    
    
}
