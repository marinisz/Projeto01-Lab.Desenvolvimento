package View;

import java.util.Scanner;

public class CursoViewer extends Viewer {
    @Override
    public int menu( ) {
        System.out.println("____________Menu Curso____________");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");

        return Viewer.tratarOpcao();
    }
}
