package entidades;

import java.time.LocalDate;

// torcedor com plano, possui atributos específicos
public class SocioTorcedor extends Pessoa {
<<<<<<< HEAD
      
=======

    private Plano plano;

    public SocioTorcedor(String nome, String cpf, LocalDate dataNascimento, Plano plano) {
        super(nome, cpf, dataNascimento);
        this.plano = plano;  
    }

    @Override
    public String tipoTorcedor() {
        return "Socio Torcedor";
    }

    @Override
    public Double Desconto(){
        return plano.getDesconto();
    }

    @Override
    public Plano getPlano(){
        return plano; 
    }

    // metodo para alterar o plano
    @Override
    public void setPlano(Plano novoPlano) {
        this.plano = novoPlano;
    }

    @Override
    public void exibirDados(){
        System.out.println(toString());
        System.out.println("Tipo: " + tipoTorcedor());
        System.out.println("Plano Atual: " + getPlano().getNomePlano());
        System.out.println("Mensalidade: R$ " + getPlano().getValorMensalidade());
        System.out.println("Desconto: " + Desconto() + "%");
        System.out.println("Benefícios: " + getPlano().getBeneficios());
    }
    
>>>>>>> a969bb9755fe8782f7cdcac5a0c3962a6bc956d1
}
