import java.io.Serializable;

public class TurmaEntity implements Serializable{
    private String id;
    private static int QTD_MAXIMA = 60;
    private static int QTD_MINIMA = 3;
    private String qtdAlunos;

    //Construtor
    public TurmaEntity(String id, String qtdAlunos) {
        this.id = id;
        this.qtdAlunos = qtdAlunos;
    }


    //getter and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(String qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }
}
