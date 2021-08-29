import java.io.*;
import java.util.*;

public class LerAluno{
    public List<AlunoEntity> ler(String caminho) {
        List<AlunoEntity> lista = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream(caminho);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                while (true) {

                    lista.add((AlunoEntity)objectInputStream.readObject());

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