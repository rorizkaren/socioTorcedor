package aplicacao;
<<<<<<< HEAD

import javax.swing.SwingUtilities;

public class Programa {
    public static void main(String[] args) {
        // Uso do Swing para criação da interface gráfica de forma segura
        SwingUtilities.invokeLater(new Runnable() { 
            @Override
            public void run() {
                new TelaSistema();
            }
        });
=======

import entidades.Pessoa;
import entidades.Plano;
import entidades.SocioTorcedor;
import entidades.TorcedorInadimplente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal do sistema responsável pela execução e interface com o usuário.
 * Atende aos requisitos de Nome da Classe, Carga Inicial de 7 objetos e Menu Textual.
 */
public class Programa {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Gerenciamento gerenciador = new Gerenciamento();
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // 1. Criando os Planos Disponíveis para o sistema (Composição)
        // ALTERADO: Agora inclui o 5º parâmetro (String beneficios) exigido pela sua classe Plano
        ArrayList<Plano> planosDisponiveis = new ArrayList<>();
        planosDisponiveis.add(new Plano(1, "Bronze", 15.00, 10.0, "10% de desc. em ingressos")); 
        planosDisponiveis.add(new Plano(2, "Prata", 35.00, 30.0, "30% de desc. e acesso prioritário 2"));  
        planosDisponiveis.add(new Plano(3, "Ouro", 60.00, 50.0, "50% de desc. e acesso prioritário total"));   

        // 2. CARGA INICIAL AUTOMÁTICA - Cadastra pelo menos 7 objetos de cada classe (Requisito 8)
        
        // Cadastrando 7 Sócios Torcedores Ativos
        gerenciador.adicionarTorcedor(new SocioTorcedor("Carlos Silva", "111.111.111-11", LocalDate.of(1990, 5, 12), planosDisponiveis.get(2), "senha123")); // Ouro
        gerenciador.adicionarTorcedor(new SocioTorcedor("Mariana Costa", "222.222.222-22", LocalDate.of(1995, 8, 24), planosDisponiveis.get(1), "mari123"));   // Prata
        gerenciador.adicionarTorcedor(new SocioTorcedor("Pedro Santos", "333.333.333-33", LocalDate.of(1988, 12, 5), planosDisponiveis.get(0), "pedro77"));   // Bronze
        gerenciador.adicionarTorcedor(new SocioTorcedor("Julia Souza", "444.444.444-44", LocalDate.of(2000, 3, 18), planosDisponiveis.get(2), "juouro"));     // Ouro
        gerenciador.adicionarTorcedor(new SocioTorcedor("Lucas Oliveira", "555.555.555-55", LocalDate.of(1993, 7, 30), planosDisponiveis.get(1), "luke93"));  // Prata
        gerenciador.adicionarTorcedor(new SocioTorcedor("Beatriz Lima", "666.666.666-66", LocalDate.of(1997, 1, 15), planosDisponiveis.get(0), "bia97"));     // Bronze
        gerenciador.adicionarTorcedor(new SocioTorcedor("André Ribeiro", "777.777.777-77", LocalDate.of(1985, 10, 10), planosDisponiveis.get(2), "andre10")); // Ouro

        // Cadastrando 7 Torcedores Inadimplentes/Inativos
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Fernando Alves", "888.888.888-88", LocalDate.of(1992, 4, 3), "Mensalidade Atrasada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Camila Rocha", "999.999.999-99", LocalDate.of(1996, 11, 21), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Rodrigo Melo", "123.123.123-12", LocalDate.of(1989, 9, 14), "Mensalidade Atrasada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Amanda Nunes", "456.456.456-45", LocalDate.of(2001, 2, 28), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Ricardo Cruz", "789.789.789-78", LocalDate.of(1994, 6, 13), "Conta Bloqueada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Larissa Dias", "147.147.147-14", LocalDate.of(1998, 8, 9), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Gabriel Reis", "258.258.258-25", LocalDate.of(1991, 12, 25), "Mensalidade Atrasada"));

        System.out.println("\n>>> Carga inicial de dados carregada com sucesso! <<<\n");

        // 3. MENU TEXTUAL INTERATIVO (Requisito 7)
        int opcao = 0;
        do {
            System.out.println("========== SISTEMA DE GESTÃO - SÓCIO TORCEDOR ==========");
            System.out.println("1 - Incluir Torcedor");
            System.out.println("2 - Alterar Torcedor");
            System.out.println("3 - Excluir Torcedor");
            System.out.println("4 - Buscar Torcedor por CPF");
            System.out.println("5 - Listar Todos (Formato Tabular)");
            System.out.println("6 - Listar Ordenado por Nome");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0; // Se digitar texto, força opção inválida
            }

