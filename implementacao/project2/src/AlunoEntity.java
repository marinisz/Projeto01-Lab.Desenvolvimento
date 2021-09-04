public class AlunoEntity extends UsuarioEntity {
    private CursoEntity curso;

    //Construtor
    AlunoEntity(String nome, String senha, String nascimento, CursoEntity curso) {
        super(nome, senha, nascimento);
        this.curso = curso;
    }
    //getter and setter
    public CursoEntity getCurso() {
        return this.curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    //metodos
    public void cancelarMatricula(){
        //apaga matricula do bd
    }
    public void matriculaDisciplina(){
        //insere matricula no bd
    }
    public String toString() {
        return "Aluno: "+this.getNome()+"\n Matricula: "+this.getMatricula()+"\n" + this.getCurso();
    }
}
