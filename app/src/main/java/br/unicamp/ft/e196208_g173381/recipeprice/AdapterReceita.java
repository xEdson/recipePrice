package br.unicamp.ft.e196208_g173381.recipeprice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdapterReceita extends RecyclerView.Adapter {

    private ArrayList<Receita> receitas;
    private MyOnItemClickListener myOnItemClickListener;

    AdapterReceita(ArrayList arrayList){
        this.receitas = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_rec_layout, viewGroup, false);

        final NewHolder holder = new AdapterReceita.NewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        Receita receita = receitas.get(i);
        System.out.println(receita);
        ((NewHolder) viewHolder).onBind(receita);

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (myOnItemClickListener != null) {
                    myOnItemClickListener.onMyItemLongClick(i);

                    return true;
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return receitas.size();
    }

    public class NewHolder extends RecyclerView.ViewHolder {

        private TextView nome;
        private ImageView imagem;

        public NewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.txtNomeReceita);
            imagem = itemView.findViewById(R.id.imagemReceita);
        }


        public void onBind(Receita receita) {
            nome.setText(receita.getNome().toUpperCase());
            imagem.setImageResource(receita.getFoto());
        }
    }

    public interface MyOnItemClickListener {
        void onMyItemLongClick(int position);
    }

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }
}
