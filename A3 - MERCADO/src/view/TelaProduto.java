package view;

import javax.swing.*;
import java.awt.*;

public class TelaProduto extends JFrame {

    public TelaProduto() {

        setTitle("Cadastro de Produtos - Mercado do Jorge");
        setSize(850, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // CABEÇALHO
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(0, 51, 102));
        painelTopo.setPreferredSize(new Dimension(850, 80));

        JLabel titulo = new JLabel("CADASTRO DE PRODUTOS");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        ImageIcon logoOriginal = new ImageIcon("src/imagens/logo.png");

        Image logoRedimensionada =
                logoOriginal.getImage().getScaledInstance(
                        70,
                        70,
                        Image.SCALE_SMOOTH);

        JLabel logo = new JLabel(new ImageIcon(logoRedimensionada));

        painelTopo.add(titulo, BorderLayout.WEST);
        painelTopo.add(logo, BorderLayout.EAST);

        // CENTRO
        JPanel painelCentro = new JPanel();
        painelCentro.setBackground(new Color(245, 245, 245));
        painelCentro.setLayout(null);

        // SEÇÃO 1
        JLabel secao1 = new JLabel("DADOS DO PRODUTO");
        secao1.setFont(new Font("Arial", Font.BOLD, 16));
        secao1.setForeground(new Color(0, 51, 102));
        secao1.setBounds(80, 20, 250, 25);

        // NOME
        JLabel lblNome = new JLabel("Nome do Produto:");
        lblNome.setFont(new Font("Arial", Font.PLAIN, 13));
        lblNome.setBounds(80, 60, 200, 25);

        JTextField txtNome = new JTextField("Salame Italiano");
        txtNome.setBounds(80, 85, 650, 35);
        txtNome.setBackground(new Color(250, 250, 250));

        // CATEGORIA
        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setFont(new Font("Arial", Font.PLAIN, 13));
        lblCategoria.setBounds(80, 140, 200, 25);

        JComboBox<String> cbCategoria = new JComboBox<>();

        cbCategoria.addItem("Selecione uma categoria");
        cbCategoria.addItem("Alimentos");
        cbCategoria.addItem("Bebidas");
        cbCategoria.addItem("Limpeza");
        cbCategoria.addItem("Higiene");

        cbCategoria.setSelectedIndex(1);

        cbCategoria.setBounds(80, 165, 300, 35);

        // SEÇÃO 2
        JLabel secao2 = new JLabel("CONTROLE DE ESTOQUE");
        secao2.setFont(new Font("Arial", Font.BOLD, 16));
        secao2.setForeground(new Color(0, 51, 102));
        secao2.setBounds(80, 230, 250, 25);

        // PREÇO
        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setFont(new Font("Arial", Font.PLAIN, 13));
        lblPreco.setBounds(80, 270, 150, 25);

        JTextField txtPreco = new JTextField("15,00");
        txtPreco.setBounds(80, 295, 250, 35);
        txtPreco.setBackground(new Color(250, 250, 250));

        // QUANTIDADE
        JLabel lblQuantidade = new JLabel("Quantidade em Estoque:");
        lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 13));
        lblQuantidade.setBounds(450, 270, 200, 25);

        JTextField txtQuantidade = new JTextField("50");
        txtQuantidade.setBounds(450, 295, 250, 35);
        txtQuantidade.setBackground(new Color(250, 250, 250));

        // MÍNIMA
        JLabel lblMinima = new JLabel("Quantidade Mínima:");
        lblMinima.setFont(new Font("Arial", Font.PLAIN, 13));
        lblMinima.setBounds(80, 360, 200, 25);

        JTextField txtMinima = new JTextField("70");
        txtMinima.setBounds(80, 385, 250, 35);
        txtMinima.setBackground(new Color(250, 250, 250));

        // MÁXIMA
        JLabel lblMaxima = new JLabel("Quantidade Máxima:");
        lblMaxima.setFont(new Font("Arial", Font.PLAIN, 13));
        lblMaxima.setBounds(450, 360, 200, 25);

        JTextField txtMaxima = new JTextField("120");
        txtMaxima.setBounds(450, 385, 250, 35);
        txtMaxima.setBackground(new Color(250, 250, 250));

        JSeparator linha = new JSeparator();
        linha.setBounds(80, 440, 650, 2);

        painelCentro.add(linha);

        // BOTÕES

        JButton btnSalvar = new JButton("SALVAR");
        JButton btnEditar = new JButton("EDITAR");
        JButton btnExcluir = new JButton("EXCLUIR");
        JButton btnLimpar = new JButton("LIMPAR");

        JButton[] botoes = {
                btnSalvar,
                btnEditar,
                btnExcluir,
                btnLimpar
        };

        int x = 70;

        for (JButton botao : botoes) {

            botao.setBounds(x, 455, 150, 45);
            botao.setBackground(new Color(255, 122, 0));
            botao.setForeground(Color.WHITE);
            botao.setFont(new Font("Arial", Font.BOLD, 13));
            botao.setFocusPainted(false);
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

            painelCentro.add(botao);

            x += 180;
        }

        // ADICIONANDO COMPONENTES

        painelCentro.add(secao1);

        painelCentro.add(lblNome);
        painelCentro.add(txtNome);

        painelCentro.add(lblCategoria);
        painelCentro.add(cbCategoria);

        painelCentro.add(secao2);

        painelCentro.add(lblPreco);
        painelCentro.add(txtPreco);

        painelCentro.add(lblQuantidade);
        painelCentro.add(txtQuantidade);

        painelCentro.add(lblMinima);
        painelCentro.add(txtMinima);

        painelCentro.add(lblMaxima);
        painelCentro.add(txtMaxima);

        // RODAPÉ
        JLabel rodape = new JLabel(
                "Mercado do Jorge © 2026 | Cadastro de Produtos",
                SwingConstants.CENTER);

        rodape.setForeground(Color.GRAY);
        rodape.setFont(new Font("Arial", Font.PLAIN, 12));

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(painelCentro, BorderLayout.CENTER);
        painelPrincipal.add(rodape, BorderLayout.SOUTH);

        add(painelPrincipal);

        txtNome.requestFocus();
    }
}