package aplicacao;
import entidades.Pessoa;
import entidades.Plano;
import entidades.SocioTorcedor;
import entidades.TorcedorInadimplente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;



// interface do usuario
public class Programa {
    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[1;34m";
    public static final String BRANCO = "\u001B[1;37m";
    public static final String CINZA = "\u001B[1;90m";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Gerenciamento gerenciador = new Gerenciamento();
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // planos dispniveis 
        ArrayList<Plano> plano = new ArrayList<>();
        plano.add(new Plano(1, "Bronze", 15.00, 10.0, "10% de desc. em ingressos")); 
        plano.add(new Plano(2, "Prata", 35.00, 30.0, "30% de desc. e acesso prioritário 2"));  
        plano.add(new Plano(3, "Ouro", 60.00, 50.0, "50% de desc. e acesso prioritário total"));   

        // Cadastra pelo menos 7 objetos de cada classe
        
        // Cadastrando 7 Sócios Torcedores Ativos
        gerenciador.adicionarTorcedor(new SocioTorcedor("Carlos Silva", "111.111.111-11", LocalDate.of(1990, 5, 12), plano.get(2), "senha123")); // Ouro
        gerenciador.adicionarTorcedor(new SocioTorcedor("Mariana Costa", "222.222.222-22", LocalDate.of(1995, 8, 24), plano.get(1), "mari123"));   // Prata
        gerenciador.adicionarTorcedor(new SocioTorcedor("Pedro Santos", "333.333.333-33", LocalDate.of(1988, 12, 5), plano.get(0), "pedro77"));   // Bronze
        gerenciador.adicionarTorcedor(new SocioTorcedor("Julia Souza", "444.444.444-44", LocalDate.of(2000, 3, 18), plano.get(2), "juouro"));     // Ouro
        gerenciador.adicionarTorcedor(new SocioTorcedor("Lucas Oliveira", "555.555.555-55", LocalDate.of(1993, 7, 30), plano.get(1), "luke93"));  // Prata
        gerenciador.adicionarTorcedor(new SocioTorcedor("Beatriz Lima", "666.666.666-66", LocalDate.of(1997, 1, 15), plano.get(0), "bia97"));     // Bronze
        gerenciador.adicionarTorcedor(new SocioTorcedor("André Ribeiro", "777.777.777-77", LocalDate.of(1985, 10, 10), plano.get(2), "andre10")); // Ouro

        // Cadastrando 7 Torcedores Inadimplentes/Inativos
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Fernando Alves", "888.888.888-88", LocalDate.of(1992, 4, 3), "Mensalidade Atrasada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Camila Rocha", "999.999.999-99", LocalDate.of(1996, 11, 21), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Rodrigo Melo", "123.123.123-12", LocalDate.of(1989, 9, 14), "Mensalidade Atrasada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Amanda Nunes", "456.456.456-45", LocalDate.of(2001, 2, 28), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Ricardo Cruz", "789.789.789-78", LocalDate.of(1994, 6, 13), "Conta Bloqueada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Larissa Dias", "147.147.147-14", LocalDate.of(1998, 8, 9), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Gabriel Reis", "258.258.258-25", LocalDate.of(1991, 12, 25), "Mensalidade Atrasada"));


        // Cabeçalho Temático Tricolor
        System.out.println(AZUL + "============================================" + RESET);
        System.out.println(AZUL + "▒▒▒" + RESET + "  " + BRANCO + "SISTEMA DE GESTÃO - SÓCIO TORCEDOR" + RESET + "  " + AZUL + "▒▒▒" + RESET);
        System.out.println(AZUL + "▒▒▒" + RESET + "  " + BRANCO + "            GRÊMIO FBPA           " + RESET + "  " + AZUL + "▒▒▒" + RESET);
        System.out.println(AZUL + "============================================" + RESET);
        System.out.println(BRANCO + "Carga inicial de dados carregada com sucesso!" + RESET + "\n");


        // menu
        int opcao = 0;
        do {
            System.out.println(AZUL + "SELCIONE A AÇÃO DESEJADA " + RESET + "\n");
            System.out.println("1 - Incluir Torcedor");
            System.out.println("2 - Alterar Torcedor");
            System.out.println("3 - Excluir Torcedor");
            System.out.println("4 - Buscar Torcedor por CPF");
            System.out.println("5 - Listar Todos (Formato Tabular)");
            System.out.println("6 - Listar Ordenado por Nome");
            System.out.println("7 - Sair\n");
            System.out.print("DIGITE: ");
            
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0; 
            }

            switch (opcao) {
                case 1: // INCLUIR 
                System.out.println("\nINCLUIR NOVO TORCEDOR \n");

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

                    for (Plano p : plano) {
                        System.out.println(p.getId() + " - " + p.getNomePlano() + " (R$ " + p.getValorMensalidade() + ")");
                    }

                    System.out.print("ID do Plano: ");
                    int idPlano = Integer.parseInt(teclado.nextLine());
                    Plano planoEscolhido = plano.get(idPlano - 1);

                    System.out.print("Crie uma Senha de Acesso: ");
                    String senha = teclado.nextLine();

                    boolean cadastrado = gerenciador.adicionarTorcedor(
                        new SocioTorcedor(nome, cpf, dataNasc, planoEscolhido, senha)
                    );

                    if (cadastrado) {
                        System.out.println("Torcedor cadastrado com sucesso!");
                    }

                    System.out.println("");

                } else {
                    System.out.print("Motivo da Restrição/Inatividade: ");
                    String motivo = teclado.nextLine();

                    boolean cadastrado = gerenciador.adicionarTorcedor(
                        new TorcedorInadimplente(nome, cpf, dataNasc, motivo)
                    );

                    if (cadastrado) {
                        System.out.println("Torcedor cadastrado com sucesso!");
                    }

                    System.out.println("");
                }

                break;

                case 2: // ALTERAR 
                    System.out.println("\n ALTERAR DADOS DO TORCEDOR\n");
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
                                for (Plano p : plano) {
                                    System.out.println(p.getId() + " - " + p.getNomePlano());
                                }
                                System.out.print("ID do Plano: ");
                                int idPlano = Integer.parseInt(teclado.nextLine());
                                tAlterar.setPlano(plano.get(idPlano - 1));
                            }
                        }
                        System.out.println("Dados atualizados com sucesso!");
                    } else {
                        System.out.println("Torcedor não encontrado.");
                    }
                    break;

                case 3: // EXCLUIR (Requisito 3)
                    System.out.println("\n-EXCLUIR TORCEDOR-");
                    System.out.print("Digite o CPF do torcedor a remover: ");
                    String cpfExcluir = teclado.nextLine();
                    if (gerenciador.removerTorcedor(cpfExcluir)) {
                        System.out.println("Torcedor removido do sistema!");
                    } else {
                        System.out.println("Torcedor não encontrado.");
                    }
                    break;

                case 4: // BUSCAR 
                    System.out.println("\n-BUSCAR TORCEDOR-");
                    System.out.print("Digite o CPF procurado: ");
                    String cpfBuscar = teclado.nextLine();
                    Pessoa tBuscado = gerenciador.buscarPorCpf(cpfBuscar);
                    if (tBuscado != null) {
                        System.out.println("DADOS:");
                        tBuscado.exibirDados();
                    } else {
                        System.out.println("Torcedor não localizado.");
                    }
                    break;

                case 5: // lista tabular
                    gerenciador.listarTodos();
                    System.out.println("");
                    break;

                case 6: // lista ordenado
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
    }
}