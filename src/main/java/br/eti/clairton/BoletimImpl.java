package br.eti.clairton;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BoletimImpl implements Boletim{
    private static final long serialVersionUID = 1L;
    private Map<Aluno, Map<Materia, Double>> boletins = new HashMap<Aluno, Map<Materia, Double>>();
    
    /**
     * {@inheritDoc}
     */
    public void avaliar(Aluno aluno, Materia materia, Double nota) throws UsuarioNaoAutorizadoException {
        put(aluno, materia, nota);
    }
    
    /**
     * {@inheritDoc}
     */
    public void reavaliar(Aluno aluno, Materia materia, Double nota) throws UsuarioNaoAutorizadoException {
        put(aluno, materia, nota);
    }
    
    /**
     * {@inheritDoc}
     */
    public void imprimir(Aluno aluno) throws UsuarioNaoAutorizadoException {
        for (Entry<Materia, Double> entry : boletins.get(aluno).entrySet()) {
            System.out.println("Materia: " + entry.getKey() + ", nota: " + entry.getValue());
        }
    }
    
    private void put(Aluno aluno, Materia materia, Double nota) {
        final Map<Materia, Double> materias;
        if (boletins.containsKey(aluno)) {
            materias = boletins.get(aluno);
        } else {
            materias = new HashMap<Materia, Double>();
        }
        materias.put(materia, nota);
        boletins.put(aluno, materias);
    }
}
