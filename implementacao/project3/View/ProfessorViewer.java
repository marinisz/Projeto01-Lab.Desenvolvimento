package View;

public class ProfessorViewer extends UsuarioViewer {
    @Override
    public int menu() {
        System.out.println("____________Menu Professor____________");
        System.out.println("1 - Imprimir alunos na disciplina");
        System.out.println("0 - Logout");
        System.out.print("Opção: ");

        return Viewer.tratarOpcao();
    }
}
