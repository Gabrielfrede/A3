package view;

import dao.CategoriaDAO;
import model.Categoria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.BorderLayout;
import java.util.List;

public class TelaCategoria extends JFrame {

    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public TelaCategoria() {

        setTitle("Cadastro de Categorias - Mercado do Jorge");
        setSize(850, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(null);
        painelCentro.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("CADASTRO DE CATEGORIAS");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);

        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(0, 51, 102));
        painelTopo.setPreferredSize(new Dimension(850, 80));
        painelTopo.add(titulo, BorderLayout.WEST);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(80, 30, 100, 25);
        JTextField txtId = new JTextField();
        txtId.setBounds(80, 55, 80, 30);
        txtId.setEditable(false);

        JLabel lblNome = new JLabel("Nome da Categoria:");
        lblNome.setBounds(80, 100, 200, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(80, 125, 300, 35);

        JLabel lblTamanho = new JLabel("Tamanho:");
        lblTamanho.setBounds(420, 100, 200, 25);
        JComboBox<String> cbTamanho = new JComboBox<>();
        cbTamanho.addItem("Pequeno");
        cbTamanho.addItem("Medio");
        cbTamanho.addItem("Grande");
        cbTamanho.setBounds(420, 125, 250, 35);

        JLabel lblEmbalagem = new JLabel("Embalagem:");
        lblEmbalagem.setBounds(80, 180, 200, 25);
        JComboBox<String> cbEmbalagem = new JComboBox<>();
        cbEmbalagem.addItem("Lata");
        cbEmbalagem.addItem("Vidro");
        cbEmbalagem.addItem("Plastico");
        cbEmbalagem.setBounds(80, 205, 250, 35);

        JButton btnSalvar = new JButton("SALVAR");
        JButton btnEditar = new JButton("EDITAR");
        JButton btnExcluir = new JButton("EXCLUIR");
        JButton btnLimpar = new JButton("LIMPAR");

        JButton[] botoes = {btnSalvar, btnEditar, btnExcluir, btnLimpar};

        int x = 80;
        for (JButton botao : botoes) {
            botao.setBounds(x, 280, 150, 45);
            botao.setBackground(new Color(255, 122, 0));
            botao.setForeground(Color.WHITE);
            botao.setFont(new Font("Arial", Font.BOLD, 13));
            painelCentro.add(botao);
            x += 170;
        }

        String[] colunas = {"ID", "Nome", "Tamanho", "Embalagem"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);

        JScrollPane scrollTabela = new JScrollPane(tabela);
        scrollTabela.setBounds(80, 360, 650, 180);

        Runnable carregarTabela = () -> {
            try {
                modelo.setRowCount(0);
                List<Categoria> categorias = categoriaDAO.listarTodas();

                for (Categoria c : categorias) {
                    modelo.addRow(new Object[]{
                            c.getId(),
                            c.getNome(),
                            c.getTamanho(),
                            c.getEmbalagem()
                    });
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao carregar categorias: " + ex.getMessage());
            }
        };

        btnSalvar.addActionListener(e -> {
            try {
                if (txtNome.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Informe o nome da categoria.");
                    return;
                }

                Categoria categoria = new Categoria();
                categoria.setNome(txtNome.getText());
                categoria.setTamanho(cbTamanho.getSelectedItem().toString());
                categoria.setEmbalagem(cbEmbalagem.getSelectedItem().toString());

                categoriaDAO.salvar(categoria);

                JOptionPane.showMessageDialog(this, "Categoria salva com sucesso!");
                txtNome.setText("");
                txtId.setText("");
                carregarTabela.run();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao salvar categoria: " + ex.getMessage());
            }
        });

        btnEditar.addActionListener(e -> {
            try {
                if (txtId.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Selecione uma categoria na tabela.");
                    return;
                }

                Categoria categoria = new Categoria();
                categoria.setId(Integer.parseInt(txtId.getText()));
                categoria.setNome(txtNome.getText());
                categoria.setTamanho(cbTamanho.getSelectedItem().toString());
                categoria.setEmbalagem(cbEmbalagem.getSelectedItem().toString());

                categoriaDAO.atualizar(categoria);

                JOptionPane.showMessageDialog(this, "Categoria atualizada com sucesso!");
                carregarTabela.run();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao editar categoria: " + ex.getMessage());
            }
        });

        btnExcluir.addActionListener(e -> {
            try {
                if (txtId.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Selecione uma categoria na tabela.");
                    return;
                }

                int confirmar = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja excluir esta categoria?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmar == JOptionPane.YES_OPTION) {
                    categoriaDAO.excluir(Integer.parseInt(txtId.getText()));
                    JOptionPane.showMessageDialog(this, "Categoria excluída com sucesso!");

                    txtId.setText("");
                    txtNome.setText("");
                    carregarTabela.run();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao excluir categoria: " + ex.getMessage());
            }
        });

        btnLimpar.addActionListener(e -> {
            txtId.setText("");
            txtNome.setText("");
            cbTamanho.setSelectedIndex(0);
            cbEmbalagem.setSelectedIndex(0);
            tabela.clearSelection();
        });

        tabela.getSelectionModel().addListSelectionListener(e -> {
            int linha = tabela.getSelectedRow();

            if (linha >= 0) {
                txtId.setText(tabela.getValueAt(linha, 0).toString());
                txtNome.setText(tabela.getValueAt(linha, 1).toString());
                cbTamanho.setSelectedItem(tabela.getValueAt(linha, 2).toString());
                cbEmbalagem.setSelectedItem(tabela.getValueAt(linha, 3).toString());
            }
        });

        painelCentro.add(lblId);
        painelCentro.add(txtId);
        painelCentro.add(lblNome);
        painelCentro.add(txtNome);
        painelCentro.add(lblTamanho);
        painelCentro.add(cbTamanho);
        painelCentro.add(lblEmbalagem);
        painelCentro.add(cbEmbalagem);
        painelCentro.add(scrollTabela);

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(painelCentro, BorderLayout.CENTER);

        add(painelPrincipal);

        carregarTabela.run();
    }
}