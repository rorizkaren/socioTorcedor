package aplicacao;

import javax.swing.SwingUtilities;

public class Programa {
    public static void main(String[] args) {
        // Uso do Swing para criação da interface gráfica de forma segura
        SwingUtilities.invokeLater(new Runnable() { 
            @Override
            public void run() {
                new TelaSistema();
            }
<<<<<<< HEAD
        });
=======

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

                        gerenciador.adicionarTorcedor(new SocioTorcedor(nome, cpf, dataNasc, planoEscolhido, senha));
                        System.out.println("Torcedor cadastrado com sucesso!");
                        System.out.println("");

                    } else {
                        System.out.print("Motivo da Restrição/Inatividade: ");
                        String motivo = teclado.nextLine();
                        gerenciador.adicionarTorcedor(new TorcedorInadimplente(nome, cpf, dataNasc, motivo));
                        System.out.println("Torcedor cadastrado com sucesso!");
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
>>>>>>> parent of dd6a798 (correção print)
    }
}