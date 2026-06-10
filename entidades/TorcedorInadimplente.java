package entidades;

import java.time.LocalDate;

// Representa o torcedor cadastrado mas que está inadimplente ou sem plano ativo
public class TorcedorInadimplente extends Pessoa {

    // Atributos específicos da classe
    private Plano plano;
    private String motivoRestricao; // Guarda a razão da inadimplência/inatividade

    // CONSTRUTOR CORRIGIDO: Agora recebe o motivo enviado pelo Programa.java
    public TorcedorInadimplente(String nome, String cpf, LocalDate dataNascimento, String motivoRestricao) {
        super(nome, cpf, dataNascimento);
        this.motivoRestricao = motivoRestricao;
        // Instancia um plano padrão zerado (Free) para não dar NullPointerException
        this.plano = new Plano(0, "Comum (Free)", 0.0, 0.0, "Sem benefícios de sócio torcedor");
    }

    // Retorna o plano padrão criado no construtor
    @Override
    public Plano getPlano() {
        return plano;
    }

    // Método obrigatório da classe mãe para alterar o plano se ele voltar a pagar
    @Override
    public void setPlano(Plano novoPlano) {
        this.plano = novoPlano;
    }

    @Override
    public String tipoTorcedor() {
        return "Inadimplente/Inativo";
    }

    @Override 
    public Double Desconto() {
        return plano.getDesconto(); // Retorna 0.0%
    }

    // Getter e Setter para o motivo da restrição
    public String getMotivoRestricao() {
        return motivoRestricao;
    }

    public void setMotivoRestricao(String motivoRestricao) {
        this.motivoRestricao = motivoRestricao;
    }

    /**
     * Método para exibir os dados de forma detalhada e organizada no terminal.
     */
    @Override
    public void exibirDados() {
        System.out.println(toString()); // Exibe os dados básicos de Pessoa
        System.out.println("Tipo:          " + tipoTorcedor());
        System.out.println("Situação:      " + motivoRestricao);
        System.out.println("Plano Atual:   " + plano.getNomePlano());
        System.out.println("Desconto:      " + Desconto() + "%");
    }
}