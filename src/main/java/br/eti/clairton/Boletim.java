package br.eti.clairton;

public interface Boletim extends Proxyable{
    void avaliar(Aluno aluno, Materia materia, Double nota) throws UsuarioNaoAutorizadoException;
    
    void reavaliar(Aluno aluno, Materia materia, Double nota) throws UsuarioNaoAutorizadoException;
    
    void imprimir(Aluno aluno) throws UsuarioNaoAutorizadoException;
}