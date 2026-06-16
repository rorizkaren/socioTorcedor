package aplicacao;

import entidades.Pessoa;
import entidades.SocioTorcedor;
<<<<<<< HEAD
=======
import entidades.TorcedorInadimplente;

>>>>>>> parent of b73b73d (desgepetizou)
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

<<<<<<< HEAD
public class Gerenciamento {

    // classe para manusear dados do usuario
=======
/**
 * Classe responsável por gerenciar a lista de torcedores em memória.
 * Implementa as regras de negócio para Inserção, Alteração, Exclusão, Busca e Ordenação.
 */
public class Gerenciamento {

    // Estrutura de dados para armazenar os torcedores (Requisito 10)
>>>>>>> parent of b73b73d (desgepetizou)
    private ArrayList<Pessoa> listaTorcedores;

    public Gerenciamento() {
        this.listaTorcedores = new ArrayList<>();
    }

<<<<<<< HEAD
    // método para cadastro (Mantive a versão com retorno boolean, que é mais completa)
    public boolean adicionarTorcedor(Pessoa torcedor) {
        if (buscarPorCpf(torcedor.getCpf()) == null) {
            listaTorcedores.add(torcedor);
            return true;
=======
    // 1. CADASTRAR (Requisito 3)
    public void adicionarTorcedor(Pessoa torcedor) {
        if (buscarPorCpf(torcedor.getCpf()) == null) {
            listaTorcedores.add(torcedor);
            System.out.println("Torcedor cadastrado com sucesso!");
>>>>>>> parent of b73b73d (desgepetizou)
        } else {
            System.out.println("Erro: Já existe um torcedor cadastrado com este CPF, tente novamente.");
            return false;
        }
    }

    // 2. BUSCAR POR CPF (Requisito 5)
    public Pessoa buscarPorCpf(String cpf) {
        for (Pessoa t : listaTorcedores) {
            if (t.getCpf().equals(cpf)) {
                return t;
            }
        }
        return null; // Retorna null se não encontrar
    }

<<<<<<< HEAD
    // método para remover torcedor 
=======
    // 3. REMOVER (Requisito 3)
>>>>>>> parent of b73b73d (desgepetizou)
    public boolean removerTorcedor(String cpf) {
        Pessoa torcedor = buscarPorCpf(cpf);
        if (torcedor != null) {
            listaTorcedores.remove(torcedor);
            return true;
        }
        return false;
    }

    // 4. LISTAR EM FORMATO TABULAR (Requisito 4)
    public void listarTodos() {
        if (listaTorcedores.isEmpty()) {
            System.out.println("Nenhum torcedor cadastrado no sistema.");
            return;
        }

        System.out.println("\n=======================================================================================================");
        System.out.printf("%-15s | %-14s | %-12s | %-22s | %-25s\n", "NOME", "CPF", "NASCIMENTO", "TIPO TORCEDOR", "DETALHES / DESCONTO");
        System.out.println("=======================================================================================================");
        
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
<<<<<<< HEAD
=======
        System.out.println("=======================================================================================================\n");
>>>>>>> parent of b73b73d (desgepetizou)
    }

    // 5. LISTAR DE FORMA ORDENADA POR NOME (Requisito 6)
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

        System.out.println("\n--- LISTA ORDENADA POR NOME (ALFABÉTICA) ---");
        System.out.printf("%-15s | %-14s | %-22s\n", "NOME", "CPF", "TIPO TORCEDOR");
        System.out.println("----------------------------------------------------------------------");
        for (Pessoa t : listaOrdenada) {
            System.out.printf("%-15s | %-14s | %-22s\n", t.getNome(), t.getCpf(), t.tipoTorcedor());
        }
        System.out.println("----------------------------------------------------------------------\n");
    }

<<<<<<< HEAD
    // Getter para expor a lista para a interface contar os elementos 
=======
    // Getter para expor a lista caso o Programa.java precise contar os elementos
>>>>>>> parent of b73b73d (desgepetizou)
    public ArrayList<Pessoa> getListaTorcedores() {
        return listaTorcedores;
    }
}