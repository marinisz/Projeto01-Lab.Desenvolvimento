package View;

public class AlunoViewer extends Viewer {
    @Override
    public int menu() {
        System.out.println("____________Menu Aluno____________");
        System.out.println("1 - Matricular disciplina");
        System.out.println("2 - Cancelar disciplina");
        System.out.println("0 - Logout");
        System.out.print("Opção: ");

        return Viewer.tratarOpcao();
    }
}
