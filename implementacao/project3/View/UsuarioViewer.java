package View;

import Controller.UsuarioController;
import Utils.Data;

public class UsuarioViewer extends Viewer {
    @Override
    public int menu() {
        System.out.println("____________Menu Usuario____________");
        System.out.println("1 - Logar");
        System.out.println("2 - Cadastrar Secretaria");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");

        return Viewer.tratarOpcao();
    }

    public void cadastrarSecretaria() {
        UsuarioController controller = new UsuarioController();

        try {
            System.out.print("Digite um nome: \n");
            String nome = teclado.nextLine();

            System.out.print("Digite uma senha: \n");
            String senha = teclado.nextLine();

            System.out.print("Informe a data de nascimento (dia-mes-ano): \n");
            String dataNascimento = Data.validarData(teclado.nextLine());

            controller.cadastrarUsuario(nome, senha, dataNascimento);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
