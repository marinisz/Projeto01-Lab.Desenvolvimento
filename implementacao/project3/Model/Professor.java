package Model;

import Exceptions.DisciplinaNaoEncontradaException;
import Utils.Pessoa;
import interfaces.Visualizavel;

public class Professor extends Usuario {
    public Professor(Pessoa pessoa) {
        super(pessoa);
    }

    //metodos
    public void listarAlunosPorDisciplina(String discNome) {
        Visualizavel curriculo = Sistema.getInstance().getCurriculo();
        try {
            curriculo.listarAlunosPorDisciplina(discNome);
        } catch (DisciplinaNaoEncontradaException e) {
            System.err.println(e);
        }
    }
}
