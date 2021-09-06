package Controller;

import Model.*;
import Utils.Pessoa;
import View.View;

public class UsuarioController {
    public static void listarUsuario() {
        Sistema sistema = Sistema.getInstance();
        try {
            sistema.listarUsuarios();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void cadastrarSecretaria() {
        Secretaria secretaria = null;
        try {
            Pessoa pessoa = View.pessoaForm();
            secretaria = new Secretaria(pessoa);

            secretaria.cadastrarSecretaria();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
