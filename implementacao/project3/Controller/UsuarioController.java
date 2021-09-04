package Controller;

import Model.*;

public class UsuarioController {
    public void cadastrarUsuario(String nome, String senha, String dataNascimento) {
        SistemaModel sistema = SistemaModel.getInstance();
        try {
            Secretaria secretaria = new Secretaria(nome, senha, dataNascimento);
            sistema.cadastrarUsuario(secretaria);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
