package br.eti.clairton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.eti.clairton.Usuario.Tipo;

public class Permissao {    
    private static final Map<Tipo, Permissao> PERMISSOES = new HashMap<Tipo, Permissao>();
    private final Map<Class<?>, List<String>> metodos;
    
    private Permissao(Map<Class<?>, List<String>> metodos) {
        super();
        this.metodos = metodos;
    }
    
    private List<String> getMetodos(Class<?> klazz) {
        return metodos.get(klazz);
    }
    
    public static void validar(Class<?> klazz, final String metodo) throws UsuarioNaoAutorizadoException{
        final Tipo tipo = Sessao.getInstance().getUsuario().getTipo();
        final List<String> metodos = PERMISSOES.get(tipo).getMetodos(klazz); 
        if (!metodos.contains(metodo)) {
            throw new UsuarioNaoAutorizadoException();
        }
    }
    
    static{
        final Map<Class<?>, List<String>> professor = new HashMap<Class<?>, List<String>>();
        professor.put(BoletimImpl.class, Arrays.asList("avaliar", "reavaliar", "imprimir"));
        PERMISSOES.put(Tipo.PROFESSOR, new Permissao(professor));
        final Map<Class<?>, List<String>> aluno = new HashMap<Class<?>, List<String>>();
        aluno.put(BoletimImpl.class, Arrays.asList("imprimir"));
        PERMISSOES.put(Tipo.ALUNO, new Permissao(aluno));
    }
}
