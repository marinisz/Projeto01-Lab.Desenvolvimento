import java.io.*;
import java.util.ArrayList;

public class FS<T> {
    public ArrayList<T> lerArquivo(String caminho) {
        ArrayList<T> lista = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream(caminho);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                while (true) {

                    lista = (ArrayList<T>) objectInputStream.readObject();

                }
            } catch (EOFException e) {

            }
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public void escreveArquivo(ArrayList<T> dados, String caminho) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(caminho);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(dados);

            objectOutputStream.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}