import java.util.*;

public class Cadastrar{

public void cadastrar(){
    Scanner scn= new Scanner(System.in);
    try{  
      System.out.println("Para começar, digite o seu nome:\n");
      String nome = scn.nextLine();

      System.out.println("\nAgora, digite uma senha.\n");
      String senha = scn.nextLine();

      System.out.println("\nInforme sua data de nascimento\n");
      String dataNascimento = scn.nextLine();

      System.out.println("\nPara cadastro de professor, digite 1.\nPara cadastro de aluno, digite 2\n");
      int tipoCadastro = scn.nextInt();
      if(tipoCadastro == 1)
      {
          System.out.println("\nInforme a disciplina lecionada\n");
          String disciplina = scn.nextLine();
      }
      else
      {
          System.out.println("\nInforme o curso realizado\n");
          String curso = scn.nextLine();
      }
    }
    catch (Exception e) 
    {
      System.out.println(e);
    }
    finally
    {
      scn.close();
    }  
   //Aqui se chama o método para escrever o nosso novo usuário.
   //Algo como:
   // ClasseEscrever nomeClasse = new ClasseEscrever()
   // if(tipoCadastro == 1){
   // nomeClasse.cadastrarProfessor(nome, senha, dataNascimento, disciplina);
   // }
   // else{
   // nomeClasse.cadastrarAluno(nome, senha, dataNascimento, curso);
   //}
  }
}
