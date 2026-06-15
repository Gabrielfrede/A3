package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaCategoria extends JFrame {

    public TelaCategoria() {

        setTitle("Cadastro de Categorias - Mercado do Jorge");
        setSize(850, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // CABEÇALHO
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(0, 51, 102));
        painelTopo.setPreferredSize(new Dimension(850, 80));

        JLabel titulo = new JLabel("CADASTRO DE CATEGORIAS");
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
        painelCentro.setLayout(null);
        painelCentro.setBackground(new Color(245, 245, 245));

        JLabel secao = new JLabel("DADOS DA CATEGORIA");
        secao.setFont(new Font("Arial", Font.BOLD, 16));
        secao.setForeground(new Color(0, 51, 102));
        secao.setBounds(80, 20, 250, 25);

        JLabel subtitulo = new JLabel(
                "Gerencie as categorias disponíveis no sistema.");

        subtitulo.setBounds(80, 45, 350, 20);
        subtitulo.setForeground(Color.GRAY);

        // NOME
        JLabel lblNome = new JLabel("Nome da Categoria:");
        lblNome.setBounds(80, 80, 200, 25);

        JTextField txtNome = new JTextField("Alimentos");
        txtNome.setBounds(80, 105, 650, 35);

        // DESCRIÇÃO
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(80, 155, 200, 25);

        JTextArea txtDescricao = new JTextArea(
                "Produtos alimentícios em geral."
        );

        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);

        JScrollPane scrollDescricao =
                new JScrollPane(txtDescricao);

        scrollDescricao.setBounds(80, 180, 650, 90);

        // LINHA
        JSeparator linha = new JSeparator();
        linha.setBounds(80, 290, 650, 2);

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

        int x = 80;

        for (JButton botao : botoes) {

            botao.setBounds(x, 315, 150, 45);

            botao.setBackground(new Color(255, 122, 0));
            botao.setForeground(Color.WHITE);
            botao.setFont(new Font("Arial", Font.BOLD, 13));
            botao.setFocusPainted(false);
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

            painelCentro.add(botao);

            x += 170;
        }


        // TABELA
        String[] colunas = {
                "ID",
                "Categoria",
                "Descrição"
        };

        Object[][] dados = {
                {"1", "Alimentos", "Produtos alimentícios"},
                {"2", "Bebidas", "Refrigerantes e sucos"},
                {"3", "Limpeza", "Produtos de limpeza"},
                {"4", "Higiene", "Produtos de higiene"}
        };

        DefaultTableModel modelo =
                new DefaultTableModel(dados, colunas);

        JTable tabela = new JTable(modelo);

        tabela.setRowHeight(25);

        tabela.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 13));

        JPanel painelTabela = new JPanel(new BorderLayout());

painelTabela.setBounds(80, 390, 650, 120);

painelTabela.setBorder(
        BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        new Color(0, 51, 102), 2),
                "Categorias Registradas"));

tabela.setFont(new Font("Arial", Font.PLAIN, 13));
tabela.setRowHeight(30);

tabela.setSelectionBackground(
        new Color(255, 122, 0));

tabela.setSelectionForeground(Color.WHITE);

tabela.getTableHeader().setBackground(
        new Color(0, 51, 102));

tabela.getTableHeader().setForeground(
        Color.WHITE);

tabela.getTableHeader().setFont(
        new Font("Arial", Font.BOLD, 13));

JScrollPane scrollTabela =
        new JScrollPane(tabela);

painelTabela.add(scrollTabela, BorderLayout.CENTER);

painelCentro.add(painelTabela);

        // SELECIONAR TABELA
        tabela.getSelectionModel().addListSelectionListener(e -> {

            int linhaSelecionada = tabela.getSelectedRow();

            if (linhaSelecionada >= 0) {

                txtNome.setText(
                        tabela.getValueAt(
                                linhaSelecionada,
                                1).toString());

                txtDescricao.setText(
                        tabela.getValueAt(
                                linhaSelecionada,
                                2).toString());
            }
        });

        // SALVAR
btnSalvar.addActionListener(e -> {

    if(txtNome.getText().trim().isEmpty()
            || txtDescricao.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "Preencha todos os campos!"
        );

        return;
    }

    modelo.addRow(new Object[] {
            tabela.getRowCount() + 1,
            txtNome.getText(),
            txtDescricao.getText()
    });

    JOptionPane.showMessageDialog(
            null,
            "Categoria salva com sucesso!"
    );

    txtNome.setText("");
    txtDescricao.setText("");
});

        // EDITAR
        btnEditar.addActionListener(e -> {

            int linhaSelecionada =
                    tabela.getSelectedRow();

            if (linhaSelecionada >= 0) {

                modelo.setValueAt(
                        txtNome.getText(),
                        linhaSelecionada,
                        1);

                modelo.setValueAt(
                        txtDescricao.getText(),
                        linhaSelecionada,
                        2);

                JOptionPane.showMessageDialog(
                        null,
                        "Categoria atualizada!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Selecione uma categoria."
                );
            }
        });

        // EXCLUIR
        btnExcluir.addActionListener(e -> {

            int linhaSelecionada =
                    tabela.getSelectedRow();

            if (linhaSelecionada >= 0) {

                modelo.removeRow(
                        linhaSelecionada);

                JOptionPane.showMessageDialog(
                        null,
                        "Categoria removida!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Selecione uma categoria."
                );
            }
        });

        // LIMPAR
        btnLimpar.addActionListener(e -> {

            txtNome.setText("");
            txtDescricao.setText("");
        });

        // COMPONENTES
        painelCentro.add(secao);
        painelCentro.add(subtitulo);

        painelCentro.add(lblNome);
        painelCentro.add(txtNome);

        painelCentro.add(lblDescricao);
        painelCentro.add(scrollDescricao);

        painelCentro.add(linha);


        // RODAPÉ
        JLabel rodape = new JLabel(
                "Mercado do Jorge © 2026 | Cadastro de Categorias",
                SwingConstants.CENTER);

        rodape.setForeground(Color.GRAY);
        rodape.setFont(
                new Font("Arial", Font.PLAIN, 12));

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