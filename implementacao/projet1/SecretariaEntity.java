import java.util.*;

public class SecretariaEntity {

    //metodos
    public void criarDisciplina(DisciplinaEntity novaDisciplinaEntity){
        //add nova disciplina no bd
    }
    public void recuperarDisciplina(DisciplinaEntity disciplina){
      //busca
      disciplina.toString();
    }

    public void menuSecretaria()
    {
      Scanner scan = new Scanner(System.in);
      int escolhaUsuario=0;
      System.out.println("Para disciplinas, digite 1. Para alunos, 2.\nPara professores, digite 3.\n");
      while(escolhaUsuario<1 || escolhaUsuario>3)
      {
        escolhaUsuario = scan.nextInt();
      }
      
      if(escolhaUsuario == 1)
      {
        System.out.println("\nPara atualizar disciplina, digite 1.\nPara deletar discplinas, digite 2.\n");
        while(escolhaUsuario!=1 || escolhaUsuario!=2)
        {
        escolhaUsuario = scan.nextInt();
        }
        if(escolhaUsuario==1)
        {
          atualizarDisciplina();
        }
        else
        {
          deletarDisciplina();
        }
      }

      else if(escolhaUsuario == 2)
      {
        System.out.println("\nPara criar aluno, digite 1.\nPara pesquisar, digite 2.\nPara atualizar aluno, digite 3.\nPara deletar, 4.");
        while(escolhaUsuario<1 || escolhaUsuario>4)
        {
          escolhaUsuario = scan.nextInt();
        }
        if(escolhaUsuario==1)
        {
          criarAluno();
        }
        else if(escolhaUsuario == 2)
        {
          recuperarAluno();
        }
        else if(escolhaUsuario == 3)
        {
          atualizarAluno();
        }
        else
        {
          deletarAluno();
        }
      }

      else
      {
        System.out.println("\nPara criar um professor, digite 1.\nPara pesquisar, digite 2.\nPara atualizar um professor, digite 3.\nPara deletar, 4.");
        while(escolhaUsuario<1 || escolhaUsuario>4)
        {
          escolhaUsuario = scan.nextInt();
        }
        if(escolhaUsuario==1)
        {
          criarProfessor();
        }
        else if(escolhaUsuario == 2)
        {
          recuperarProfessor();
        }
        else if(escolhaUsuario == 3)
        {
          atualizarProfessor();
        }
        else
        {
          deletarProfessor();
        }
      }
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
