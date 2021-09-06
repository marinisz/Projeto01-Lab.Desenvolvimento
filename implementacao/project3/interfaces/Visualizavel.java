package interfaces;

import Exceptions.DisciplinaNaoEncontradaException;

public interface Visualizavel {
    public void listarAlunosPorDisciplina(String nomeDisc) throws DisciplinaNaoEncontradaException;
}
