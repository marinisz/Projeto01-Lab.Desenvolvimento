import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner( System.in );
    System.out.println("Bem vindo ao sistema!");
    int tipoLogin = logar(scan);
    if(tipoLogin == 3){
      cadastrar(scan);
    }
    else if (tipoLogin == 2){
      loginProfessor();
    }
    else{
      loginAluno();
    }
    scan.close();
  }

  public static int logar(Scanner scan){
    int tipoLogin=0;
    System.out.println("Digite 1 para professor, 2 para aluno.\nPara se cadastrar, digite 3\n");
    while(tipoLogin<1 || tipoLogin>3){

    tipoLogin = scan.nextInt();
    }
    return tipoLogin;
  }

  public static void cadastrar(Scanner scan){
    scan = new Scanner(System.in);
    System.out.println("Para começar, digite o seu nome:\n");
    String nome = scan.nextLine();
    scan = new Scanner(System.in);
    System.out.println("\nAgora, digite uma senha.\n");
    String senha = scan.nextLine();
    scan = new Scanner(System.in);
    System.out.println("\nInforme sua data de nascimento\n");
    String dataNascimento = scan.nextLine();
    scan = new Scanner(System.in);
    System.out.println("\nPara cadastro de professor, digite 1.\nPara cadastro de aluno, digite 2\n");
    int tipoCadastro = scan.nextInt();
    if(tipoCadastro == 1){
      scan = new Scanner(System.in);
      System.out.println("\nInforme a disciplina lecionada\n");
      String disciplina = scan.nextLine();
      ProfessorEntity professor = new ProfessorEntity(123,nome,dataNascimento,senha);
      EscreverProfessor escrever = new EscreverProfessor();
      LerProfessor ler = new LerProfessor();
      ArrayList<ProfessorEntity> lista = ler.ler("professor.bin");
      lista.add(professor);
      escrever.escreveArquivo(lista,"professor.bin");
      for(ProfessorEntity a : lista){
        System.out.println(a.toString());
      }

    }
    else{
      System.out.println("\nInforme o curso realizado\n");
      scan = new Scanner(System.in);
      String curso = scan.nextLine();
      CursoEntity cursoRecebido = new CursoEntity(curso);
      AlunoEntity aluno = new AlunoEntity(123,nome,dataNascimento,senha,cursoRecebido);
      EscreverAluno escrever = new EscreverAluno();
      LerAluno ler = new LerAluno();
      ArrayList<AlunoEntity> lista = ler.ler("alunos.bin");
      lista.add(aluno);
      escrever.escreveArquivo(lista,"alunos.bin");
      for(AlunoEntity a : lista){
          System.out.println(a.toString());
      }
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

  public static void loginProfessor(){
    
  }

  public static void loginAluno(){
    System.out.println("entrei");
  }
}