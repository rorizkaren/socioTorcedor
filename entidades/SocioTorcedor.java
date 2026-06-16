package entidades;

import java.time.LocalDate;

/**
 * Representa o Sócio-Torcedor ativo no sistema.
 * Aplica Herança (Pessoa), Composição (Plano) e implementa a Interface Autenticavel.
 */
public class SocioTorcedor extends Pessoa implements Autenticavel {

    // Atributos específicos
    private Plano plano;
    private String senha; // Adicionado para guardar a senha do torcedor

    // Construtor completo passando os dados básicos para a classe mãe (Pessoa) e salvando a senha
    public SocioTorcedor(String nome, String cpf, LocalDate dataNascimento, Plano plano, String senha) {
        super(nome, cpf, dataNascimento);
        this.plano = plano;  
        this.senha = senha; // Guardando a senha recebida do Programa.java
    }

    // Implementação polimórfica para retornar o tipo com o nome do plano atrelado
    @Override
    public String tipoTorcedor() {
        return "Sócio Torcedor (" + plano.getNomePlano() + ")";
    }

    // Retorna o desconto do ingresso vindo do plano associado
    @Override
    public Double Desconto() {
        return plano.getDesconto();
    }

    // Getter para o plano (sobrescrevendo o da classe Pessoa)
    @Override
    public Plano getPlano() {
        return plano;
    }

    // Método para alterar o plano (Permite o "Alterar" do CRUD do professor)
    @Override
    public void setPlano(Plano novoPlano) {
        this.plano = novoPlano;
    }

    // IMPLEMENTAÇÃO DA INTERFACE: Lógica obrigatória para validar a senha do sócio
    @Override
    public boolean autenticar(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

    // Getter e Setter da senha caso precise no futuro
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Método para exibir os dados de forma detalhada e organizada no terminal.
     */
    @Override
    public void exibirDados() {
        System.out.println(toString()); // Exibe os dados básicos de Pessoa
        System.out.println("Tipo:          " + tipoTorcedor());
        System.out.println("Plano Atual:   " + plano.getNomePlano());
        System.out.println("Mensalidade:   R$ " + plano.getValorMensalidade());
        System.out.println("Desconto:      " + Desconto() + "%");
        System.out.println("Benefícios:    " + plano.getBeneficios());
    }
}