public class ProfessorEntity extends UsuarioEntity {

    ProfessorEntity(String nome, String senha, String nascimento) {
        super(nome, senha, nascimento);
    }

    //metodos
    public void verCurriculo(AlunoEntity aluno){
        aluno.toString();
    }

    public String toString() {
        return "Professor: "+this.getNome()+"\n Matricula: "+this.getMatricula();
    }
}
