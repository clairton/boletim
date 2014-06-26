package br.eti.clairton;

public class Aluno extends Usuario {
    public Aluno() {
        super(Tipo.ALUNO);
    }
    
    @Override
    public Tipo getTipo() {
        return super.getTipo();
    }
}
