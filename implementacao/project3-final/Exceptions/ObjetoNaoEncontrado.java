package Exceptions;

public class ObjetoNaoEncontrado extends Exception {
    public ObjetoNaoEncontrado(String nome, int valor) {
        super(nome + " com o valor " + valor + " não encontrado.");
    }

    public ObjetoNaoEncontrado(String nome, String valor) {
        super(nome + " com o valor " + valor + " não encontrado.");
    }
}