            switch (opcao) {
                case 1: // INCLUIR (Requisito 3)
                    System.out.println("\n--- INCLUIR NOVO TORCEDOR ---");
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("CPF: ");
                    String cpf = teclado.nextLine();
                    System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                    String dataStr = teclado.nextLine();
                    LocalDate dataNasc = LocalDate.parse(dataStr, formatadorData);

                    System.out.println("Selecione a situação:");
                    System.out.println("1 - Sócio Torcedor Ativo");
                    System.out.println("2 - Torcedor Inadimplente / Inativo");
                    System.out.print("Opção: ");
                    int tipo = Integer.parseInt(teclado.nextLine());

                    if (tipo == 1) {
                        System.out.println("Escolha um Plano:");
                        for (Plano p : planosDisponiveis) {
                            System.out.println(p.getId() + " - " + p.getNomePlano() + " (R$ " + p.getValorMensalidade() + ")");
                        }
                        System.out.print("ID do Plano: ");
                        int idPlano = Integer.parseInt(teclado.nextLine());
                        Plano planoEscolhido = planosDisponiveis.get(idPlano - 1);

                        System.out.print("Crie uma Senha de Acesso: ");
                        String senha = teclado.nextLine();

                        gerenciador.adicionarTorcedor(new SocioTorcedor(nome, cpf, dataNasc, planoEscolhido, senha));
                    } else {
                        System.out.print("Motivo da Restrição/Inatividade: ");
                        String motivo = teclado.nextLine();
                        gerenciador.adicionarTorcedor(new TorcedorInadimplente(nome, cpf, dataNasc, motivo));
                    }
                    break;

                case 2: // ALTERAR (Requisito 3)
                    System.out.println("\n--- ALTERAR DADOS DO TORCEDOR ---");
                    System.out.print("Digite o CPF do torcedor que deseja alterar: ");
                    String cpfAlterar = teclado.nextLine();
                    Pessoa tAlterar = gerenciador.buscarPorCpf(cpfAlterar);

                    if (tAlterar != null) {
                        System.out.println("Registro encontrado:");
                        tAlterar.exibirDados();
                        System.out.print("\nDigite o novo Nome (ou pressione Enter para manter): ");
                        String novoNome = teclado.nextLine();
                        if (!novoNome.isEmpty()) tAlterar.setNome(novoNome);

                        if (tAlterar instanceof SocioTorcedor) {
                            System.out.println("Deseja alterar o plano? (S/N): ");
                            if (teclado.nextLine().equalsIgnoreCase("S")) {
                                System.out.println("Escolha o novo Plano:");
                                for (Plano p : planosDisponiveis) {
                                    System.out.println(p.getId() + " - " + p.getNomePlano());
                                }
                                System.out.print("ID do Plano: ");
                                int idPlano = Integer.parseInt(teclado.nextLine());
                                tAlterar.setPlano(planosDisponiveis.get(idPlano - 1));
                            }
                        }
                        System.out.println("Dados updated com sucesso!");
                    } else {
                        System.out.println("Torcedor não encontrado.");
                    }
                    break;

                case 3: // EXCLUIR (Requisito 3)
                    System.out.println("\n--- EXCLUIR TORCEDOR ---");
                    System.out.print("Digite o CPF do torcedor a remover: ");
                    String cpfExcluir = teclado.nextLine();
                    if (gerenciador.removerTorcedor(cpfExcluir)) {
                        System.out.println("Torcedor removido do sistema!");
                    } else {
                        System.out.println("Torcedor não encontrado.");
                    }
                    break;

                case 4: // BUSCAR (Requisito 5)
                    System.out.println("\n--- BUSCAR TORCEDOR ---");
                    System.out.print("Digite o CPF procurado: ");
                    String cpfBuscar = teclado.nextLine();
                    Pessoa tBuscado = gerenciador.buscarPorCpf(cpfBuscar);
                    if (tBuscado != null) {
                        System.out.println("\n-------------------------------------------");
                        tBuscado.exibirDados();
                        System.out.println("-------------------------------------------");
                    } else {
                        System.out.println("Torcedor não localizado.");
                    }
                    break;

                case 5: // LISTAR TABULAR (Requisito 4)
                    gerenciador.listarTodos();
                    break;

                case 6: // LISTAR ORDENADO (Requisito 6)
                    gerenciador.listarOrdenadoPorNome();
                    break;

                case 7:
                    System.out.println("\nEncerrando o programa... Obrigado!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
                    break;
            }
        } while (opcao != 7);

        teclado.close();
>>>>>>> parent of b73b73d (desgepetizou)
    }
}