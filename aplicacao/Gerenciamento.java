package aplicacao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entidades.Pessoa;

//classe para guardar e manusear dados de todas as pessoas, incluindo os com plano e os sem

public class Gerenciamento {
    
    private ArrayList<Pessoa> pessoas; 

    public Gerenciamento() {
        pessoas = new ArrayList<>();
    }

    // Método para cadastrar pessoa
    public void cadastrar(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println("Torcedor cadastrado com sucesso!");
    }

     // Método para buscar por CPF
    public Pessoa buscarPorCpf(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }

        return null;
    }

    // Método para alterar dados buscando pelo CPF
    public void alterarPorCpf(String cpf, String novoNome, LocalDate novaDataNascimento) {
        
        Pessoa pessoaEncontrada = buscarPorCpf(cpf);
        
        if (pessoaEncontrada != null) {
            pessoaEncontrada.setNome(novoNome);
            pessoaEncontrada.setDataNascimento(novaDataNascimento);
            pessoaEncontrada.setPlano(novoPlano);
            
            System.out.println("Torcedor alterado com sucesso!");
        } else {
            System.out.println("Torcedor não encontrado.");
        }
    }

    // Método para remover buscando pelo CPF
    public void removerPorCpf(String cpf) {

        Pessoa pessoaEncontrada = buscarPorCpf(cpf);

        if (pessoaEncontrada != null) {
            pessoas.remove(pessoaEncontrada);
            System.out.println("Torcedor removido com sucesso!");
        } else {
            System.out.println("Torcedor não encontrado.");
        }
    }

   
    // Método para listar em formato tabular
    public void listarTabela() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhum torcedor cadastrado.");
            return;
        }

        System.out.println("====================================================================================");
        System.out.printf("%-25s %-18s %-18s %-20s %-10s%n",
                "Nome", "CPF", "Nascimento", "Tipo", "Desconto");
        System.out.println("====================================================================================");

        for (Pessoa pessoa : pessoas) {
            System.out.printf("%-25s %-18s %-18s %-20s %-10.2f%n",
                    pessoa.getNome(),
                    pessoa.getCpf(),
                    pessoa.getDataNascimento(),
                    pessoa.tipoTorcedor(),
                    pessoa.calcularDesconto());
        }

        System.out.println("====================================================================================");
    }

    // Método para listar ordenado por nome
    public void listarOrdenadoPorNome() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhum torcedor cadastrado.");
            return;
        }

        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return p1.getNome().compareToIgnoreCase(p2.getNome());
            }
        });

        listarTabela();
    }

    // Método extra para mostrar quantidade
    public int quantidadeTorcedores() {
        return pessoas.size();
    }
}


