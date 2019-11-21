package br.unicamp.ft.e196208_g173381.recipeprice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProduto extends RecyclerView.Adapter {


    private ArrayList<Produto> produtos;

    AdapterProduto(ArrayList arrayList){
        this.produtos = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_prod_layout, viewGroup, false);
        final MyFirstNewHolder holder = new MyFirstNewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        final Produto produto = produtos.get(i);
        ((MyFirstNewHolder) viewHolder).onBind(produto);

    }

    @Override
    public int getItemCount() {

        return produtos.size();
    }


    public class MyFirstNewHolder extends RecyclerView.ViewHolder {

        private TextView nome;
        private TextView valor;

        public MyFirstNewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            valor = itemView.findViewById(R.id.valor);
        }

        public void onBind(Produto produto) {
            nome.setText(produto.getNome().toUpperCase());
            valor.setText("R$: "+String.valueOf(produto.getPreço())+" /"+produto.getUnidadeMedida());
        }
    }
}
