package Model;

import java.io.Serializable;

public class Disciplina implements Serializable {
    private static final int QTD_MAXIMA = 60;
    private static final int QTD_MINIMA = 3;
    private static int QTD_DISCIPLINA = 0;
    private Professor professor;
    private Aluno[] alunos;
    private int qtdHoras;
    private boolean opcional;
    private String nome;

    //Constutor
    public Disciplina(int qtdHoras, String nome, boolean opcional) {
        this.qtdHoras = qtdHoras;
        this.opcional = opcional;
        this.nome = nome;
    }

    //getter and setters
    public int getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public boolean isOpcional() {
        return opcional;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Nome: "+this.getNome()+"\n Quantidade de horas: "+this.getQtdHoras()+"\n Opcional"+this.isOpcional();
    }
}
