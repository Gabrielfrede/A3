package model;

public class Movimentacao {

    private int id;
    private int produtoId;
    private String dataMovimentacao;
    private int quantidade;
    private String tipoMovimentacao;

    public Movimentacao() {
    }

    public Movimentacao(int id, int produtoId, String dataMovimentacao, int quantidade, String tipoMovimentacao) {
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

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
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
