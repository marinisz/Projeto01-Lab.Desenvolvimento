package Model;

import DB.FS;
import Exceptions.ObjetoNaoEncontrado;

import java.util.ArrayList;
import java.util.Optional;

public class SistemaModel implements Buscavel {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Curso> cursos;
    private FS<Usuario> fsUsuarios;
    private FS<Curso> fsCursos;
    private static SistemaModel instancia;

    private SistemaModel() {
        this.connect();
        usuarios = fsUsuarios.ler("./DB/usuarios.bin");
        cursos = fsCursos.ler("./DB/cursos.bin");
        Usuario.QTD_USUARIO = usuarios.size();
    }

    private void connect() {
        usuarios = new ArrayList<>();
        cursos = new ArrayList<>();
        fsUsuarios = new FS<>();
        fsCursos = new FS<>();
    }

    public static SistemaModel getInstance() {
        if(SistemaModel.instancia == null)
            SistemaModel.instancia = new SistemaModel();

        return SistemaModel.instancia;
    }

    @Override
    public Usuario buscarPelaMatricula(int matricula) throws ObjetoNaoEncontrado {
        Optional<Usuario> usuarioOpt = usuarios.stream().filter(usuario -> usuario.getMatricula() == matricula)
                .findAny();

        if (usuarioOpt.isPresent())
            return usuarioOpt.get();
        else
            throw new ObjetoNaoEncontrado(matricula);
    }

    @Override
    public Curso buscarPeloNome(String nome)throws ObjetoNaoEncontrado {
        Optional<Curso> cursosOpt = cursos.stream().filter(curso -> curso.getNome().equals(nome)).findAny();

        if (cursosOpt.isPresent())
            return cursosOpt.get();
        else
            throw new ObjetoNaoEncontrado(nome);
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
        if(this.usuarios.add(usuario))
            fsUsuarios.escrever("DB/usuarios.bin", usuarios);
    }

    public void cadastrarCurso(Curso curso) {
        if(this.cursos.add(curso))
            fsCursos.escrever("DB/cursos.bin", cursos);
    }
}
