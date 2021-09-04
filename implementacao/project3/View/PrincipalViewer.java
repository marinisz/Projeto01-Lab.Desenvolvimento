package View;

public class PrincipalViewer extends UsuarioViewer {
    @Override
    public int menu( ) {
        System.out.println("____________Menu Principal____________");
        System.out.println("1 - Logar");
        System.out.println("2 - Cadastrar Secretaria");
        System.out.println("3 - Listar usuarios");;
        System.out.println("0 - Sair");
        System.out.print("Opção: ");

        return Viewer.tratarOpcao();
    }
}
