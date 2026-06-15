package dao;

import model.Movimentacao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConexaoBanco;

public class MovimentacaoDAO {

    public void registrar(Movimentacao mov) throws SQLException {
        String sql = "INSERT INTO movimentacao (produto_id, data_movimentacao, quantidade, tipo_movimentacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, mov.getProdutoId());
            stmt.setDate(2, java.sql.Date.valueOf(mov.getDataMovimentacao()));
            stmt.setInt(3, mov.getQuantidade());
            stmt.setString(4, mov.getTipoMovimentacao());

            stmt.executeUpdate();
        }
    }

    public void atualizarEstoqueProduto(int produtoId, int novaQuantidade) throws SQLException {
        String sql = "UPDATE produto SET quantidade_estoque = ? WHERE id = ?";

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, produtoId);

            stmt.executeUpdate();
        }
    }

    public Produto buscarProdutoPorId(int produtoId) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?";
        Produto p = null;

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, produtoId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p = new Produto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getDouble("preco_unitario"),
                            rs.getString("unidade"),
                            rs.getInt("quantidade_estoque"),
                            rs.getInt("quantidade_minima"),
                            rs.getInt("quantidade_maxima"),
                            rs.getInt("id_categoria")
                    );
                }
            }
        }
        return p;
    }

    public java.util.List<Movimentacao> listarTodas() throws SQLException {
        String sql = "SELECT * FROM movimentacao ORDER BY id DESC";
        java.util.List<Movimentacao> lista = new java.util.ArrayList<>();

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Movimentacao m = new Movimentacao(
                        rs.getInt("id"),
                        rs.getInt("produto_id"),
                        rs.getDate("data_movimentacao").toLocalDate(),
                        rs.getInt("quantidade"),
                        rs.getString("tipo_movimentacao")
                );
                lista.add(m);
            }
        }
        return lista;
    }

    public java.util.List<Movimentacao> listarPorProduto(int produtoId) throws SQLException {
        String sql = "SELECT * FROM movimentacao WHERE produto_id = ? ORDER BY id DESC";
        java.util.List<Movimentacao> lista = new java.util.ArrayList<>();

        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produtoId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Movimentacao m = new Movimentacao(
                            rs.getInt("id"),
                            rs.getInt("produto_id"),
                            rs.getDate("data_movimentacao").toLocalDate(),
                            rs.getInt("quantidade"),
                            rs.getString("tipo_movimentacao")
                    );
                    lista.add(m);
                }
            }
        }
        return lista;
    }
}
