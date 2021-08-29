import java.util.ArrayList;

public class DisciplinasDoCursoEntity {
    private ArrayList<DisciplinaEntity> disciplinaEntity;

    //Constructor
    public DisciplinasDoCursoEntity(ArrayList<DisciplinaEntity> disciplinaEntity) {
        this.disciplinaEntity = disciplinaEntity;
    }

    //getter and setter
    public ArrayList<DisciplinaEntity> getDisciplina() {
        return disciplinaEntity;
    }

    public void setDisciplina(ArrayList<DisciplinaEntity> disciplinaEntity) {
        this.disciplinaEntity = disciplinaEntity;
    }
}
