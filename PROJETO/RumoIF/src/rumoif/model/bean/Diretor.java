
package rumoif.model.bean;

public class Diretor extends Usuario{   
    //Herança simples
    
    public Diretor(String Usuario, String senha) {
        super(Usuario, senha);
        this.setNivel(2);
    }
    
}
