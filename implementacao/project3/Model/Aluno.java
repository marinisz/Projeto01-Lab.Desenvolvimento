package Model;

import java.util.ArrayList;
import Utils.Pessoa;
import interfaces.Matriculavel;

public class Aluno extends Usuario {
    private Curso curso;
    private int DisciplinasObrigatorias = 0;
    private int DisciplinasOpcionais = 0;
    private ArrayList<Fatura> faturas;

    // Construtor
    public Aluno(Pessoa pessoa, Curso curso) {
        super(pessoa);
        this.curso = curso;
        this.faturas = new ArrayList<>();
    }

    // getter and setter
    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void matricularDisciplina(String discNome) {
        Matriculavel curriculo = this.curso.getCurriculo();

        if (curriculo == null) {
            System.out.println("Nao ha curriculo para matricular disciplina");
        } else {
            try {
                curriculo.matricular(discNome, this);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public void cancelarDisciplina(String discNome) {
        Matriculavel curriculo = this.curso.getCurriculo();

        if (curriculo == null) {
            System.out.println("Nao ha curriculo para cancelar disciplina");
        } else {
            try {
                curriculo.cancelarMatricula(discNome, this);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public void addObrigatoria() {
        this.DisciplinasObrigatorias++;
    }

    public int getDisciplinasObrigatorias() {
        return this.DisciplinasObrigatorias;
    }

    public void addOpcional() {
        this.DisciplinasOpcionais++;
    }

    public int getDisciplinasOpcionais() {
        return this.DisciplinasOpcionais;
    }

    public void receberFatura(Fatura fatura) {
        this.faturas.add(fatura);
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t" + this.curso;
    }
}
