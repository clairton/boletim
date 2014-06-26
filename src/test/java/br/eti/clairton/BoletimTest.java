package br.eti.clairton;

import org.junit.Before;
import org.junit.Test;

public class BoletimTest {
    private Boletim boletim;
    
    private Aluno usuario;
    
    private Double nota = 10d;
    
    @Before
    public void iniciar() {
        Container.getInstance().addBean(BoletimImpl.class);
        boletim = Container.getInstance().getBean(Boletim.class);
        usuario = new Aluno();
        Sessao.logar(usuario);
    }
    
    @Test(expected = UsuarioNaoAutorizadoException.class)
    public void testAdd() throws UsuarioNaoAutorizadoException {
        boletim.avaliar(usuario, Materia.MATEMATICA, nota);
    }
}
