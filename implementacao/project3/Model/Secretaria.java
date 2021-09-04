package Model;

public class Secretaria extends Usuario {

    public Secretaria(String nome, String senha, String nascimento) {
        super(nome, senha, nascimento);
    }

    //metodos
    public void criarDisciplina(Disciplina novaDisciplinaEntity){
        //add nova disciplina no bd
    }
    public void recuperarDisciplina(Disciplina disciplina){
      //busca
      disciplina.toString();
    }
    public void atualizarDisciplina(){}
    public void deletarDisciplina(){}
    public void criarAluno(){}
    public void recuperarAluno(){}
    public void atualizarAluno(){}
    public void deletarAluno(){}
    public void criarProfessor(){}
    public void recuperarProfessor(){}
    public void atualizarProfessor(){}
    public void deletarProfessor(){}

}
