package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Visualizavel {
    static final Scanner teclado = new Scanner(System.in);

    public static int tratarOpcao() {
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

    public int menu();
}
