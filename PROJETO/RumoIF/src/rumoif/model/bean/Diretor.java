/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean;

/**
 *
 * @author Caio Rievers
 */
public class Diretor extends Usuario{ //Herança simples
    
    public Diretor(String Usuario, String senha) {
        super(Usuario, senha);
        this.setNivel(2);
    }
    
}
