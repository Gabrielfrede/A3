package View;

import dao.MovimentacaoDAO;
import dao.ProdutoDAO;
import model.Movimentacao;
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TelaMovimentacao extends JFrame {

    private JComboBox<ProdutoWrapper> cbProdutos;
    private JTextField txtQuantidade;
    private JButton btnEntrada;

    private JTable tabela;
    private DefaultTableModel tableModel;

    private ProdutoDAO produtoDAO;
    private MovimentacaoDAO movimentacaoDAO;

    public TelaMovimentacao() {
        produtoDAO = new ProdutoDAO();
        movimentacaoDAO = new MovimentacaoDAO();

        setTitle("Movimentação de Estoque");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Produto:"));
        cbProdutos = new JComboBox<>();
        panelForm.add(cbProdutos);

        panelForm.add(new JLabel("Quantidade:"));
        txtQuantidade = new JTextField();
        panelForm.add(txtQuantidade);

        btnEntrada = new JButton("Entrada");

        panelForm.add(btnEntrada);


        add(panelForm, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"ID", "Produto", "Tipo", "Quantidade", "Data"}, 0);
        tabela = new JTable(tableModel);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        btnEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEntrada();
                carregarTabela();
            }
        });


        cbProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarTabela();
            }
        });

        carregarProdutos();
        carregarTabela();
    }

    private void carregarProdutos() {
        try {
            List<Produto> produtos = produtoDAO.listarTodos();
            for (Produto p : produtos) {
                cbProdutos.addItem(new ProdutoWrapper(p));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + ex.getMessage());
        }
    }

    private void registrarEntrada() {
        try {
            ProdutoWrapper selecionado = (ProdutoWrapper) cbProdutos.getSelectedItem();
            if (selecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione um produto.");
                return;
            }

            int qtd = Integer.parseInt(txtQuantidade.getText());
            if (qtd <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
                return;
            }

            Produto produto = selecionado.getProduto();
            
            Produto pBanco = movimentacaoDAO.buscarProdutoPorId(produto.getId());
            int novoEstoque = pBanco.getQuantidadeEstoque() + qtd;

            String dataAtual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            Movimentacao mov = new Movimentacao(0, produto.getId(), dataAtual, qtd, "ENTRADA");
            
            movimentacaoDAO.registrar(mov);
            movimentacaoDAO.atualizarEstoqueProduto(produto.getId(), novoEstoque);

            JOptionPane.showMessageDialog(this, "Entrada registrada com sucesso!");
            
            txtQuantidade.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite uma quantidade válida.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco de dados: " + ex.getMessage());
        }
    }


    private void carregarTabela() {
        tableModel.setRowCount(0);
        ProdutoWrapper selecionado = (ProdutoWrapper) cbProdutos.getSelectedItem();
        
        if (selecionado == null) return;
        
        try {
            List<Movimentacao> movimentacoes = movimentacaoDAO.listarPorProduto(selecionado.getProduto().getId());
            for (Movimentacao m : movimentacoes) {
                tableModel.addRow(new Object[]{
                        m.getId(),
                        selecionado.getProduto().getNome(),
                        m.getTipoMovimentacao(),
                        m.getQuantidade(),
                        m.getDataMovimentacao()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar movimentações: " + ex.getMessage());
        }
    }

    class ProdutoWrapper {
        private Produto produto;

        public ProdutoWrapper(Produto p) {
            this.produto = p;
        }

        public Produto getProduto() {
            return produto;
        }

        @Override
        public String toString() {
            return produto.getNome();
        }
    }
}
