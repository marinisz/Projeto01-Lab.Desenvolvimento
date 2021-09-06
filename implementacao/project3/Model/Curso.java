package Model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import Exceptions.ObjetoNaoEncontrado;

public class Curso implements Serializable {
    private Set<Disciplina> disciplinas;
    private Curriculo curriculo;
    private String nome;
    private int numCreditos;

    // Construtor

    public Curso(String nome, int numCreditos) {
        this.disciplinas = new HashSet<>();
        this.nome = nome;
        this.numCreditos = numCreditos;
    }

    public Disciplina buscarDisciplinaPeloNome(String nome) throws ObjetoNaoEncontrado {
        Optional<Disciplina> disciplinaOpt = disciplinas.stream()
                .filter(disciplina -> disciplina.getNome().equals(nome)).findAny();

        if (disciplinaOpt.isPresent())
            return disciplinaOpt.get();
        else
            throw new ObjetoNaoEncontrado("Disciplina", nome);
    }

    public Set<Disciplina> getDisciplinas() {
        return Collections.unmodifiableSet(this.disciplinas);
    }

    public void removerDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
        Sistema.getInstance().atualizarCurso();
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        Sistema.getInstance().atualizarCurso();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        Sistema.getInstance().atualizarCurso();
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
        Sistema.getInstance().atualizarCurso();
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
        Sistema.getInstance().atualizarCurso();
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    @Override
    public String toString() {
        return "Curso= " + nome + 
            "\nDisciplinas=" + disciplinas +
            "\nNumCreditos=" + numCreditos +
            "\nCurriculo: " + curriculo;
    }
}
