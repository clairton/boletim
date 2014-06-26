package br.eti.clairton;

public abstract class Usuario {
    public enum Tipo {
        PROFESSOR,
        ALUNO
    }
    
    private final Tipo tipo;
    
    public Usuario(Tipo tipo) {
        super();
        this.tipo = tipo;
    }
    
    public Tipo getTipo() {
        return tipo;
    }
}
