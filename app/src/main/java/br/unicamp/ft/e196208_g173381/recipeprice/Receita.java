package br.unicamp.ft.e196208_g173381.recipeprice;

import java.util.List;

public class Receita {

    private String nome;
    private List<Ingrediente> ingredientes;
    private double precoBruto;


    public Receita(String nome, List<Ingrediente> ingredientes, double precoBruto, int foto) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.precoBruto = precoBruto;
        this.foto = foto;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    private int foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public String ingredientesToString(List<Ingrediente> list){

        String receitaCompleta = "";

        for (Ingrediente i: list){
            receitaCompleta+= i.getProduto().getNome();
            receitaCompleta+= " "+ i.getQuantidade();
            receitaCompleta+= " "+ i.unidadeMedida;
            receitaCompleta+= "\n";
        }
        return receitaCompleta;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecoBruto() {
        return precoBruto;
    }

    public void setPrecoBruto(double precoBruto) {
        this.precoBruto = precoBruto;
    }


}


