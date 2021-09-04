package View;

import Model.Usuario;
import Services.Autenticacao;

public class LogarViewer extends Viewer {
    @Override
    public int menu() {
        System.out.println("____________Menu Autenticacao____________");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");
        return Viewer.tratarOpcao();
    }

    public Usuario logar() {
        Autenticacao autenticacao = new Autenticacao();
        Usuario usuario = null;
        try {
            System.out.print("Digite a matricula: \n");
            int matricula = Integer.parseInt(teclado.nextLine());

            System.out.print("Digite uma senha: \n");
            String senha = teclado.nextLine();

            usuario = autenticacao.logar(matricula, senha);
        } catch (Exception e) {
            System.out.println(e);
        }

        return usuario;
    }
}
