package service;

import dao.ProdutoDAO;
import model.Produto;
import java.sql.SQLException;
import java.util.List;

public class ProdutoService {
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void cadastrarProduto(Produto produto) throws Exception {
        validarCampos(produto);
        produtoDAO.salvar(produto);
    }

    public List<Produto> listarProdutos() throws SQLException {
        return produtoDAO.listarTodos();
    }

    public void atualizarProduto(Produto produto) throws Exception {
        validarCampos(produto);
        produtoDAO.atualizar(produto);
    }

    public void excluirProduto(int id) throws SQLException {
        produtoDAO.excluir(id);
    }

    private void validarCampos(Produto produto) throws Exception {
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new Exception("O nome do produto não pode ser vazio.");
        }
        if (produto.getPrecoUnitario() <= 0) {
            throw new Exception("O preço unitário deve ser maior que zero.");
        }
        if (produto.getQuantidadeEstoque() < 0) {
            throw new Exception("O estoque inicial não pode ser negativo.");
        }
    }

    public boolean verificarAlertaEstoqueMinimo(Produto produto, int quantidadeSaida) {
        int estoqueResultante = produto.getQuantidadeEstoque() - quantidadeSaida;
        return estoqueResultante < produto.getQuantidadeMinima();
    }

    public void reajustarPrecos(double percentual) throws SQLException {
        produtoDAO.reajustarPrecos(percentual);
    }
}