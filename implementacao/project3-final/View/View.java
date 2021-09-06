package View;

import Utils.Data;
import Utils.Pessoa;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class View {
    protected static final Scanner teclado = new Scanner(System.in);
    private static View instance;

    private View() {
    }

    public static View getInstance() {
        if (instance == null) {
            return instance = new View();
        } else
            return instance;
    }

    public static Pessoa pessoaForm() throws Exception {
        System.out.print("Digite um nome: \n");
        String nome = teclado.nextLine();

        System.out.print("Digite uma senha: \n");
        String senha = teclado.nextLine();

        System.out.print("Informe a data de nascimento (dia-mes-ano): \n");
        String dataNascimento = Data.validarData(teclado.nextLine());

        return new Pessoa(nome, senha, dataNascimento);
    }

    public static String nomeForm(String message) throws Exception {
        System.out.print(message);
        String nome = teclado.nextLine();

        return nome;
    }

    public static Date dateForm(String message) throws Exception {
        Calendar date = Calendar.getInstance();
        System.out.print(message + " - dia-mes-ano (01-03-1900): \n");
        String dateString = teclado.nextLine();
        String[] dateArr = dateString.split("-");
        date.set(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1]) - 1, Integer.parseInt(dateArr[0]));

        return date.getTime();
    }

    public static int intForm(String message) throws Exception {
        System.out.print(message);
        String numero = teclado.nextLine();

        return Integer.parseInt(numero);
    }

    public static Double doubleForm(String message) throws Exception {
        System.out.print(message);
        String numero = teclado.nextLine();

        return Double.parseDouble(numero);
    }

    public static String tipoForm() throws Exception {
        System.out.println("Tipo de usuario:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");

        return teclado.nextLine();
    }

    protected static int tratarOpcao() {
        int opcao = 0;
        try {
            opcao = teclado.nextInt();
        } catch (Exception exception) {
            System.out.println("Favor inserir valor válido!");
            opcao = tratarOpcao();
        }
        teclado.nextLine();
        return opcao;
    }

    public int renderHome() {
        System.out.println("____________Home____________");
        System.out.println("1 - Logar");
        System.out.println("2 - Listar usuarios");
        System.out.println("3 - Cadastrar Secretaria");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }

    public int renderUsuario() {
        System.out.println("____________Menu Usuario____________");
        System.out.println("1 - Cadastrar Usuario");
        System.out.println("2 - Listar usuarios");
        System.out.println("3 - Remover Usuario");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }

    public int renderAluno() {
        System.out.println("____________Menu Aluno____________");
        System.out.println("1 - Matricular disciplina");
        System.out.println("2 - Cancelar disciplina");
        System.out.println("0 - Logout");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }

    public int renderProfessor() {
        System.out.println("____________Menu Professor____________");
        System.out.println("1 - Imprimir alunos na disciplina");
        System.out.println("0 - Logout");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }

    public int renderSecretaria() {
        System.out.println("____________Menu Secretaria____________");
        System.out.println("1 - Menu Usuario");
        System.out.println("2 - Menu curso");
        System.out.println("3 - Menu Curriculo");
        System.out.println("0 - Logout");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }

    public int renderLogin() {
        System.out.println("____________Menu Autenticacao____________");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }

    public int renderCurso() {
        System.out.println("____________Menu Curso____________");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Remover");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }

    public int renderCurriculo() {
        System.out.println("____________Menu Curriculo____________");
        System.out.println("1 - Gerar curriculo");
        System.out.println("2 - Adicionar disciplina");
        System.out.println("3 - Remover disciplina curso");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");

        return View.tratarOpcao();
    }
}
