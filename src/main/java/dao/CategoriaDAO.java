package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josuc
 */
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class CategoriaDAO {

    private static final List<Categoria> categorias = new ArrayList<>();
    private static int proximoId = 1;

    public void salvar(Categoria categoria) {
        categoria.setId(proximoId);
        categorias.add(categoria);
        proximoId++;
    }

    public List<Categoria> listar() {
        return categorias;
    }

    public Categoria buscarPorId(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    public void atualizar(Categoria categoriaAtualizada) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == categoriaAtualizada.getId()) {
                categoria.setNome(categoriaAtualizada.getNome());
                categoria.setTamanho(categoriaAtualizada.getTamanho());
                categoria.setEmbalagem(categoriaAtualizada.getEmbalagem());
                break;
            }
        }
    }

    public void excluir(int id) {
        categorias.removeIf(categoria -> categoria.getId() == id);
    }
}