package View;

public class TelaPrincipal extends javax.swing.JFrame {

    private GerenciaProduto gerenciaProduto = new GerenciaProduto();

    public TelaPrincipal() {
        initComponents();
        adicionarMenuReajuste();
    }

    private void adicionarMenuReajuste() {
        javax.swing.JMenuItem menuReajuste = new javax.swing.JMenuItem("Reajustar Preços");
        menuReajuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String input = javax.swing.JOptionPane.showInputDialog(TelaPrincipal.this, "Informe o percentual de reajuste (ex: 10 para 10% ou -5 para -5%):", "Reajuste de Preços", javax.swing.JOptionPane.QUESTION_MESSAGE);
                    if (input != null && !input.trim().isEmpty()) {
                        double percentual = Double.parseDouble(input.replace(",", "."));
                        new service.ProdutoService().reajustarPrecos(percentual);
                        javax.swing.JOptionPane.showMessageDialog(TelaPrincipal.this, "Preços reajustados com sucesso!");
                    }
                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(TelaPrincipal.this, "Por favor, informe um número válido.");
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(TelaPrincipal.this, "Erro ao reajustar preços: " + e.getMessage());
                }
            }
        });
        jMenuRelatorios.add(menuReajuste);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();

        // Menu: Produtos
        jMenuProdutos = new javax.swing.JMenu();
        jMenuItemNovoProduto = new javax.swing.JMenuItem();
        jMenuItemGerenciarProdutos = new javax.swing.JMenuItem();
        jMenuItemSeparador = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();

        // Menu: Categorias (placeholder)
        jMenuCategorias = new javax.swing.JMenu();

        // Menu: Movimentação (placeholder)
        jMenuMovimentacao = new javax.swing.JMenu();

        // Menu: Relatórios (placeholder)
        jMenuRelatorios = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de Estoque");

        // --- Menu Produtos ---
        jMenuProdutos.setText("Produtos");

        jMenuItemNovoProduto.setText("Novo Produto");
        jMenuItemNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoProdutoActionPerformed(evt);
            }
        });
        jMenuProdutos.add(jMenuItemNovoProduto);

        jMenuItemGerenciarProdutos.setText("Gerenciar Produtos");
        jMenuItemGerenciarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarProdutosActionPerformed(evt);
            }
        });
        jMenuProdutos.add(jMenuItemGerenciarProdutos);

        jMenuProdutos.add(jMenuItemSeparador);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        jMenuProdutos.add(jMenuItemSair);

        jMenuBar1.add(jMenuProdutos);

        // --- Menu Categorias ---
        jMenuCategorias.setText("Categorias");
        jMenuBar1.add(jMenuCategorias);

        // --- Menu Movimentação ---
        jMenuMovimentacao.setText("Movimentação");
        jMenuBar1.add(jMenuMovimentacao);

        // --- Menu Relatórios ---
        jMenuRelatorios.setText("Relatórios");
        jMenuBar1.add(jMenuRelatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroProduto tela = new CadastroProduto();
        tela.setVisible(true);
    }

    private void jMenuItemGerenciarProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        gerenciaProduto.carregaTabela();
        gerenciaProduto.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuProdutos;
    private javax.swing.JMenu jMenuCategorias;
    private javax.swing.JMenu jMenuMovimentacao;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenuItem jMenuItemNovoProduto;
    private javax.swing.JMenuItem jMenuItemGerenciarProdutos;
    private javax.swing.JPopupMenu.Separator jMenuItemSeparador;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables
}
