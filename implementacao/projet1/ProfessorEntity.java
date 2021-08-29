import java.util.Date;

public class ProfessorEntity extends UsuarioEntity {

    //Construtor
    ProfessorEntity(int matricula, String nome, String nascimento, String senha) {
        super(matricula, nome, nascimento, senha);
    }

    //metodos
    public void verCurriculo(AlunoEntity aluno){
        System.out.println(aluno.toString());
    }

    public String toString() {
        return "Professor: "+this.getNome()+"\nMatricula: "+this.getMatricula()+"\n";
    }
}
