package rumoif.model.bean;


public class Professor extends Usuario{ 
    //Herança simples
    //CRIAR PROFESSOR
    public Professor(String nome, String email, String usuario, String senha) {
        super(nome, email, usuario, senha);
        this.setNivel(1);
    }
    //REMOVER PROFESSOR - DIRETOR
    public Professor(String nome,String email,String usuario){
        super(nome,email,usuario);
        this.setNivel(1);
    }
    //PASSAR PROFESSOR PARA INTERFACE DE PROFESSOR APENAS COM USUARIO E LOGIN
    public Professor(String usuario, String senha){
        super(usuario,senha);
        this.setNivel(1);
    }
}
