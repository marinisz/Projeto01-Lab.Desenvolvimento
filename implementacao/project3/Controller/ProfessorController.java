package Controller;

import Model.Professor;
import Model.Sistema;
import View.View;

public class ProfessorController {
    public static void listarAlunosPorDisciplina() {
        Professor professor = (Professor) Sistema.getInstance().getUsuarioAtual();

        try {
            String discNome = View.nomeForm("Digite o nome da disciplina");
            professor.listarAlunosPorDisciplina(discNome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
