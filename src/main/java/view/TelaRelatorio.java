package view;

import javax.swing.*;
import java.awt.*;
import dao.ProdutoDAO;
import dao.CategoriaDAO;
import dao.MovimentacaoDAO;

import model.Produto;
import model.Categoria;
import model.Movimentacao;

import java.util.List;

public class TelaRelatorio extends JFrame {

    public TelaRelatorio() {

        setTitle("Relatórios - Mercado do Jorge");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // CABEÇALHO
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(0, 51, 102));
        painelTopo.setPreferredSize(new Dimension(900, 80));

        JLabel titulo
                = new JLabel("CENTRAL DE RELATÓRIOS");

        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        20,
                        0,
                        0));

        ImageIcon logoOriginal
                = new ImageIcon("src/view/logo.png");

        Image logoRedimensionada
                = logoOriginal.getImage().getScaledInstance(
                        70,
                        70,
                        Image.SCALE_SMOOTH);

        JLabel logo
                = new JLabel(new ImageIcon(logoRedimensionada));

        painelTopo.add(titulo, BorderLayout.WEST);
        painelTopo.add(logo, BorderLayout.EAST);

        // CENTRO
        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(null);
        painelCentro.setBackground(new Color(245, 245, 245));

        JLabel secao
                = new JLabel("PAINEL GERENCIAL");

        secao.setFont(
                new Font("Arial",
                        Font.BOLD,
                        16));

        secao.setForeground(
                new Color(0, 51, 102));

        secao.setBounds(
                80,
                20,
                300,
                25);

        JLabel subtitulo
                = new JLabel(
                        "Visualize informações importantes do sistema.");

        subtitulo.setBounds(
                80,
                45,
                400,
                20);

        subtitulo.setForeground(Color.GRAY);

        int totalProdutos = 0;
        int totalCategorias = 0;
        int totalMovimentacoes = 0;

        try {

            ProdutoDAO produtoDAO = new ProdutoDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

            totalProdutos = produtoDAO.contarProdutos();
            totalCategorias = categoriaDAO.contarCategorias();
            totalMovimentacoes = movimentacaoDAO.contarMovimentacoes();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao carregar indicadores: "
                    + ex.getMessage()
            );
        }
        // CARDS

        JPanel cardProdutos = criarCard(
        "PRODUTOS",
        String.valueOf(totalProdutos));

        cardProdutos.setBounds(
                80,
                90,
                160,
                100);

        JPanel cardCategorias = criarCard(
        "CATEGORIAS",
        String.valueOf(totalCategorias));

        cardCategorias.setBounds(
                270,
                90,
                160,
                100);

        JPanel cardMovimentacoes = criarCard(
        "MOVIMENTAÇÕES",
        String.valueOf(totalMovimentacoes));

        cardMovimentacoes.setBounds(
                460,
                90,
                160,
                100);

        JPanel cardEstoque = criarCard(
                "ESTOQUE BAIXO",
                "3");

        cardEstoque.setBounds(
                650,
                90,
                160,
                100);

        // BOTÕES
        JButton btnProdutos
                = new JButton("RELATÓRIO PRODUTOS");

        JButton btnCategorias
                = new JButton("RELATÓRIO CATEGORIAS");

        JButton btnEstoque
                = new JButton("RELATÓRIO ESTOQUE");

        JButton btnMovimentacoes
                = new JButton("RELATÓRIO MOVIMENTAÇÕES");

        JButton[] botoes = {
            btnProdutos,
            btnCategorias,
            btnEstoque,
            btnMovimentacoes
        };

        int y = 240;

        for (JButton botao : botoes) {

            botao.setBounds(
                    80,
                    y,
                    280,
                    45);

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

            y += 60;
        }

        JTextArea areaRelatorio
                = new JTextArea();

        areaRelatorio.setEditable(false);

        areaRelatorio.setFont(
                new Font("Monospaced",
                        Font.PLAIN,
                        14));

        JScrollPane scroll
                = new JScrollPane(areaRelatorio);

        scroll.setBounds(
                400,
                240,
                410,
                260);

        // EVENTOS
       btnProdutos.addActionListener(e -> {
    try {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("RELATÓRIO DE PRODUTOS\n\n");

        for (Produto p : produtos) {
            sb.append("ID: ").append(p.getId())
              .append(" | Nome: ").append(p.getNome())
              .append(" | Preço: R$ ").append(p.getPrecoUnitario())
              .append(" | Estoque: ").append(p.getQuantidadeEstoque())
              .append("\n");
        }

        areaRelatorio.setText(sb.toString());

    } catch (Exception ex) {
        areaRelatorio.setText("Erro ao gerar relatório de produtos: " + ex.getMessage());
    }
});

        btnCategorias.addActionListener(e -> {
    try {
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> categorias = dao.listarTodas();

        StringBuilder sb = new StringBuilder();
        sb.append("RELATÓRIO DE CATEGORIAS\n\n");

        for (Categoria c : categorias) {
            sb.append("ID: ").append(c.getId())
              .append(" | Nome: ").append(c.getNome())
              .append(" | Tamanho: ").append(c.getTamanho())
              .append(" | Embalagem: ").append(c.getEmbalagem())
              .append("\n");
        }

        areaRelatorio.setText(sb.toString());

    } catch (Exception ex) {
        areaRelatorio.setText("Erro ao gerar relatório de categorias: " + ex.getMessage());
    }
});
        btnEstoque.addActionListener(e -> {
    try {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("PRODUTOS COM ESTOQUE BAIXO\n\n");

        for (Produto p : produtos) {
            if (p.getQuantidadeEstoque() <= p.getQuantidadeMinima()) {
                sb.append("ID: ").append(p.getId())
                  .append(" | Nome: ").append(p.getNome())
                  .append(" | Estoque: ").append(p.getQuantidadeEstoque())
                  .append(" | Mínimo: ").append(p.getQuantidadeMinima())
                  .append("\n");
            }
        }

        areaRelatorio.setText(sb.toString());

    } catch (Exception ex) {
        areaRelatorio.setText("Erro ao gerar relatório de estoque: " + ex.getMessage());
    }
});

        btnMovimentacoes.addActionListener(e -> {
    try {
        MovimentacaoDAO dao = new MovimentacaoDAO();
        List<Movimentacao> movimentacoes = dao.listarTodas();

        StringBuilder sb = new StringBuilder();
        sb.append("RELATÓRIO DE MOVIMENTAÇÕES\n\n");

        for (Movimentacao m : movimentacoes) {
            sb.append("ID: ").append(m.getId())
              .append(" | Produto ID: ").append(m.getProdutoId())
              .append(" | Tipo: ").append(m.getTipoMovimentacao())
              .append(" | Quantidade: ").append(m.getQuantidade())
              .append(" | Data: ").append(m.getDataMovimentacao())
              .append("\n");
        }

        areaRelatorio.setText(sb.toString());

    } catch (Exception ex) {
        areaRelatorio.setText("Erro ao gerar relatório de movimentações: " + ex.getMessage());
    }
});

        // COMPONENTES
        painelCentro.add(secao);
        painelCentro.add(subtitulo);

        painelCentro.add(cardProdutos);
        painelCentro.add(cardCategorias);
        painelCentro.add(cardMovimentacoes);
        painelCentro.add(cardEstoque);

        painelCentro.add(scroll);

        // RODAPÉ
        JLabel rodape
                = new JLabel(
                        "Mercado do Jorge © 2026 | Central de Relatórios",
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

    private JPanel criarCard(
            String titulo,
            String valor) {

        JPanel card = new JPanel();

        card.setLayout(
                new GridLayout(2, 1));

        card.setBackground(
                Color.WHITE);

        card.setBorder(
                BorderFactory.createLineBorder(
                        new Color(0, 51, 102),
                        2));

        JLabel lblTitulo
                = new JLabel(
                        titulo,
                        SwingConstants.CENTER);

        lblTitulo.setFont(
                new Font("Arial",
                        Font.BOLD,
                        14));

        JLabel lblValor
                = new JLabel(
                        valor,
                        SwingConstants.CENTER);

        lblValor.setFont(
                new Font("Arial",
                        Font.BOLD,
                        28));

        lblValor.setForeground(
                new Color(255, 122, 0));

        card.add(lblTitulo);
        card.add(lblValor);

        return card;
    }
}
