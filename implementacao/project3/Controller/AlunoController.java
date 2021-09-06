package Controller;

import Model.Aluno;
import Model.Sistema;
import View.View;

public class AlunoController {
    public static void matricular() {
        Aluno aluno = (Aluno) Sistema.getInstance().getUsuarioAtual();

        try {
            String discNome = View.nomeForm("Digite o nome da disciplina: ");
            aluno.matricularDisciplina(discNome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void cancelar() {
        Aluno aluno = (Aluno) Sistema.getInstance().getUsuarioAtual();

        try {
            String discNome = View.nomeForm("Digite o nome da disciplina: ");
            aluno.cancelarDisciplina(discNome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
