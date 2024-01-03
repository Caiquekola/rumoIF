package rumoif.model.bean;
public abstract class  Usuario {
    
    private String Usuario;
    private String email;
    private String senha;
    private String nome;
    
    //Login
    public Usuario(String Usuario, String senha){
        this.Usuario = Usuario;
        this.senha = senha;
    }
    //Visitante Completo
    public Usuario(String nome,String email,String usuario, String senha){
        this.Usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }
    //Deletar Usuario
    public Usuario(String nome,String email,String usuario){
        this.Usuario = usuario;
        this.nome = nome;
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
