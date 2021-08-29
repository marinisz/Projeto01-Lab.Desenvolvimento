import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscreverProfessor {

    public void escreveArquivo(ArrayList<ProfessorEntity> usuarios, String caminho) {
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