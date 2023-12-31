/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rumoif.model.bean.Escola;

/**
 *
 * @author Caio Rievers
 */
public class Guarda implements Punir{
    public void abreEscola(){
        System.out.println("Escola aberta!");
    }

    @Override
    public void darAdvertencia(Aluno aluno) {
        aluno.darAdvertencia();
    }

    @Override
    public void expulsar(Aluno aluno) {
        aluno.setExpulso(true);
    }
}
