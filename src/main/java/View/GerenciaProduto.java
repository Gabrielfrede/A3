package View;

import model.Produto;
import service.ProdutoService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciaProduto extends javax.swing.JFrame {

    private ProdutoService produtoService;

    public GerenciaProduto() {
        initComponents();
        this.produtoService = new ProdutoService();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_preco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_unidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_qtdEstoque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        c_qtdMinima = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_qtdMaxima = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        c_categoria = new javax.swing.JTextField();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();

        setTitle("Gerenciamento de Produtos");
        setResizable(false);

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Nome", "Preço", "Unidade", "Estoque", "Mín.", "Máx.", "Cat." }
        ) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
            public boolean isCellEditable(int row, int col) { return canEdit[col]; }
        });
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jLabel1.setText("Nome:");
        jLabel2.setText("Preço Unitário:");
        jLabel3.setText("Unidade:");
        jLabel4.setText("Qtd. Estoque:");
        jLabel5.setText("Qtd. Mínima:");
        jLabel6.setText("Qtd. Máxima:");
        jLabel7.setText("ID Categoria:");

        b_alterar.setText("Alterar");
        b_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterarActionPerformed(evt);
            }
        });

        b_apagar.setText("Apagar");
        b_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Fechar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        int labelW = 110;
        int fieldW = 200;
        int smallW = 80;

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, labelW, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, labelW, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, labelW, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, labelW, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, labelW, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, labelW, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, labelW, Short.MAX_VALUE))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, fieldW, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_preco, javax.swing.GroupLayout.PREFERRED_SIZE, fieldW, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, fieldW, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_qtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, smallW, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_qtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, smallW, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_qtdMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, smallW, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, smallW, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(b_cancelar)
                        .addGap(20)
                        .addComponent(b_alterar)
                        .addGap(20)
                        .addComponent(b_apagar)))
                .addGap(20))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1).addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2).addComponent(c_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3).addComponent(c_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4).addComponent(c_qtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5).addComponent(c_qtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6).addComponent(c_qtdMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7).addComponent(c_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar).addComponent(b_alterar).addComponent(b_apagar))
                .addGap(20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTableProdutos.getSelectedRow();
        if (row != -1) {
            c_nome.setText(jTableProdutos.getValueAt(row, 1).toString());
            c_preco.setText(jTableProdutos.getValueAt(row, 2).toString());
            c_unidade.setText(jTableProdutos.getValueAt(row, 3).toString());
            c_qtdEstoque.setText(jTableProdutos.getValueAt(row, 4).toString());
            c_qtdMinima.setText(jTableProdutos.getValueAt(row, 5).toString());
            c_qtdMaxima.setText(jTableProdutos.getValueAt(row, 6).toString());
            c_categoria.setText(jTableProdutos.getValueAt(row, 7).toString());
        }
    }

    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (jTableProdutos.getSelectedRow() == -1) {
                throw new Exception("Selecione um produto na tabela para alterar.");
            }
            int id = Integer.parseInt(jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0).toString());

            if (c_nome.getText().trim().length() < 2) throw new Exception("Nome deve ter ao menos 2 caracteres.");
            if (c_preco.getText().trim().isEmpty()) throw new Exception("Informe o preço unitário.");
            if (c_unidade.getText().trim().isEmpty()) throw new Exception("Informe a unidade.");

            Produto produto = new Produto(
                id,
                c_nome.getText().trim(),
                Double.parseDouble(c_preco.getText().trim().replace(",", ".")),
                c_unidade.getText().trim(),
                Integer.parseInt(c_qtdEstoque.getText().trim()),
                Integer.parseInt(c_qtdMinima.getText().trim()),
                Integer.parseInt(c_qtdMaxima.getText().trim()),
                Integer.parseInt(c_categoria.getText().trim())
            );

            produtoService.atualizarProduto(produto);
            JOptionPane.showMessageDialog(rootPane, "Produto alterado com sucesso!");
            limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe um número válido nos campos numéricos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            carregaTabela();
        }
    }

    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (jTableProdutos.getSelectedRow() == -1) {
                throw new Exception("Selecione um produto na tabela para apagar.");
            }
            int id = Integer.parseInt(jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0).toString());

            int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este produto?");
            if (resposta == 0) {
                produtoService.excluirProduto(id);
                JOptionPane.showMessageDialog(rootPane, "Produto apagado com sucesso!");
                limparCampos();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao identificar o produto.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            carregaTabela();
        }
    }

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutos.getModel();
        modelo.setNumRows(0);
        try {
            List<Produto> lista = produtoService.listarProdutos();
            for (Produto p : lista) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPrecoUnitario(),
                    p.getUnidade(),
                    p.getQuantidadeEstoque(),
                    p.getQuantidadeMinima(),
                    p.getQuantidadeMaxima(),
                    p.getIdCategoria()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void limparCampos() {
        c_nome.setText("");
        c_preco.setText("");
        c_unidade.setText("");
        c_qtdEstoque.setText("");
        c_qtdMinima.setText("");
        c_qtdMaxima.setText("");
        c_categoria.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_preco;
    private javax.swing.JTextField c_unidade;
    private javax.swing.JTextField c_qtdEstoque;
    private javax.swing.JTextField c_qtdMinima;
    private javax.swing.JTextField c_qtdMaxima;
    private javax.swing.JTextField c_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    // End of variables declaration//GEN-END:variables
}
