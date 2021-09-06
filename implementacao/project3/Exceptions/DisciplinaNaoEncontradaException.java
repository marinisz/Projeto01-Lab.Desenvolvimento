package Exceptions;

public class DisciplinaNaoEncontradaException extends Exception {
    public DisciplinaNaoEncontradaException(String nome) {
        super("Nao encontramos a disciplina: "+nome);
   }
}
