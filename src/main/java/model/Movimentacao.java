package model;

import java.time.LocalDate;

public class Movimentacao {

    private int id;
    private int produtoId;
    private LocalDate dataMovimentacao;
    private int quantidade;
    private String tipoMovimentacao;

    public Movimentacao() {
    }

    public Movimentacao(int id, int produtoId, LocalDate dataMovimentacao, int quantidade, String tipoMovimentacao) {
        this.id = id;
        this.produtoId = produtoId;
        this.dataMovimentacao = dataMovimentacao;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
