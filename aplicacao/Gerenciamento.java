package aplicacao;

import entidades.Pessoa;
import entidades.Plano;
import entidades.SocioTorcedor;
import entidades.TorcedorInadimplente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Gerenciamento {

    // classe para manuesear dados do usuario
    private ArrayList<Pessoa> listaTorcedores;

    public Gerenciamento() {
        this.listaTorcedores = new ArrayList<>();
    }

    // metodo para cadastro 
    public boolean adicionarTorcedor(Pessoa torcedor) {
    if (buscarPorCpf(torcedor.getCpf()) == null) {
        listaTorcedores.add(torcedor);
        return true;
    } else {
        System.out.println("Erro: Já existe um torcedor cadastrado com este CPF.");
        return false;
    }
}
    
    // buscar torcedor por cpf
    public Pessoa buscarPorCpf(String cpf) {
        for (Pessoa t : listaTorcedores) {
            if (t.getCpf().equals(cpf)) {
                return t;
            }
        }
        return null; 
    }

    //  metodo para remover torcedor 
    public boolean removerTorcedor(String cpf) {
        Pessoa torcedor = buscarPorCpf(cpf);
        if (torcedor != null) {
            listaTorcedores.remove(torcedor);
            return true;
        }
        return false;
    }

    // listar em tabela 
    public void listarTodos() {
        if (listaTorcedores.isEmpty()) {
            System.out.println("Nenhum torcedor cadastrado no sistema.");
            return;
        }

        System.out.println("\n");
        System.out.printf("%-15s | %-14s | %-12s | %-22s | %-25s\n", "NOME", "CPF", "NASCIMENTO", "TIPO TORCEDOR", "DETALHES / DESCONTO");
      
        for (Pessoa t : listaTorcedores) {
            // Imprime usando o formato tabular definido nas subclasses
            System.out.printf("%-15s | %-14s | %-12s | %-22s | ", 
                t.getNome(), t.getCpf(), t.getDataNascimento(), t.tipoTorcedor());
            
            if (t instanceof SocioTorcedor) {
                System.out.printf("Desconto: %.0f%%\n", t.Desconto() * 100);
            } else {
                System.out.printf("Desconto: %.0f%%\n", t.Desconto() * 100);
            }
        }
      
    }

    // listar de forma ordenada 
    public void listarOrdenadoPorNome() {
        if (listaTorcedores.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada para ordenar.");
            return;
        }

        // Criando uma cópia temporária da lista para não desordenar a principal
        ArrayList<Pessoa> listaOrdenada = new ArrayList<>(listaTorcedores);
        
        // Ordenação usando Comparator baseado no Nome de forma alfabética
        Collections.sort(listaOrdenada, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return p1.getNome().compareToIgnoreCase(p2.getNome());
            }
        });

        System.out.println("\nLISTA ORDENADA POR NOME");
        System.out.printf("%-15s | %-14s | %-22s\n", "NOME", "CPF", "TIPO TORCEDOR");

        for (Pessoa t : listaOrdenada) {
            System.out.printf("%-15s | %-14s | %-22s\n", t.getNome(), t.getCpf(), t.tipoTorcedor());
        }
    }

    // Getter para expor a lista para a interface contar ops elemwntos 
    public ArrayList<Pessoa> getListaTorcedores() {
        return listaTorcedores;
    }
}