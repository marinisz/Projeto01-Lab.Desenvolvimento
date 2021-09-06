package Model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Exceptions.CapacidadeMaxDeAlunosExcedida;
import Utils.DisciplinaEnum;

public class Disciplina implements Serializable {
    public static final int QTD_MAXIMA = 60;
    public static final int QTD_MINIMA = 3;

    private String nome;
    private Set<Aluno> alunos = new HashSet<>();
    private Professor professor;
    private boolean opcional;
    private int qtdHoras;
    private DisciplinaEnum situacao;
    private Double valor;

    public Disciplina(String nome, Double valor, boolean opcional) {
        this.nome = nome;
        this.valor = valor;
        this.opcional = opcional;
        this.situacao = DisciplinaEnum.ATIVA;

    }

    public Disciplina(String nome, Double valor, boolean opcional, Professor professor) {
        this(nome, valor, opcional);
        this.professor = professor;
    }

    public boolean addAluno(Aluno aluno) throws CapacidadeMaxDeAlunosExcedida {
        if(this.alunos.size() >= QTD_MAXIMA)
            throw new CapacidadeMaxDeAlunosExcedida();
        else
            return this.alunos.add(aluno);
    }

    public boolean removerAluno(Aluno aluno) {
        return this.alunos.remove(aluno);
    }

    public void listar() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(this.alunos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    public boolean isOpcional() {
        return opcional;
    }

    public DisciplinaEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(DisciplinaEnum situacao) {
        this.situacao = situacao;
    }

    public void semestreFechado() {
        Fatura fatura = new Fatura(new Date(), this.valor, this);
        for (Aluno aluno : alunos) {
            aluno.receberFatura(fatura);
        }
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nome: " + nome +
                "\n\tQuantidade de horas: " + qtdHoras +
                "\n\tProfessor: " + professor +
                "\n\tAlunos: " + alunos +
                "\n\tQuantidade de alunos: " + alunos.size();
    }
}
