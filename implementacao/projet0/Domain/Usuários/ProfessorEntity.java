import java.util.Date;

public class ProfessorEntity extends UsuarioEntity {

    //Construtor
    ProfessorEntity(int matricula, String nome, Date nascimento, String senha) {
        super(matricula, nome, nascimento, senha);
    }

    //metodos
    public void verCurriculo(AlunoEntity aluno){
        aluno.toString();
    }
}
