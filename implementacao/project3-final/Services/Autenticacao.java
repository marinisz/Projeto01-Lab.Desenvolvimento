package Services;

import Exceptions.FalhaNoLogin;
import Model.Sistema;
import Model.Usuario;

public class Autenticacao {

    public Usuario login(int matricula, String senha) {
        Usuario usuario = null;
        Sistema sistemaModel = Sistema.getInstance();
        try {
            usuario = sistemaModel.buscarUsuarioPelaMatricula(matricula);

            if (!verificarSenha(usuario.getPessoa().getSenha(), senha)) {
                throw new FalhaNoLogin();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return usuario;
    }

    public static boolean verificarSenha(String senha1, String senha2) {
        return senha1.equals(senha2);
    }

}
