package Model;

import DB.FS;
import Exceptions.ObjetoNaoEncontrado;

import java.util.ArrayList;
import java.util.Optional;

public class Sistema implements Search {
    private Usuario usuarioAtual;
    private Curriculo curriculo;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Curso> cursos;
    public static final FS<Usuario> fsUsuarios;
    public static final FS<Curso> fsCursos;
    private static Sistema instancia;

    static {
        fsUsuarios = new FS<>();
        fsCursos = new FS<>();
    }
    private Sistema() {
        this.connect();
        usuarios = fsUsuarios.ler("./DB/usuarios.bin");
        cursos = fsCursos.ler("./DB/cursos.bin");
        Usuario.QTD_USUARIO = usuarios.size();
    }

    private void connect() {
        usuarios = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public static Sistema getInstance() {
        if (Sistema.instancia == null)
            Sistema.instancia = new Sistema();

        return Sistema.instancia;
    }

    @Override
    public Usuario buscarUsuarioPelaMatricula(int matricula) throws ObjetoNaoEncontrado {
        Optional<Usuario> usuarioOpt = usuarios.stream().filter(usuario -> usuario.getMatricula() == matricula)
                .findAny();

        if (usuarioOpt.isPresent())
            return usuarioOpt.get();
        else
            throw new ObjetoNaoEncontrado("Usuario", matricula);
    }

    @Override
    public Curso buscarCursoPeloNome(String nome) throws ObjetoNaoEncontrado {
        Optional<Curso> cursosOpt = cursos.stream().filter(curso -> curso.getNome().equals(nome)).findAny();

        if (cursosOpt.isPresent())
            return cursosOpt.get();
        else
            throw new ObjetoNaoEncontrado("Curso", nome);
    }

    public void listarCurso() {
        if (cursos.isEmpty())
            System.out.println("Nao ha nenhum curso registrado");
        else
            for (Curso curso : cursos)
                System.out.println(curso);
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty())
            System.out.println("Nao ha nenhum usuario registrado");
        else
            for (Usuario usuario : usuarios)
                System.out.println(usuario);
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (this.usuarios.add(usuario))
            fsUsuarios.escrever("DB/usuarios.bin", usuarios);
    }

    public void cadastrarCurso(Curso curso) {
        if (this.cursos.add(curso))
            fsCursos.escrever("DB/cursos.bin", cursos);
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public Usuario getUsuarioAtual() {
        return this.usuarioAtual;
    }

    public void removerUsuario(Usuario usuario) {
        if(this.usuarios.remove(usuario))
            fsUsuarios.escrever("DB/usuarios.bin", usuarios);
    }

    public void removerCurso(Curso curso) {
        if(this.cursos.remove(curso))
            fsCursos.escrever("DB/cursos.bin", cursos);
    }

    public void atualizarCurso() {
        fsCursos.escrever("DB/cursos.bin", cursos);
    }
}
