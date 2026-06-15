package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Mercado do Jorge");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // CABEÇALHO
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(0, 51, 102));
        painelTopo.setPreferredSize(new Dimension(900, 90));

        JLabel titulo = new JLabel("MERCADO DO JORGE");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        painelTopo.add(titulo, BorderLayout.CENTER);

        // MENU LATERAL
        JPanel menu = new JPanel();
        menu.setBackground(new Color(245, 245, 245));
        menu.setPreferredSize(new Dimension(220, 0));
        menu.setLayout(new GridLayout(5, 1, 8, 8));

        JButton btnProdutos = new JButton("PRODUTOS");
        JButton btnCategorias = new JButton("CATEGORIAS");
        JButton btnMovimentacoes = new JButton("MOVIMENTAÇÕES");
        JButton btnRelatorios = new JButton("RELATÓRIOS");
        JButton btnSair = new JButton("SAIR");

        JButton[] botoes = {
                btnProdutos,
                btnCategorias,
                btnMovimentacoes,
                btnRelatorios,
                btnSair
        };

        for (JButton botao : botoes) {

            botao.setBackground(new Color(255, 122, 0));
            botao.setForeground(Color.WHITE);
            botao.setFont(new Font("Arial", Font.BOLD, 15));
            botao.setFocusPainted(false);
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

            menu.add(botao);
        }

        // FUNCIONALIDADES DOS BOTÕES

        btnProdutos.addActionListener(e -> {

            TelaProduto tela = new TelaProduto();
            tela.setVisible(true);

        });

        btnCategorias.addActionListener(e -> {

            TelaCategoria tela = new TelaCategoria();
            tela.setVisible(true);

        });

      btnMovimentacoes.addActionListener(e -> {

    TelaMovimentacao tela =
            new TelaMovimentacao();

    tela.setVisible(true);

});

   btnRelatorios.addActionListener(e -> {

    TelaRelatorio tela =
            new TelaRelatorio();

    tela.setVisible(true);

});
        btnSair.addActionListener(e -> {

            dispose();

            LoginFrame login = new LoginFrame();
            login.setVisible(true);

        });

        // ÁREA CENTRAL
        JPanel centro = new JPanel();
        centro.setBackground(Color.WHITE);
        centro.setLayout(null);

        ImageIcon logoOriginal =
                new ImageIcon("src/imagens/logo.png");

        Image logoRedimensionada =
                logoOriginal.getImage().getScaledInstance(
                        250,
                        250,
                        Image.SCALE_SMOOTH);

        JLabel logo =
                new JLabel(new ImageIcon(logoRedimensionada));

        logo.setBounds(210, 10, 250, 250);

        JLabel boasVindas =
                new JLabel("Bem-vindo ao Mercado do Jorge");

        boasVindas.setFont(
                new Font("Arial", Font.BOLD, 24));

        boasVindas.setBounds(160, 250, 450, 35);

        JLabel descricao1 =
                new JLabel("Sistema de gerenciamento de estoque.");

        descricao1.setFont(
                new Font("Arial", Font.PLAIN, 18));

        descricao1.setBounds(170, 310, 400, 25);

        JLabel descricao2 =
                new JLabel("Cadastre produtos e categorias.");

        descricao2.setFont(
                new Font("Arial", Font.PLAIN, 18));

        descricao2.setBounds(185, 345, 400, 25);

        JLabel descricao3 =
                new JLabel("Controle entradas e saídas de estoque.");

        descricao3.setFont(
                new Font("Arial", Font.PLAIN, 18));

        descricao3.setBounds(155, 380, 450, 25);

        JLabel descricao4 =
                new JLabel("Gere relatórios gerenciais rapidamente.");

        descricao4.setFont(
                new Font("Arial", Font.PLAIN, 18));

        descricao4.setBounds(145, 415, 450, 25);

        centro.add(logo);
        centro.add(boasVindas);
        centro.add(descricao1);
        centro.add(descricao2);
        centro.add(descricao3);
        centro.add(descricao4);

        // RODAPÉ
        JLabel rodape = new JLabel(
                "Mercado do Jorge © 2026 | Sistema de Controle de Estoque | Versão 1.0",
                SwingConstants.CENTER);

        rodape.setForeground(Color.GRAY);
        rodape.setFont(new Font("Arial", Font.PLAIN, 12));

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(menu, BorderLayout.WEST);
        painelPrincipal.add(centro, BorderLayout.CENTER);
        painelPrincipal.add(rodape, BorderLayout.SOUTH);

        add(painelPrincipal);
    }
}