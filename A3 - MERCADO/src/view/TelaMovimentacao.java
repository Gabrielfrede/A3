package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaMovimentacao extends JFrame {

    public TelaMovimentacao() {

        setTitle("Movimentações de Estoque - Mercado do Jorge");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // CABEÇALHO
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(0, 51, 102));
        painelTopo.setPreferredSize(new Dimension(900, 80));

        JLabel titulo = new JLabel("CONTROLE DE MOVIMENTAÇÕES");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        ImageIcon logoOriginal =
                new ImageIcon("src/imagens/logo.png");

        Image logoRedimensionada =
                logoOriginal.getImage().getScaledInstance(
                        70,
                        70,
                        Image.SCALE_SMOOTH);

        JLabel logo =
                new JLabel(new ImageIcon(logoRedimensionada));

        painelTopo.add(titulo, BorderLayout.WEST);
        painelTopo.add(logo, BorderLayout.EAST);

        // CENTRO
        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(null);
        painelCentro.setBackground(new Color(245, 245, 245));

        JLabel secao =
                new JLabel("REGISTRO DE MOVIMENTAÇÕES");

        secao.setFont(new Font("Arial", Font.BOLD, 16));
        secao.setForeground(new Color(0, 51, 102));
        secao.setBounds(80, 20, 300, 25);

        JLabel subtitulo =
                new JLabel("Controle entradas e saídas de produtos.");

        subtitulo.setBounds(80, 45, 350, 20);
        subtitulo.setForeground(Color.GRAY);

        // PRODUTO
        JLabel lblProduto =
                new JLabel("Produto:");

        lblProduto.setBounds(80, 90, 200, 25);

        JComboBox<String> cbProduto =
                new JComboBox<>();

        cbProduto.addItem("Arroz 5kg");
        cbProduto.addItem("Feijão 1kg");
        cbProduto.addItem("Coca-Cola 2L");
        cbProduto.addItem("Detergente");
        cbProduto.addItem("Sabonete");

        cbProduto.setBounds(80, 115, 300, 35);

        // TIPO
        JLabel lblTipo =
                new JLabel("Tipo de Movimentação:");

        lblTipo.setBounds(450, 90, 200, 25);

        JRadioButton rbEntrada =
                new JRadioButton("Entrada");

        JRadioButton rbSaida =
                new JRadioButton("Saída");

        rbEntrada.setBackground(new Color(245,245,245));
        rbSaida.setBackground(new Color(245,245,245));

        rbEntrada.setSelected(true);

        ButtonGroup grupo =
                new ButtonGroup();

        grupo.add(rbEntrada);
        grupo.add(rbSaida);

        rbEntrada.setBounds(450, 115, 100, 30);
        rbSaida.setBounds(560, 115, 100, 30);

        // QUANTIDADE
        JLabel lblQuantidade =
                new JLabel("Quantidade:");

        lblQuantidade.setBounds(80, 180, 200, 25);

        JTextField txtQuantidade =
                new JTextField();

        txtQuantidade.setBounds(80, 205, 200, 35);

        // DATA
        JLabel lblData =
                new JLabel("Data:");

        lblData.setBounds(450, 180, 200, 25);

        JTextField txtData =
                new JTextField("09/06/2026");

        txtData.setBounds(450, 205, 200, 35);

        // LINHA
        JSeparator linha =
                new JSeparator();

        linha.setBounds(80, 280, 700, 2);

        // BOTÕES
        JButton btnRegistrar =
                new JButton("REGISTRAR");

        JButton btnExcluir =
                new JButton("EXCLUIR");

        JButton btnLimpar =
                new JButton("LIMPAR");

        JButton[] botoes = {
                btnRegistrar,
                btnExcluir,
                btnLimpar
        };

        int x = 140;

        for (JButton botao : botoes) {

            botao.setBounds(x, 310, 170, 45);

            botao.setBackground(
                    new Color(255, 122, 0));

            botao.setForeground(Color.WHITE);

            botao.setFont(
                    new Font("Arial",
                            Font.BOLD,
                            13));

            botao.setFocusPainted(false);

            botao.setCursor(
                    new Cursor(Cursor.HAND_CURSOR));

            painelCentro.add(botao);

            x += 190;
        }

        // TABELA

        String[] colunas = {
                "ID",
                "Produto",
                "Tipo",
                "Quantidade",
                "Data"
        };

        DefaultTableModel modelo =
                new DefaultTableModel(
                        colunas,
                        0);

        JTable tabela =
                new JTable(modelo);

        tabela.setRowHeight(28);

        tabela.getTableHeader().setBackground(
                new Color(0, 51, 102));

        tabela.getTableHeader().setForeground(
                Color.WHITE);

        tabela.getTableHeader().setFont(
                new Font("Arial",
                        Font.BOLD,
                        13));

        JPanel painelTabela =
                new JPanel(new BorderLayout());

        painelTabela.setBounds(
                80,
                390,
                700,
                180);

        painelTabela.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(0, 51, 102),
                                2),
                        "Histórico de Movimentações"
                ));

        JScrollPane scrollTabela =
                new JScrollPane(tabela);

        painelTabela.add(
                scrollTabela,
                BorderLayout.CENTER);

        // REGISTRAR

        btnRegistrar.addActionListener(e -> {

            if(txtQuantidade.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Informe a quantidade."
                );

                return;
            }

            String tipo =
                    rbEntrada.isSelected()
                            ? "Entrada"
                            : "Saída";

            modelo.addRow(new Object[] {
                    tabela.getRowCount() + 1,
                    cbProduto.getSelectedItem(),
                    tipo,
                    txtQuantidade.getText(),
                    txtData.getText()
            });

            JOptionPane.showMessageDialog(
                    null,
                    "Movimentação registrada!"
            );
        });

        // EXCLUIR

        btnExcluir.addActionListener(e -> {

            int linhaSelecionada =
                    tabela.getSelectedRow();

            if(linhaSelecionada >= 0) {

                modelo.removeRow(
                        linhaSelecionada);

                JOptionPane.showMessageDialog(
                        null,
                        "Movimentação removida!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Selecione uma movimentação."
                );
            }
        });

        // LIMPAR

        btnLimpar.addActionListener(e -> {

            txtQuantidade.setText("");
            rbEntrada.setSelected(true);
        });

        // COMPONENTES

        painelCentro.add(secao);
        painelCentro.add(subtitulo);

        painelCentro.add(lblProduto);
        painelCentro.add(cbProduto);

        painelCentro.add(lblTipo);
        painelCentro.add(rbEntrada);
        painelCentro.add(rbSaida);

        painelCentro.add(lblQuantidade);
        painelCentro.add(txtQuantidade);

        painelCentro.add(lblData);
        painelCentro.add(txtData);

        painelCentro.add(linha);

        painelCentro.add(painelTabela);

        // RODAPÉ

        JLabel rodape =
                new JLabel(
                        "Mercado do Jorge © 2026 | Controle de Movimentações",
                        SwingConstants.CENTER);

        rodape.setForeground(Color.GRAY);

        rodape.setFont(
                new Font("Arial",
                        Font.PLAIN,
                        12));

        painelPrincipal.add(
                painelTopo,
                BorderLayout.NORTH);

        painelPrincipal.add(
                painelCentro,
                BorderLayout.CENTER);

        painelPrincipal.add(
                rodape,
                BorderLayout.SOUTH);

        add(painelPrincipal);
    }
}
