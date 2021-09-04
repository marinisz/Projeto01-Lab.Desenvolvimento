package Model;

import Exceptions.ObjetoNaoEncontrado;

public interface Buscavel<T> {
    public T buscarPelaMatricula(int matricula) throws ObjetoNaoEncontrado;
    public T buscarPeloNome(String nome) throws ObjetoNaoEncontrado;
}
