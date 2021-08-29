import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LerCurso {
    public ArrayList<CursoEntity> ler(String caminho) {
        ArrayList<CursoEntity> lista = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream(caminho);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                while (true) {

                    lista = (ArrayList<CursoEntity>)objectInputStream.readObject();

                }
            } catch (EOFException e) {

            }
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }
}