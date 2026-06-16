package dao;

import model.Categoria;
import util.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

public void salvar(Categoria categoria) throws SQLException {

    String sql =
            "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

    try (Connection conn = ConexaoBanco.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, categoria.getNome());
        stmt.setString(2, categoria.getTamanho());
        stmt.setString(3, categoria.getEmbalagem());

        stmt.executeUpdate();
    }
}

public void atualizar(Categoria categoria) throws SQLException {

    String sql =
            "UPDATE categoria SET nome=?, tamanho=?, embalagem=? WHERE id=?";

    try (Connection conn = ConexaoBanco.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, categoria.getNome());
        stmt.setString(2, categoria.getTamanho());
        stmt.setString(3, categoria.getEmbalagem());
        stmt.setInt(4, categoria.getId());

        stmt.executeUpdate();
    }
}

public void excluir(int id) throws SQLException {

    String sql = "DELETE FROM categoria WHERE id=?";

    try (Connection conn = ConexaoBanco.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        stmt.executeUpdate();
    }
}

public List<Categoria> listarTodas() throws SQLException {

    String sql = "SELECT * FROM categoria ORDER BY nome";

    List<Categoria> lista = new ArrayList<>();

    try (Connection conn = ConexaoBanco.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            Categoria categoria = new Categoria(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("tamanho"),
                    rs.getString("embalagem")
            );

            lista.add(categoria);
        }
    }

    return lista;
}

public Categoria buscarPorId(int id) throws SQLException {

    String sql = "SELECT * FROM categoria WHERE id=?";

    try (Connection conn = ConexaoBanco.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                return new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                );
            }
        }
    }

    return null;
}
public int contarCategorias() throws SQLException {

    String sql = "SELECT COUNT(*) FROM categoria";

    try (Connection conn = ConexaoBanco.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            return rs.getInt(1);
        }
    }

    return 0;
}

}
