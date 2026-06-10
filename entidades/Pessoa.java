package entidades; 

// molde de "pessoa" com atributos base para todos os torcedores do sistema

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Data de Nascimento: " + dataNascimento;
    }

    public abstract String tipoTorcedor();
    public abstract Double Desconto();
    public abstract void exibirDados();
    public abstract void setPlano();
    public abstract Plano getPlano();
}