import Model.*;
import View.*;

import java.util.*;

public class App {

  static void pausa(Scanner teclado) {
    System.out.println("Enter para continuar.");
    teclado.nextLine();
  }

  public static void alunoRouter() {
    AlunoViewer viewer = new AlunoViewer();
    int opcao = viewer.menu();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          System.out.println("Matricular Disciplina");
          break;
        case 2:
          System.out.println("Cancelar Disciplina");
          break;
      }
      opcao = viewer.menu();
    }
  }

  public static void professorRouter() {
    ProfessorViewer viewer = new ProfessorViewer();
    int opcao = viewer.menu();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          System.out.println("Teste");
          break;
      }
      opcao = viewer.menu();
    }
  }

  public static void secretariaRouter() {
    SecretariaViewer viewer = new SecretariaViewer();
    int opcao = viewer.menu();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
        case 2:
          viewer.listarUsuario();
          break;
        case 3:
          viewer.cadastrarCurso();
          break;
        case 4:
          viewer.listarCursos();
          break;
      }
      opcao = viewer.menu();
    }
  }

  public static void logarRoute() {
    LogarViewer viewer = new LogarViewer();
    Usuario usuario = viewer.logar();
    if (usuario instanceof Professor)
      professorRouter();
    if(usuario instanceof Aluno)
      alunoRouter();
    if(usuario instanceof Secretaria)
      secretariaRouter();
  }

  public static void usuarioRouter() {
    UsuarioViewer viewer = new UsuarioViewer();
    int opcao = viewer.menu();

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          logarRoute();
          break;
        case 2:
          viewer.cadastrarSecretaria();
          break;
      }
        opcao = viewer.menu();
      }
    }

  public static void main(String[] args) {
    usuarioRouter();
  }
}