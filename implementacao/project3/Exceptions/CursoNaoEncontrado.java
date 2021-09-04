package Exceptions;

public class CursoNaoEncontrado extends Exception {
    CursoNaoEncontrado(String nome) {
        super("Curso " + nome + " não encontrado.");
    }
}
