package Model;

public class Aluno extends Usuario {
    private Curso curso;

    //Construtor
    public Aluno(String nome, String senha, String nascimento, Curso curso) {
        super(nome, senha, nascimento);
        this.curso = curso;
    }
    //getter and setter
    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    //metodos
    public void cancelarMatricula(){
      //apaga matricula do bd
    }
    public void matriculaDisciplina(){
      //insere matricula no bd
    }
    @Override
    public String toString() {
        return super.toString() +
                "\n Curso: " + this.curso;
    }
}
