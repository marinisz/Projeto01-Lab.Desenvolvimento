package Exceptions;

public class ObjetoNaoEncontrado extends Exception {
    public ObjetoNaoEncontrado(int valor){
        super("Objeto com o valor " + valor + " não encontrado.");
    }
    public ObjetoNaoEncontrado(String valor ){
        super("Objeto com o valor " + valor + " não encontrado.");
    }
}

