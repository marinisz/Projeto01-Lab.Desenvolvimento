package Controller;

import Model.Sistema;
import Model.Usuario;
import Services.Autenticacao;
import View.View;

public class LoginController {

    public static Usuario login() {
        Autenticacao autenticacao = new Autenticacao();
        Usuario usuario = null;
        try {
            int matricula = View.intForm("Digite a matricula: ");
            String senha = View.nomeForm("Digite uma senha: ");

            usuario = autenticacao.login(matricula, senha);
        } catch (Exception e) {
            System.out.println(e);
        }

        Sistema.getInstance().setUsuarioAtual(usuario);
        return usuario;
    }
}
