import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CursoEntity implements Serializable {
    private Set<DisciplinaEntity> disciplinas;
    private String nome;
    private int numCreditos;

    //Construtor

    public CursoEntity(String nome, int numCreditos) {
        this.disciplinas = new HashSet<>();
        this.nome = nome;
        this.numCreditos = numCreditos;
    }

    //getters and setters

    public Set<DisciplinaEntity> getDisciplinas() {
        return Collections.unmodifiableSet(this.disciplinas);
    }

    public void removeDisciplina(DisciplinaEntity disciplina) {
        this.disciplinas.remove(disciplina);
    }

    public void addDisciplina(DisciplinaEntity disciplina) {
        this.disciplinas.add(disciplina);
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

    @Override
    public String toString() {
        return "Curso={" +
                "disciplinas=" + disciplinas +
                ", nome='" + nome + '\'' +
                ", numCreditos=" + numCreditos +
                '}';
    }
}
