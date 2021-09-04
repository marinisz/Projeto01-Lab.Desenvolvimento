package View;

import Controller.SecretariaController;
import Controller.UsuarioController;

public class SecretariaViewer extends UsuarioViewer {
    @Override
    public int menu() {
        System.out.println("____________Menu Secretaria____________");
        System.out.println("1 - Cadastrar Usuario");
        System.out.println("2 - Listar usuarios");
        System.out.println("3 - Cadastrar curso");
        System.out.println("4 - Listar cursos");
        System.out.println("0 - Logout");
        System.out.print("Opção: ");

        return Viewer.tratarOpcao();
    }

    public void cadastrarUsuario() {
        SecretariaController controller = new SecretariaController();
        System.out.print("Digite um nome: \n");
        String nome = teclado.nextLine();

        System.out.print("\nDigite uma senha: \n");
        String senha = teclado.nextLine();

        System.out.print("\nInforme a data de nascimento (dia-mes-ano): \n");
        String dataNascimento = teclado.nextLine();

        System.out.println("Tipo de usuario:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");

        String tipo = teclado.nextLine();

        if(tipo.equals("1")) {
            System.out.print("Digite o nome do curso: ");
            String curso = teclado.nextLine();
            controller.cadastrarUsuario(nome, senha, dataNascimento, curso);
        }
        else controller.cadastrarUsuario(nome, senha, dataNascimento);
    }

    public void listarUsuario() {
        SecretariaController controller = new SecretariaController();
        try {
            controller.listarUsuarios();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cadastrarCurso() {
        SecretariaController controller = new SecretariaController();

        try {
            System.out.print("Digite nome: ");
            String nome = teclado.nextLine();

            System.out.print("Digite a quantidade de creditos: ");
            int creditos = Integer.parseInt(teclado.nextLine());

            controller.cadastrarCurso(nome, creditos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listarCursos() {
        SecretariaController controller = new SecretariaController();
        controller.listarCurso();
    }
}
