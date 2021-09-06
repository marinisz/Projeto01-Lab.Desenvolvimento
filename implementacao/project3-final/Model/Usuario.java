package Model;

import java.io.Serializable;

import Utils.Pessoa;

public abstract class Usuario implements Serializable{
    protected static int QTD_USUARIO = 0;
    private int matricula;
    private Pessoa pessoa;

    //Construtor
    Usuario(Pessoa pessoa){
        QTD_USUARIO += 1;
        this.matricula = QTD_USUARIO;
        this.pessoa = pessoa;
    }

    //getter and setter

    public int getMatricula() {
        return matricula;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void listarUsuario() {
        Sistema sistema = Sistema.getInstance();
        try {
            sistema.listarUsuarios();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Papel: " + this.getClass().getSimpleName() +
                "\n\tMatricula: " + this.matricula +
                "\n\t" + this.pessoa.toString();

    }
}

