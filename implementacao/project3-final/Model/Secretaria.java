package Model;

import java.util.Date;

import Utils.Pessoa;
import interfaces.Gerenciavel;

public class Secretaria extends Usuario {

    public Secretaria(Pessoa pessoa) {
        super(pessoa);
    }

    //metodos
    public void gerarCurriculo(Date dataIni, Date dataFin, String cursoNome) {
        Sistema sistema = Sistema.getInstance();
        Curriculo curriculo = new Curriculo(dataIni, dataFin);
        try {
            Curso curso = sistema.buscarCursoPeloNome(cursoNome);
            curso.setCurriculo(curriculo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cadastrarAluno(Pessoa pessoa, String cursoNome) {
        Sistema sistema = Sistema.getInstance();
        try {
            Curso curso = sistema.buscarCursoPeloNome(cursoNome);
            Aluno aluno = new Aluno(pessoa, curso);
            sistema.cadastrarUsuario(aluno);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cadastrarProfessor(Pessoa pessoa) {
        Sistema sistema = Sistema.getInstance();
        try {
            Professor professor = new Professor(pessoa);
            sistema.cadastrarUsuario(professor);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cadastrarSecretaria() {
        Sistema sistema = Sistema.getInstance();
        try {
            sistema.cadastrarUsuario(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removerUsuario(int matricula) {
        Sistema sistema = Sistema.getInstance();
        try {
            Usuario usuario = sistema.buscarUsuarioPelaMatricula(matricula);
            sistema.removerUsuario(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cadastrarCurso(String nome, int creditos) {
        Sistema sistema = Sistema.getInstance();
        try {
            Curso curso = new Curso(nome, creditos);
            sistema.cadastrarCurso(curso);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void criarDisciplina(Disciplina disciplina, String cursoNome){
        Sistema sistema = Sistema.getInstance();
        try {
            Curso curso = sistema.buscarCursoPeloNome(cursoNome);
            Gerenciavel curriculo = curso.getCurriculo();
            curriculo.addDisciplina(disciplina);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removerDisciplina(String discNome, String cursoNome) {
        Sistema sistema = Sistema.getInstance();
        try {
            Curso curso = sistema.buscarCursoPeloNome(cursoNome);
            Gerenciavel curriculo = curso.getCurriculo();
            curriculo.removerDisciplina(discNome);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listarCurso() {
        Sistema sistema = Sistema.getInstance();
        try {
            sistema.listarCurso();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removerCurso(String discNome) {
        Sistema sistema = Sistema.getInstance();
        try {
            Curso usuario = sistema.buscarCursoPeloNome(discNome);
            sistema.removerCurso(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
