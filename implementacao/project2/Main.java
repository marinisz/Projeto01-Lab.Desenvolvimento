import java.util.*;

class Main {
  private static ArrayList<UsuarioEntity> usuarios;
  private static ArrayList<CursoEntity> cursos;
  private static FS<UsuarioEntity> fsUsuarios;
  private static FS<CursoEntity> fsCursos;

  static {
    usuarios = new ArrayList<>();
    cursos = new ArrayList<>();
    fsUsuarios = new FS<>();
    fsCursos = new FS<>();
  }

  static void pausa(Scanner teclado) {
    System.out.println("Enter para continuar.");
    teclado.nextLine();
  }

  public static CursoEntity buscarCurso(Scanner teclado) throws CursoNaoEncontrado {
    System.out.print("Digite o nome do curso: ");
    String nome = teclado.nextLine();

    Optional<CursoEntity> cursosOpt = cursos.stream().filter(curso -> curso.getNome().equals(nome)).findAny();

    if (cursosOpt.isPresent())
      return cursosOpt.get();
    else
      throw new CursoNaoEncontrado(nome);
  }

  public static UsuarioEntity buscarUsuario(Scanner teclado) throws UsuarionaoEncontrado {
    System.out.print("Digite a matricula do usuario: ");
    int matricula = Integer.parseInt(teclado.nextLine());

    Optional<UsuarioEntity> usuarioOpt = usuarios.stream().filter(usuario -> usuario.getMatricula() == matricula)
        .findAny();

    if (usuarioOpt.isPresent())
      return usuarioOpt.get();
    else
      throw new UsuarionaoEncontrado(matricula);
  }

