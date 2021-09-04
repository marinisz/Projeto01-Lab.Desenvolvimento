package Model;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
    protected static int QTD_USUARIO = 0;
    private int matricula;
    private String nome;
    private String nascimento;
    private String senha;

    //Construtor
    Usuario(String nome, String senha, String nascimento){
        QTD_USUARIO += 1;
        this.matricula = QTD_USUARIO;
        this.nome=nome;
        this.nascimento=nascimento;
        this.senha=senha;
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

    @Override
    public String toString() {
        return "Papel: " + this.getClass().getSimpleName() +
                "\n Nome: " + this.nome +
                "\n Matricula: " + this.matricula +
                "\n Senha : " + this.senha;

    }
}

