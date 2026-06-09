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

    // Método abstrato (obrigatório implementar nas subclasses)
    public abstract void exibirDados();

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Data de Nascimento: " + dataNascimento;
    }


    // métodos que todos os torcedores (classes filhas) com seus respectivos planos são obrigados a ter
    public abstract Double calcularDesconto();
    public abstract String tipoTorcedor();

}