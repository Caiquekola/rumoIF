package rumoif.model.bean;
public class Usuario {
    
    private String Usuario;
    private String email;
    private String senha;
    private String nome;
    private int nivel;
    
    public Usuario(String Usuario, String senha){
        this.Usuario = Usuario;
        this.senha = senha;
    }
    public Usuario(String nome,String email,String senha, String usuario, int nivel){
        this.Usuario = Usuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.nivel = nivel;
    }
    public Usuario(String nome,String email,String senha, String usuario){
        this.Usuario = Usuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.nivel = 0;
    }
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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
