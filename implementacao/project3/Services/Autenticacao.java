package Services;

import Exceptions.FalhaNoLogin;
import Model.SistemaModel;
import Model.Usuario;

public class Autenticacao {

    public Usuario logar(int matricula, String senha) {
        Usuario usuario = null;
        SistemaModel sistemaModel = SistemaModel.getInstance();
        try {
            usuario = sistemaModel.buscarPelaMatricula(matricula);

            if (!verificarSenha(usuario.getSenha(), senha)) {
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
