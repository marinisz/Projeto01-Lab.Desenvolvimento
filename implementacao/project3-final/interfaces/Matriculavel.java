package interfaces;

import Exceptions.DisciplinaNaoEncontradaException;
import Exceptions.DisciplinasExcedidas;
import Exceptions.ForaDaEpocaDeMatriculaException;
import Model.Aluno;

public interface Matriculavel {
    public boolean matricular(String nomeDisc, Aluno aluno) throws ForaDaEpocaDeMatriculaException, DisciplinaNaoEncontradaException, DisciplinasExcedidas;
    public boolean cancelarMatricula(String nomeDisc, Aluno aluno) throws ForaDaEpocaDeMatriculaException, DisciplinaNaoEncontradaException;
}
