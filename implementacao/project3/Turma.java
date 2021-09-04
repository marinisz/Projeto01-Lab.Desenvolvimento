import Model.Aluno;
import Model.Disciplina;
import Model.Professor;

import java.io.Serializable;

public class Turma implements Serializable{
    private String id;
    private Disciplina disciplina;
    private Professor professor;
    private Aluno[] alunos;
    private static final int QTD_MAXIMA;
    private static final int QTD_MINIMA;
    private int qtdAlunos;

    static {
        QTD_MAXIMA = 60;
        QTD_MINIMA = 3;
    }

    //Construtor
    public Turma(Disciplina disciplina, Professor professor) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new Aluno[QTD_MAXIMA];
        this.qtdAlunos = 0;
    }

    //getter and setters

    public void addAluno(Aluno aluno) {
        this.alunos[qtdAlunos] = aluno;
        this.qtdAlunos += 1;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public void imprimirAlunos() {
        for (Aluno aluno : this.alunos) {
            System.out.println(aluno);
        }
    }
}
