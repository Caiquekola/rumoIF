package rumoif.model.bean;
public class Usuario {
    
    private int Usuario;
    private String email;
    private String senha;
    private String nome;
    public Usuario(int Usuario, String senha){
        this.Usuario = Usuario;
        this.senha = senha;
    }
    public Usuario(int Usuario, String senha, String nome, String email){
        this.Usuario = Usuario;
        this.senha = senha;
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

    public int getUsuario() {
        return Usuario;
    }

    public void setUsuario(int Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
