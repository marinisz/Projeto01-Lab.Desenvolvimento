import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EscreverAluno{

    public void escreveArquivo(ArrayList<AlunoEntity> usuarios, String caminho) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(caminho);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(usuarios);

            objectOutputStream.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}