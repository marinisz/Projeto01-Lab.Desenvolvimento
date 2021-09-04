package Controller;

import Model.Aluno;
import Model.Curso;
import Model.Professor;
import Model.SistemaModel;

public class SecretariaController {
    public void cadastrarUsuario(String nome, String senha, String dataNascimento, String cursoNome) {
        SistemaModel sistema = SistemaModel.getInstance();
        try {
            Curso curso = sistema.buscarPeloNome(cursoNome);
            Aluno aluno = new Aluno(nome, senha, dataNascimento, curso);
            sistema.cadastrarUsuario(aluno);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cadastrarUsuario(String nome, String senha, String dataNascimento) {
        SistemaModel sistema = SistemaModel.getInstance();
        try {
            Professor professor = new Professor(nome, senha, dataNascimento);
            sistema.cadastrarUsuario(professor);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listarUsuarios() {
        SistemaModel sistema = SistemaModel.getInstance();
        try {
            sistema.listarUsuarios();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cadastrarCurso(String nome, int creditos) {
        SistemaModel sistema = SistemaModel.getInstance();
        try {
            Curso curso = new Curso(nome, creditos);
            sistema.cadastrarCurso(curso);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listarCurso() {
        SistemaModel sistema = SistemaModel.getInstance();
        try {
            sistema.listarCurso();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