  public static void cadastrarCurso(Scanner scan) {
    try {
      System.out.print("Digite nome: ");
      String nome = scan.nextLine();

      System.out.print("Digite a quantidade de creditos: ");
      int creditos = Integer.parseInt(scan.nextLine());

      cursos.add(new CursoEntity(nome, creditos));
      fsCursos.escreveArquivo(cursos, "cursos.bin");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void cadastrarUsuario(Scanner scan) {
    try {
      System.out.print("Digite um nome: \n");
      String nome = scan.nextLine();

      System.out.print("\nDigite uma senha: \n");
      String senha = scan.nextLine();

      System.out.print("\nInforme a data de nascimento (dia-mes-ano): \n");
      String dataNascimento = validarData(scan.nextLine());

      System.out.println("Tipo de usuario:");
      System.out.println("1 - Aluno");
      System.out.println("2 - Professor");
      String tipo = scan.nextLine();

      if (tipo.equals("1")) {
        CursoEntity curso = buscarCurso(scan);
        usuarios.add(new AlunoEntity(nome, senha, dataNascimento, curso));

      } else
        usuarios.add(new ProfessorEntity(nome, senha, dataNascimento));

      fsUsuarios.escreveArquivo(usuarios, "usuarios.bin");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void listarUsuarios() {
    if (cursos.isEmpty())
      System.out.println("Nao ha nenhum usuario registrado");
    else
      for (UsuarioEntity usuario : usuarios)
        System.out.println(usuario);
  }

  public static void listarCurso() {
    if (cursos.isEmpty())
      System.out.println("Nao ha nenhum curso registrado");
    else
      for (CursoEntity curso : cursos)
        System.out.println(curso);
  }


  public static UsuarioEntity logar(Scanner scan) {
    UsuarioEntity usuario = null;
    try {
      usuario = buscarUsuario(scan);

      System.out.print("Digite a senha: ");
      String senha = scan.nextLine();

      if (!verificarSenha(usuario.getSenha(), senha)) {
        throw new FalhaNoLogin();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return usuario;
  }

  public static String validarData(String data) throws Exception {
    String[] dataArr = data.split("-");

    if (dataArr.length != 3)
      throw new DataInvalida(data);

    int dia = Integer.parseInt(dataArr[0]), mes = Integer.parseInt(dataArr[1]), ano = Integer.parseInt(dataArr[2]);

    return new Data(dia, mes, ano).toString();
  }

  public static boolean verificarSenha(String senha1, String senha2) {
    return senha1.equals(senha2);
  }

  public static void lerDados() {
    usuarios = fsUsuarios.lerArquivo("usuarios.bin");
    cursos = fsCursos.lerArquivo("cursos.bin");
  }

  public static int menuAluno(Scanner teclado) {
    int opcao = 0;
    System.out.println("____________Menu Aluno____________");
    System.out.println("1 - Matricular disciplina");
    System.out.println("2 - Cancelar disciplina");
    System.out.println("0 - Logout");
    System.out.print("Opção: ");

    try {
      opcao = teclado.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("Favor inserir valor válido!");
      opcao = menu(teclado);
    }
    teclado.nextLine();
    return opcao;
  }

  public static int menuCurso(Scanner teclado) {
    int opcao = 0;
    System.out.println("____________Menu Curso____________");
    System.out.println("1 - Cadastrar");
    System.out.println("2 - Listar");
    System.out.println("0 - Voltar");
    System.out.print("Opção: ");

    try {
      opcao = teclado.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("Favor inserir valor válido!");
      opcao = menu(teclado);
    }
    teclado.nextLine();
    return opcao;
  }

  public static int menuProfessor(Scanner teclado) {
    int opcao = 0;
    System.out.println("____________Menu Professor____________");
    System.out.println("1 - Imprimir alunos na disciplina");
    System.out.println("0 - Logout");
    System.out.print("Opção: ");

    try {
      opcao = teclado.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("Favor inserir valor válido!");
      opcao = menu(teclado);
    }
    teclado.nextLine();
    return opcao;
  }

  public static int menuUsuario(Scanner teclado) {
    int opcao = 0;
    System.out.println("____________Menu Usuario____________");
    System.out.println("1 - Logar");
    System.out.println("2 - Cadastrar");
    System.out.println("3 - Listar usuarios");
    System.out.println("0 - Voltar");
    System.out.print("Opção: ");

    try {
      opcao = teclado.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("Favor inserir valor válido!");
      opcao = menu(teclado);
    }
    teclado.nextLine();
    return opcao;
  }

  public static int menu(Scanner teclado) {
    int opcao = 0;
    System.out.println("____________Menu Principal____________");
    System.out.println("1 - Menu Usuario ");
    System.out.println("2 - Menu Curso");
    System.out.println("0 - Sair");
    System.out.print("Opção: ");

    try {
      opcao = teclado.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("Favor inserir valor válido!");
      opcao = menu(teclado);
    }
    teclado.nextLine();
    return opcao;
  }


  public static void mainAluno(Scanner scan) {
    int opcao = menuAluno(scan);

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          System.out.println("Matricular Disciplina");
          pausa(scan);
          break;
        case 2:
          System.out.println("Cancelar Disciplina");
          pausa(scan);
          break;
      }
      opcao = menuAluno(scan);
    }
  }

  public static void mainCurso(Scanner scan) {
    int opcao = menuCurso(scan);

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          cadastrarCurso(scan);
          pausa(scan);
          break;
        case 2:
          listarCurso();
          pausa(scan);
          break;
      }
      opcao = menuCurso(scan);
    }
  }

  public static void mainProfessor(Scanner scan) {
    int opcao = menuProfessor(scan);

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          System.out.println("Teste");
          pausa(scan);
          break;
      }
      opcao = menuProfessor(scan);
    }
  }

  public static void mainUsuario(Scanner scan) {
    int opcao = menuUsuario(scan);

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          UsuarioEntity usuario = logar(scan);
          if(usuario instanceof ProfessorEntity)
            mainProfessor(scan);
          else
            mainAluno(scan);
          pausa(scan);
          break;
        case 2:
          cadastrarUsuario(scan);
          pausa(scan);
          break;
        case 3:
          listarUsuarios();
          pausa(scan);
          break;
      }
      opcao = menuUsuario(scan);
    }
  }

  public static void main(String[] args) {
    lerDados();
    UsuarioEntity.QTD_USUARIO = usuarios.size();
    Scanner scan = new Scanner(System.in);
    System.out.println("Bem vindo ao sistema!");
    int opcao = menu(scan);

    while (opcao != 0) {
      switch (opcao) {
        case 1:
          mainUsuario(scan);
          pausa(scan);
          break;
        case 2:
          mainCurso(scan);
          pausa(scan);
          break;
      }
      opcao = menu(scan);
    }
  }
}