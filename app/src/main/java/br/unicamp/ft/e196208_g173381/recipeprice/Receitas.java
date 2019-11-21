package br.unicamp.ft.e196208_g173381.recipeprice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Receitas {

    List<Ingrediente> listIngredientes = new ArrayList<>();

    public ArrayList<Receita> receitas() {

        List<Produto> listProduto = Arrays.asList(Produtos.produtos);
        List<Ingrediente> listIngredientes = new ArrayList<>();
        ArrayList<Receita> receitaList = new ArrayList<>();

        listIngredientes.add(new Ingrediente(listProduto.get(0), 240, UnidadeMedida.gr));
        listIngredientes.add(new Ingrediente(listProduto.get(1), 360, UnidadeMedida.gr));
        listIngredientes.add(new Ingrediente(listProduto.get(2), 500, UnidadeMedida.ml));
        listIngredientes.add(new Ingrediente(listProduto.get(3), 200, UnidadeMedida.gr));
        listIngredientes.add(new Ingrediente(listProduto.get(4), 3, UnidadeMedida.un));
        listIngredientes.add(new Ingrediente(listProduto.get(5), 120, UnidadeMedida.ml));
        listIngredientes.add(new Ingrediente(listProduto.get(6), 30, UnidadeMedida.gr));

        double preco = calculaPreco(listIngredientes);

        receitaList.add(new Receita("Bolo Prestigio", listIngredientes, preco, R.drawable.boloprestigio));
        receitaList.add(new Receita("Bolo Laranja", listIngredientes, preco, R.drawable.laranja));
        receitaList.add(new Receita("Bolo Chocolate", listIngredientes, preco, R.drawable.chocolate));
        receitaList.add(new Receita("Bolo Ninho", listIngredientes, preco, R.drawable.ninho));
        receitaList.add(new Receita("Bolo Cenoura", listIngredientes, preco, R.drawable.cenoura));


        return receitaList;


    }

    public Double calculaPreco(List<Ingrediente> list){
        double valor =0;


        for (Ingrediente i : list){
            valor+= (i.getProduto().getPreço()/1000)*i.getQuantidade();
        }
        return valor;
    }


}
