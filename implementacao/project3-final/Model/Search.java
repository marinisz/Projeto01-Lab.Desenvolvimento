package Model;

import Exceptions.ObjetoNaoEncontrado;

public interface Search {
    public Usuario buscarUsuarioPelaMatricula(int matricula) throws ObjetoNaoEncontrado;
    public Curso buscarCursoPeloNome(String nome) throws ObjetoNaoEncontrado;
}
