package br.eti.clairton;

public class UsuarioNaoLogadoExeption extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public UsuarioNaoLogadoExeption() {
        super("Chame o Metodo Sessao#logar(usuario)");
    }
}
