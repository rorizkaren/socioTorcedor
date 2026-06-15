package aplicacao;

import entidades.Pessoa;
import entidades.Plano;
import entidades.SocioTorcedor;
import entidades.TorcedorInadimplente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TelaSistema extends JFrame {

    // Dependência de controle e listas auxiliares
    private Gerenciamento gerenciador;
    private ArrayList<Plano> planos;
    private DateTimeFormatter formatadorData;

    // Componentes de Entrada de Dados (Formulário)
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoData;
    private JTextField campoSenhaMotivo;

    // Componentes de Seleção Dinâmica
    private JComboBox<String> comboTipo;
    private JComboBox<Plano> comboPlano;

    private JLabel labelSenhaMotivo;

    // Componentes de Exibição de Dados em Memória
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    // Construtor da tela sistema, carregamento de regras de negócio
    public TelaSistema() {
        gerenciador = new Gerenciamento();
        planos = new ArrayList<>();
        formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        carregarPlanos();
        carregarDadosIniciais();

        configurarJanela();
        montarTela();

        // Inicializa a tabela visível na interface carregando a memória de dados
        atualizarTabela(gerenciador.getListaTorcedores());

        setVisible(true);
    }

    private void configurarJanela() {
        setTitle("Sistema de Gestão - Sócio Torcedor");
        setSize(1200, 700);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void carregarPlanos() {
        planos.add(new Plano(1, "Bronze", 15.00, 10.0, "10% de desc. em ingressos"));
        planos.add(new Plano(2, "Prata", 35.00, 30.0, "30% de desc. e acesso prioritário 2"));
        planos.add(new Plano(3, "Ouro", 60.00, 50.0, "50% de desc. e acesso prioritário total"));
    }

    // Aqui temos o requisito de carregar inicialmente 7 objetos, como temos dois tipos de objetos, criamos 7 de cada
    private void carregarDadosIniciais() {
        gerenciador.adicionarTorcedor(new SocioTorcedor("Carlos Silva", "111.111.111-11", LocalDate.of(1990, 5, 12), planos.get(2), "senha123"));
        gerenciador.adicionarTorcedor(new SocioTorcedor("Mariana Costa", "222.222.222-22", LocalDate.of(1995, 8, 24), planos.get(1), "mari123"));
        gerenciador.adicionarTorcedor(new SocioTorcedor("Pedro Santos", "333.333.333-33", LocalDate.of(1988, 12, 5), planos.get(0), "pedro77"));
        gerenciador.adicionarTorcedor(new SocioTorcedor("Julia Souza", "444.444.444-44", LocalDate.of(2000, 3, 18), planos.get(2), "juouro"));
        gerenciador.adicionarTorcedor(new SocioTorcedor("Lucas Oliveira", "555.555.555-55", LocalDate.of(1993, 7, 30), planos.get(1), "luke93"));
        gerenciador.adicionarTorcedor(new SocioTorcedor("Beatriz Lima", "666.666.666-66", LocalDate.of(1997, 1, 15), planos.get(0), "bia97"));
        gerenciador.adicionarTorcedor(new SocioTorcedor("André Ribeiro", "777.777.777-77", LocalDate.of(1985, 10, 10), planos.get(2), "andre10"));

        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Fernando Alves", "888.888.888-88", LocalDate.of(1992, 4, 3), "Mensalidade Atrasada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Camila Rocha", "999.999.999-99", LocalDate.of(1996, 11, 21), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Rodrigo Melo", "123.123.123-12", LocalDate.of(1989, 9, 14), "Mensalidade Atrasada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Amanda Nunes", "456.456.456-45", LocalDate.of(2001, 2, 28), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Ricardo Cruz", "789.789.789-78", LocalDate.of(1994, 6, 13), "Conta Bloqueada"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Larissa Dias", "147.147.147-14", LocalDate.of(1998, 8, 9), "Sem Plano Ativo"));
        gerenciador.adicionarTorcedor(new TorcedorInadimplente("Gabriel Reis", "258.258.258-25", LocalDate.of(1991, 12, 25), "Mensalidade Atrasada"));
    }

    // Daqui pra baixo temos a parte da interface gráfica
    // Todo o gerenciamento de buscarTorcedor, adicionar, etc está no Gerenciamento.Java
    // Oq tem aqui é só pra capturar, depois é passado para lá
    private void montarTela() {
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Sistema de Gestão - Sócio Torcedor", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Torcedor"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);

        campoNome = new JTextField(22);
        campoCpf = new JTextField(22);
        campoData = new JTextField(22);
        campoSenhaMotivo = new JTextField(22);

        comboTipo = new JComboBox<>(new String[]{"Sócio Torcedor Ativo", "Torcedor Inadimplente/Inativo"});
        comboPlano = new JComboBox<>();

        for (Plano p : planos) {
            comboPlano.addItem(p);
        }

        comboPlano.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus
            ) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof Plano) {
                    Plano p = (Plano) value;
                    setText(p.getNomePlano() + " - R$ " + p.getValorMensalidade());
                }

                return this;
            }
        });

        labelSenhaMotivo = new JLabel("Senha:");

        JLabel imagemGremio = criarImagemGremio();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        painelFormulario.add(imagemGremio, gbc);

        adicionarLinha(painelFormulario, gbc, 1, "Nome:", campoNome);
        adicionarLinha(painelFormulario, gbc, 2, "CPF:", campoCpf);
        adicionarLinha(painelFormulario, gbc, 3, "Nascimento:", campoData);
        adicionarLinha(painelFormulario, gbc, 4, "Tipo:", comboTipo);
        adicionarLinha(painelFormulario, gbc, 5, "Plano:", comboPlano);
        adicionarLinha(painelFormulario, gbc, 6, labelSenhaMotivo, campoSenhaMotivo);

        comboTipo.addActionListener(e -> atualizarCampoPorTipo());

        JPanel painelBotoes = new JPanel(new GridLayout(2, 4, 8, 8));

        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoBuscar = new JButton("Buscar CPF");
        JButton botaoAlterar = new JButton("Alterar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoListar = new JButton("Listar Todos");
        JButton botaoOrdenar = new JButton("Ordenar por Nome");
        JButton botaoSair = new JButton("Sair");

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoBuscar);
        painelBotoes.add(botaoAlterar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoListar);
        painelBotoes.add(botaoOrdenar);
        painelBotoes.add(botaoSair);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        painelFormulario.add(painelBotoes, gbc);

        String[] colunas = {"Nome", "CPF", "Nascimento", "Tipo", "Plano", "Desconto", "Detalhes"};

        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela = new JTable(modeloTabela);
        tabela.setRowHeight(24);

        JScrollPane scrollTabela = new JScrollPane(tabela);
        scrollTabela.setBorder(BorderFactory.createTitledBorder("Torcedores Cadastrados"));

        painelPrincipal.add(painelFormulario, BorderLayout.WEST);
        painelPrincipal.add(scrollTabela, BorderLayout.CENTER);

        add(painelPrincipal);

        botaoCadastrar.addActionListener(e -> cadastrarTorcedor());
        botaoBuscar.addActionListener(e -> buscarTorcedor());
        botaoAlterar.addActionListener(e -> alterarTorcedor());
        botaoExcluir.addActionListener(e -> excluirTorcedor());
        botaoLimpar.addActionListener(e -> limparCampos());
        botaoListar.addActionListener(e -> atualizarTabela(gerenciador.getListaTorcedores()));
        botaoOrdenar.addActionListener(e -> listarOrdenadoPorNome());
        botaoSair.addActionListener(e -> System.exit(0));

        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                preencherCamposPelaTabela();
            }
        });
    }

    private JLabel criarImagemGremio() {
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(360, 180));
        label.setBorder(BorderFactory.createTitledBorder("Grêmio FBPA"));

        ImageIcon iconeOriginal = new ImageIcon("imagens/gremio.png");

        if (iconeOriginal.getIconWidth() > 0) {
            Image imagem = iconeOriginal.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(imagem));
        } else {
            label.setText("Imagem não encontrada: imagens/gremio.png");
        }

        return label;
    }

    private void adicionarLinha(JPanel painel, GridBagConstraints gbc, int linha, String texto, JComponent campo) {
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;

        painel.add(new JLabel(texto), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        painel.add(campo, gbc);
    }

    private void adicionarLinha(JPanel painel, GridBagConstraints gbc, int linha, JLabel label, JComponent campo) {
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;

        painel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        painel.add(campo, gbc);
    }

    private void atualizarCampoPorTipo() {
        int tipoSelecionado = comboTipo.getSelectedIndex();

        if (tipoSelecionado == 0) {
            labelSenhaMotivo.setText("Senha:");
            comboPlano.setEnabled(true);
        } else {
            labelSenhaMotivo.setText("Motivo:");
            comboPlano.setEnabled(false);
        }
    }

    private void cadastrarTorcedor() {
        try {
            String nome = campoNome.getText().trim();
            String cpf = campoCpf.getText().trim();
            String dataTexto = campoData.getText().trim();
            String senhaMotivo = campoSenhaMotivo.getText().trim();

            if (nome.isEmpty() || cpf.isEmpty() || dataTexto.isEmpty() || senhaMotivo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
                return;
            }

            LocalDate dataNascimento = LocalDate.parse(dataTexto, formatadorData);

            boolean cadastrado;

            if (comboTipo.getSelectedIndex() == 0) {
                Plano planoEscolhido = (Plano) comboPlano.getSelectedItem();

                cadastrado = gerenciador.adicionarTorcedor(
                        new SocioTorcedor(nome, cpf, dataNascimento, planoEscolhido, senhaMotivo)
                );
            } else {
                cadastrado = gerenciador.adicionarTorcedor(
                        new TorcedorInadimplente(nome, cpf, dataNascimento, senhaMotivo)
                );
            }

            if (cadastrado) {
                JOptionPane.showMessageDialog(this, "Torcedor cadastrado com sucesso!");
                limparCampos();
                atualizarTabela(gerenciador.getListaTorcedores());
            } else {
                JOptionPane.showMessageDialog(this, "Erro: já existe um torcedor cadastrado com este CPF.");
            }

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/mm/aaaa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar torcedor.");
        }
    }

    private void buscarTorcedor() {
        String cpf = campoCpf.getText().trim();

        if (cpf.isEmpty()) {
            cpf = JOptionPane.showInputDialog(this, "Digite o CPF do torcedor:");
        }

        if (cpf == null || cpf.trim().isEmpty()) {
            return;
        }

        Pessoa torcedor = gerenciador.buscarPorCpf(cpf.trim());

        if (torcedor != null) {
            preencherCampos(torcedor);

            ArrayList<Pessoa> resultado = new ArrayList<>();
            resultado.add(torcedor);
            atualizarTabela(resultado);

            JOptionPane.showMessageDialog(this, "Torcedor encontrado!");
        } else {
            JOptionPane.showMessageDialog(this, "Torcedor não encontrado.");
        }
    }

    private void alterarTorcedor() {
        try {
            String cpf = campoCpf.getText().trim();

            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe o CPF do torcedor que deseja alterar.");
                return;
            }

            Pessoa torcedor = gerenciador.buscarPorCpf(cpf);

            if (torcedor == null) {
                JOptionPane.showMessageDialog(this, "Torcedor não encontrado.");
                return;
            }

            String novoNome = campoNome.getText().trim();
            String novaDataTexto = campoData.getText().trim();
            String senhaMotivo = campoSenhaMotivo.getText().trim();

            if (!novoNome.isEmpty()) {
                torcedor.setNome(novoNome);
            }

            if (!novaDataTexto.isEmpty()) {
                LocalDate novaData = LocalDate.parse(novaDataTexto, formatadorData);
                torcedor.setDataNascimento(novaData);
            }

            if (torcedor instanceof SocioTorcedor) {
                Plano novoPlano = (Plano) comboPlano.getSelectedItem();
                torcedor.setPlano(novoPlano);

                if (!senhaMotivo.isEmpty()) {
                    ((SocioTorcedor) torcedor).setSenha(senhaMotivo);
                }
            }

            if (torcedor instanceof TorcedorInadimplente) {
                if (!senhaMotivo.isEmpty()) {
                    ((TorcedorInadimplente) torcedor).setMotivoRestricao(senhaMotivo);
                }
            }

            JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
            atualizarTabela(gerenciador.getListaTorcedores());

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/mm/aaaa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar torcedor.");
        }
    }

    private void excluirTorcedor() {
        String cpf = campoCpf.getText().trim();

        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o CPF do torcedor que deseja excluir.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir este torcedor?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            boolean removido = gerenciador.removerTorcedor(cpf);

            if (removido) {
                JOptionPane.showMessageDialog(this, "Torcedor removido com sucesso!");
                limparCampos();
                atualizarTabela(gerenciador.getListaTorcedores());
            } else {
                JOptionPane.showMessageDialog(this, "Torcedor não encontrado.");
            }
        }
    }

    private void listarOrdenadoPorNome() {
        ArrayList<Pessoa> listaOrdenada = new ArrayList<>(gerenciador.getListaTorcedores());

        Collections.sort(listaOrdenada, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return p1.getNome().compareToIgnoreCase(p2.getNome());
            }
        });

        atualizarTabela(listaOrdenada);
    }

    private void atualizarTabela(ArrayList<Pessoa> lista) {
        modeloTabela.setRowCount(0);

        for (Pessoa t : lista) {
            String data = t.getDataNascimento().format(formatadorData);
            String plano = t.getPlano().getNomePlano();
            String desconto = String.format("%.0f%%", t.Desconto());
            String detalhes;

            if (t instanceof SocioTorcedor) {
                detalhes = "Senha cadastrada";
            } else if (t instanceof TorcedorInadimplente) {
                detalhes = ((TorcedorInadimplente) t).getMotivoRestricao();
            } else {
                detalhes = "-";
            }

            modeloTabela.addRow(new Object[]{
                    t.getNome(),
                    t.getCpf(),
                    data,
                    t.tipoTorcedor(),
                    plano,
                    desconto,
                    detalhes
            });
        }
    }

    private void preencherCamposPelaTabela() {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            String cpf = modeloTabela.getValueAt(linha, 1).toString();
            Pessoa torcedor = gerenciador.buscarPorCpf(cpf);

            if (torcedor != null) {
                preencherCampos(torcedor);
            }
        }
    }

    private void preencherCampos(Pessoa torcedor) {
        campoNome.setText(torcedor.getNome());
        campoCpf.setText(torcedor.getCpf());
        campoData.setText(torcedor.getDataNascimento().format(formatadorData));

        if (torcedor instanceof SocioTorcedor) {
            comboTipo.setSelectedIndex(0);
            comboPlano.setEnabled(true);
            comboPlano.setSelectedItem(torcedor.getPlano());
            labelSenhaMotivo.setText("Senha:");
            campoSenhaMotivo.setText(((SocioTorcedor) torcedor).getSenha());
        } else if (torcedor instanceof TorcedorInadimplente) {
            comboTipo.setSelectedIndex(1);
            comboPlano.setEnabled(false);
            labelSenhaMotivo.setText("Motivo:");
            campoSenhaMotivo.setText(((TorcedorInadimplente) torcedor).getMotivoRestricao());
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCpf.setText("");
        campoData.setText("");
        campoSenhaMotivo.setText("");
        comboTipo.setSelectedIndex(0);
        comboPlano.setSelectedIndex(0);
        comboPlano.setEnabled(true);
        labelSenhaMotivo.setText("Senha:");
        tabela.clearSelection();
    }
}