package entidades;

import java.time.LocalDate;

// classe para os torcedores com plano, uso de implements para aplicar a interface
public class SocioTorcedor extends Pessoa implements Autenticavel { //implemntando a interface 

    // Atributos específicos
    private Plano plano;
    private String senha; // Adicionado para guardar a senha do torcedor

    public SocioTorcedor(String nome, String cpf, LocalDate dataNascimento, Plano plano, String senha) {
        super(nome, cpf, dataNascimento);
        this.plano = plano;  
        this.senha = senha; // Guardando a senha recebida da interface 
    }
    @Override
    public String tipoTorcedor() {
        return "Sócio Torcedor (" + plano.getNomePlano() + ")";
    }

    @Override
    public Double Desconto() {
        return plano.getDesconto();
    }

    @Override
    public Plano getPlano() {
        return plano;
    }

    // Método para alterar o plano 
    @Override
    public void setPlano(Plano novoPlano) {
        this.plano = novoPlano;
    }

    // validar a senha do sócio
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