package Model;

import java.io.Serializable;
import java.util.Date;

public class Fatura implements Serializable{
    private Date data;
    private Double valor;
    private Disciplina disciplina;

    public Fatura(Date data, Double valor, Disciplina disciplina) {
        this.data = data;
        this.valor = valor;
        this.disciplina = disciplina;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Disciplina getDisc() {
        return disciplina;
    }

    public void setDisc(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
