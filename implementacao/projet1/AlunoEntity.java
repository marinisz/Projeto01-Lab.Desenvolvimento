import java.util.Date;


public class AlunoEntity extends UsuarioEntity {
    private CursoEntity cursoEntity;

    //Construtor
    AlunoEntity(int matricula, String nome, String nascimento, String senha, CursoEntity cursoEntity) {
        super(matricula, nome, nascimento, senha);
        this.cursoEntity = cursoEntity;
    }
    //getter and setter
    public CursoEntity getCurso() {
        return cursoEntity;
    }

    public void setCurso(CursoEntity cursoEntity) {
        this.cursoEntity = cursoEntity;
    }

    //metodos
    public void cancelarMatricula(){
      //apaga matricula do bd
    }
    public void matriculaDisciplina(){
      //insere matricula no bd
    }
    public String toString() {
        return "Aluno: "+this.getNome()+"\nMatricula: "+this.getMatricula()+"\nCurso: "+this.getCurso().getNome()+"\n";
    }
}
