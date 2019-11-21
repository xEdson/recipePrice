package br.unicamp.ft.e196208_g173381.recipeprice;

import android.support.annotation.NonNull;

public class Produto {

    private String nome;
    private UnidadeMedida unidadeMedida;
    private double preço;


    public Produto() {

    }



    public Produto(String nome, UnidadeMedida unidadeMedida, double preço) {
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.preço = preço;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nome;
    }
}
