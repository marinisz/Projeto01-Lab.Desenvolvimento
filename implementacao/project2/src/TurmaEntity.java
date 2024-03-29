import java.io.Serializable;

public class TurmaEntity implements Serializable{
    private int id;
    protected static int QTD_TURMAS = 0;
    private DisciplinaEntity disciplina;
    private ProfessorEntity professor;
    private UsuarioEntity[] alunos;
    private static final int QTD_MAXIMA;
    private static final int QTD_MINIMA;
    private int qtdAlunos;

    static {
        QTD_MAXIMA = 60;
        QTD_MINIMA = 3;
    }

    //Construtor
    public TurmaEntity(DisciplinaEntity disciplina) {
        QTD_TURMAS += 1;
        this.id = QTD_TURMAS;
        this.disciplina = disciplina;
        this.alunos = new AlunoEntity[QTD_MAXIMA];
        this.qtdAlunos = 0;
    }

    //getter and setters

    public void addAluno(UsuarioEntity aluno) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public void imprimirAlunos() {
        for (UsuarioEntity aluno : this.alunos) {
            System.out.println(aluno);
        }
    }
}
