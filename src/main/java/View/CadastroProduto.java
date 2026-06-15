package View;

import model.Produto;
import service.ProdutoService;
import javax.swing.JOptionPane;

public class CadastroProduto extends javax.swing.JFrame {

    private ProdutoService produtoService;

    public CadastroProduto() {
        initComponents();
        this.produtoService = new ProdutoService();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();

        setTitle("Cadastro de Produto");
        setResizable(false);

        jLabel1.setText("Nome:");
        jLabel2.setText("Preço Unitário:");
        jLabel3.setText("Unidade:");
        jLabel4.setText("Qtd. em Estoque:");
        jLabel5.setText("Qtd. Mínima:");
        jLabel6.setText("Qtd. Máxima:");
        jLabel7.setText("ID Categoria:");

        b_cadastrar.setText("Cadastrar");
        b_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        int labelW = 130;
        int fieldW = 220;

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(c_qtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_qtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_qtdMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(b_cancelar)
                        .addGap(30)
                        .addComponent(b_cadastrar)))
                .addGap(30))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1).addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2).addComponent(c_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3).addComponent(c_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4).addComponent(c_qtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5).addComponent(c_qtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6).addComponent(c_qtdMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7).addComponent(c_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar).addComponent(b_cadastrar))
                .addGap(25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (c_nome.getText().trim().length() < 2) {
                throw new Exception("Nome deve conter ao menos 2 caracteres.");
            }
            if (c_preco.getText().trim().isEmpty()) {
                throw new Exception("Informe o preço unitário.");
            }
            if (c_unidade.getText().trim().isEmpty()) {
                throw new Exception("Informe a unidade (ex: un, kg, cx).");
            }
            if (c_qtdEstoque.getText().trim().isEmpty()) {
                throw new Exception("Informe a quantidade em estoque.");
            }
            if (c_qtdMinima.getText().trim().isEmpty()) {
                throw new Exception("Informe a quantidade mínima.");
            }
            if (c_qtdMaxima.getText().trim().isEmpty()) {
                throw new Exception("Informe a quantidade máxima.");
            }
            if (c_categoria.getText().trim().isEmpty()) {
                throw new Exception("Informe o ID da categoria.");
            }

            Produto produto = new Produto(
                0,
                c_nome.getText().trim(),
                Double.parseDouble(c_preco.getText().trim().replace(",", ".")),
                c_unidade.getText().trim(),
                Integer.parseInt(c_qtdEstoque.getText().trim()),
                Integer.parseInt(c_qtdMinima.getText().trim()),
                Integer.parseInt(c_qtdMaxima.getText().trim()),
                Integer.parseInt(c_categoria.getText().trim())
            );

            produtoService.cadastrarProduto(produto);
            JOptionPane.showMessageDialog(rootPane, "Produto cadastrado com sucesso!");

            // Limpa os campos
            c_nome.setText("");
            c_preco.setText("");
            c_unidade.setText("");
            c_qtdEstoque.setText("");
            c_qtdMinima.setText("");
            c_qtdMaxima.setText("");
            c_categoria.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe um número válido nos campos numéricos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cadastrar;
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
    // End of variables declaration//GEN-END:variables
}
