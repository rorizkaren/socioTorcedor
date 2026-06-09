package entidades; 
import java.time.LocalDate;

// torcedor cadastrado mas que não possui plano
public class TorcedorInadimplante extends Pessoa {

    public TorcedorComum(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
    }
    
    @Override
    public Double calcularDesconto(){
        return 0.0;
    }
}   
    @Override
    public String tipoTorcedor(){
        return "Comum (free)"
    }