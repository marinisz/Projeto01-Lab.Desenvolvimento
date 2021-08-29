import java.util.ArrayList;
import java.io.Serializable;
public class CursoEntity implements Serializable{
    private ArrayList<DisciplinaEntity> disciplinaEntities;
    private String nome;
    private int numCreditos;

    //Construtor
    public CursoEntity(String nome){
        this.nome=nome;
    }
    public CursoEntity(ArrayList<DisciplinaEntity> disciplinaEntities, String nome, int numCreditos) {
        this.disciplinaEntities = disciplinaEntities;
        this.nome = nome;
        this.numCreditos = numCreditos;
    }


    //getters and setters

    public ArrayList<DisciplinaEntity> getDisciplinas() {
        return disciplinaEntities;
    }

    public void setDisciplinas(ArrayList<DisciplinaEntity> disciplinaEntities) {
        this.disciplinaEntities = disciplinaEntities;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }
}
