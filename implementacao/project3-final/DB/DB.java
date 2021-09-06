package DB;

import java.util.ArrayList;

public interface DB<T> {
    public ArrayList<T> ler(String caminho);
    public void escrever(String caminho, ArrayList<T> dados);
}
