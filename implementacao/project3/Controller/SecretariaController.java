package Controller;

import java.util.Date;

import Model.*;
import Utils.Pessoa;
import View.View;

public class SecretariaController {
    public static void cadastrarUsuario() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        try {
            Pessoa pessoa = View.pessoaForm();
            String tipo = View.tipoForm();

            if (tipo.equals("1")) {
                String curso = View.nomeForm("Digite o nome do curso: ");
                secretaria.cadastrarAluno(pessoa, curso);
            } else
                secretaria.cadastrarProfessor(pessoa);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void listarUsuario() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        try {
            secretaria.listarUsuario();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void removerUsuario() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        try {
            int matricula = View.intForm("Digite a matricula: \n");

            secretaria.removerUsuario(matricula);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void removerCurso() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        try {
            String nome = View.nomeForm("Digite o nome do curso: ");

            secretaria.removerCurso(nome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void cadastrarCurso() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();

        try {
            String nome = View.nomeForm("Digite o nome do curso: ");

            int creditos = View.intForm("Digite a quantidade de creditos: ");

            secretaria.cadastrarCurso(nome, creditos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void listarCurso() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        try {
            secretaria.listarCurso();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void cadastrarCurriculo() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        try {
            Date dateIni = View.dateForm("Digite a data de abertura da matricula");
            Date dateFin = View.dateForm("Digite a data de termino da matricula");
            String curso = View.nomeForm("Digite o nome do curso a qual o curriculo se refere: ");

            secretaria.gerarCurriculo(dateIni, dateFin, curso);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void addDisciplinaNoCurriculo() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        boolean opcional = false;
        try {
            String disc = View.nomeForm("Digite o nome da disciplina: ");
            Double valor = View.doubleForm("Digite o valor da disciplina: ");
            String opcionalStr = (View.nomeForm("Disciplina eh opcional? ")).toLowerCase();
            String curso = View.nomeForm("Digite o nome do curso: ");

            if (opcionalStr.equals("sim".toLowerCase()))
                opcional = true;

            secretaria.criarDisciplina(new Disciplina(disc, valor, opcional), curso);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void removerDisciplinaNoCurriculo() {
        Secretaria secretaria = (Secretaria) Sistema.getInstance().getUsuarioAtual();
        try {
            String disc = View.nomeForm("Digite o nome da disciplina: ");
            String curso = View.nomeForm("Digite o nome do curso: ");
            secretaria.removerDisciplina(disc, curso);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
