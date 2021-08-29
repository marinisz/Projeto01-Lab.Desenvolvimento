import java.io.Serializable;

public class TurmaEntity implements Serializable{
    private String id;
    private DisciplinaEntity disciplina;
    private ProfessorEntity professor;
    private AlunoEntity[] alunos;
    private static final int QTD_MAXIMA;
    private static final int QTD_MINIMA;
    private int qtdAlunos;

    static {
        QTD_MAXIMA = 60;
        QTD_MINIMA = 3;
    }

    //Construtor
    public TurmaEntity(DisciplinaEntity disciplina, ProfessorEntity professor) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new AlunoEntity[QTD_MAXIMA];
        this.qtdAlunos = 0;
    }

    //getter and setters

    public void addAluno(AlunoEntity aluno) {
        this.alunos[qtdAlunos] = aluno;
        this.qtdAlunos += 1;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        this.disciplina = disciplina;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public void imprimirAlunos() {
        for (AlunoEntity aluno : this.alunos) {
            System.out.println(aluno);
        }
    }
}
