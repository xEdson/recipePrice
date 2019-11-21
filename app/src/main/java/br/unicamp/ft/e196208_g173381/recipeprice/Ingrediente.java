package br.unicamp.ft.e196208_g173381.recipeprice;


public class Ingrediente {


    private Produto produto;
    private int quantidade;


    public Ingrediente(Produto produto, int quantidade, UnidadeMedida unidadeMedida) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public UnidadeMedida unidadeMedida;


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }




}
