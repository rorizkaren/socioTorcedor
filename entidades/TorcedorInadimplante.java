package entidades;

import java.time.LocalDate;

// torcedor cadastrado mas que não possui plano
public class TorcedorInadimplante extends Pessoa {

    private Plano plano;

    public TorcedorInadimplante(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.plano = new Plano( 0, "Comum (free)", 0.0, 
        0.0, "Sem benefícios de sócio torcedor");
    }

    public Plano getPlano() {
        return plano;
    }

    // método para alterar o plano
    public void setPlano(Plano novoPlano) {
        this.plano = novoPlano;
    }

    @Override
    public String tipoTorcedor() {
        return "Torcedor Inadimplente";
    }

    @Override 
    public Double Desconto(){
        return plano.getDesconto();
    }


    @Override
    public void exibirDados() {
        System.out.println(toString());
        System.out.println("Tipo: " + tipoTorcedor());
        System.out.println("Plano: " + getPlano().getNomePlano());
        System.out.println("Desconto: " + Desconto() + "%");
    }
}