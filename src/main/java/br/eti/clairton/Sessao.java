package br.eti.clairton;

public class Sessao {
    private Usuario usuario;
    
    private static Sessao instance;
    
    private Sessao(Usuario usuario) {
        super();
        this.usuario = usuario;
    }
    
    public static Sessao getInstance() {
        if (instance == null) {
            throw new UsuarioNaoLogadoExeption();
        }
        return instance;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    
    public static void logar(Usuario usuario){
        instance = new Sessao(usuario);
    }
}
