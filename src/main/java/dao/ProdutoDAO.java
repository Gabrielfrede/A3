package dao;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // Método para Inserir no Banco (Create)
    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, preco_unitario, unidade, quantidade_estoque, quantidade_minima, quantidade_maxima, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Abre a conexão automaticamente usando a classe padrão do projeto (substitua 'ConexaoBanco' pelo nome correto do seu projeto base)
        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getUnidade());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setInt(5, produto.getQuantidadeMinima());
            stmt.setInt(6, produto.getQuantidadeMaxima());
            stmt.setInt(7, produto.getIdCategoria());

            stmt.executeUpdate();
        }
    }

    // Método para Selecionar Todos os Produtos (Read)
    public List<Produto> listarTodos() throws SQLException {
        String sql = "SELECT * FROM produto ORDER BY nome ASC"; // Traz ordenado alfabeticamente para o relatório
        List<Produto> lista = new ArrayList<>();

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("unidade"),
                        rs.getInt("quantidade_estoque"),
                        rs.getInt("quantidade_minima"),
                        rs.getInt("quantidade_maxima"),
                        rs.getInt("id_categoria")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    // Método para Alterar dados (Update)
    public void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome=?, preco_unitario=?, unidade=?, quantidade_estoque=?, quantidade_minima=?, quantidade_maxima=?, id_categoria=? WHERE id=?";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getUnidade());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setInt(5, produto.getQuantidadeMinima());
            stmt.setInt(6, produto.getQuantidadeMaxima());
            stmt.setInt(7, produto.getIdCategoria());
            stmt.setInt(8, produto.getId());

            stmt.executeUpdate();
        }
    }

    // Método para Deletar dados (Delete)
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}