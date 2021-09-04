package View;

import java.util.Scanner;

public abstract class Viewer {
    protected static final Scanner teclado = new Scanner(System.in);

    protected static int tratarOpcao() {
        int opcao = 0;
        try {
            opcao = teclado.nextInt();
        } catch (Exception exception) {
            System.out.println("Favor inserir valor válido!");
            opcao = tratarOpcao();
        }
        teclado.nextLine();
        return opcao;
    }

    abstract public int menu();
}
