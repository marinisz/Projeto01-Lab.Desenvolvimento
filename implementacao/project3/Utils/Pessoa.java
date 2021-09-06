package Utils;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String nascimento;
    private String senha;

    public Pessoa(String nome, String senha, String nascimento) {
        this.nome=nome;
        this.nascimento=nascimento;
        this.senha=senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return " Nome='" + nome + '\'' +
                ", Senha='" + senha + '\'' +
                ", Nascimento='" + nascimento + '\'';

    }
}
