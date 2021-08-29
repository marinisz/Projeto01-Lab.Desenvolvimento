import java.io.*;
import java.util.*;
import java.io.Serializable;

public abstract class UsuarioEntity implements Serializable{
    private int matricula;
    private String nome;
    private String nascimento;
    private String senha;

    //Construtor
    UsuarioEntity(int matricula, String nome, String nascimento, String senha){
        this.matricula=matricula;
        this.nome=nome;
        this.nascimento=nascimento;
        this.senha=senha;
    }

    //getter and setter
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    //metodos
    //implementar metodo login e logut
    public void login(){
      //envia dados ao bd (matricula e senha)
      //confere se dados existem e são corretos
      //login realizado
    }
    public void logout(){
      //sai do login atual
    }
}

