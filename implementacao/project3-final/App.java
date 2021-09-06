import Controller.*;
import Model.*;
import View.*;

public class App {
  private static View view;

  private static void alunoRouter() {
    int opcao = view.renderAluno();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          AlunoController.matricular();
          break;
        case 2:
          AlunoController.cancelar();
          break;
      }
      opcao = view.renderAluno();
    }
  }

  public static void professorRouter() {
    int opcao = view.renderProfessor();
    while (opcao != 0) {
      switch (opcao) {
        case 1:
          ProfessorController.listarAlunosPorDisciplina();
          break;
      }
      opcao = view.renderProfessor();
    }
  }

  public static void cursoRouter() {
    int opcao = view.renderCurso();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          SecretariaController.cadastrarCurso();
        case 2:
          SecretariaController.listarCurso();
          break;
        case 3:
          SecretariaController.removerCurso();
          break;
      }
      opcao = view.renderCurso();
    }
  }

  public static void usuarioRouter() {
    int opcao = view.renderUsuario();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          SecretariaController.cadastrarUsuario();
        case 2:
          SecretariaController.listarUsuario();
          break;
        case 3:
          SecretariaController.removerUsuario();
          break;
      }
      opcao = view.renderUsuario();
    }
  }

  public static void curriculoRouter() {
    int opcao = view.renderCurriculo();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          SecretariaController.cadastrarCurriculo();
          break;
        case 2:
          SecretariaController.addDisciplinaNoCurriculo();
          break;
        case 3:
          SecretariaController.removerDisciplinaNoCurriculo();
          break;
      }
      opcao = view.renderCurriculo();
    }
  }

  public static void secretariaRouter() {
    int opcao = view.renderSecretaria();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          usuarioRouter();
          break;
        case 2:
          cursoRouter();
          break;
        case 3:
          curriculoRouter();
          break;

      }
      opcao = view.renderSecretaria();
    }
  }

  public static void home() {
    int opcao = view.renderHome();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          Usuario usuario = LoginController.login();
          if (usuario instanceof Professor)
            professorRouter();
          if (usuario instanceof Aluno)
            alunoRouter();
          if (usuario instanceof Secretaria)
            secretariaRouter();
          break;
        case 2:
          UsuarioController.listarUsuario();
          break;
        case 3:
          UsuarioController.cadastrarSecretaria();
          break;
      }
      opcao = view.renderHome();
    }
  }

  public static void main(String[] args) {
    view = View.getInstance();
    home();
  }
}