import java.io.Serializable;
import java.util.ArrayList;

public abstract class UsuarioEntity implements Serializable{
    protected static int QTD_USUARIO = 0;
    private int matricula;
    private String nome;
    private String nascimento;
    private String senha;

    private ArrayList<DisciplinaEntity> disciplinas;
    private int mensalidade;

    private int DisciplinasObrigatorias = 0;
    private int DisciplinasOpcionais = 0;

    //Construtor
    UsuarioEntity(String nome, String senha, String nascimento){
        QTD_USUARIO += 1;
        this.matricula = QTD_USUARIO;
        this.nome=nome;
        this.nascimento=nascimento;
        this.senha=senha;
        this.DisciplinasOpcionais = 0;
        this.DisciplinasOpcionais = 0;
        this.disciplinas = new ArrayList<DisciplinaEntity>();
        this.mensalidade = 0;
    }

    //getter and setter

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void addObrigatoria(){ this.DisciplinasObrigatorias++; }
    public int getDisciplinasObrigatorias() { return this.DisciplinasObrigatorias; }

    public void addOpcional(){ this.DisciplinasOpcionais++; }
    public int getDisciplinasOpcionais(){ return this.DisciplinasOpcionais; }

    public void addDisciplina(DisciplinaEntity novaDisciplina) {
        this.disciplinas.add(novaDisciplina);
        this.mensalidade += novaDisciplina.getQtdHoras()*100;
    }

    public int getMensalidade() { return this.mensalidade; }

    public ArrayList<DisciplinaEntity> getDisciplinas() { return this.disciplinas; }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", nascimento='" + nascimento + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

