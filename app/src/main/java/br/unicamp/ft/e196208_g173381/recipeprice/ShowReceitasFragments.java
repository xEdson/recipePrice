package br.unicamp.ft.e196208_g173381.recipeprice;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowReceitasFragments extends Fragment {

    private View view;
    private int position = 0;
    private TextView nomeReceita;
    private ImageView imagemReceita;
    private TextView receita;
    private Receitas listReceitas = new Receitas();


    public ShowReceitasFragments() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            // Inflate the layout for this fragment
            view = inflater.inflate(R.layout.fragment_show_receitas_fragments, container, false);
        }

        nomeReceita = view.findViewById(R.id.showNomeReceita);
        imagemReceita = view.findViewById(R.id.showImageReceita);
        receita = view.findViewById(R.id.showReceita);


        DecimalFormat df = new DecimalFormat("#,###.00");

        nomeReceita.setText(listReceitas.receitas().get(position).getNome());
        imagemReceita.setImageResource(listReceitas.receitas().get(position).getFoto());
        receita.setText(listReceitas.receitas().get(position).ingredientesToString(listReceitas.receitas()
                .get(position).getIngredientes())
                + "\n R$:" + df.format(listReceitas.receitas().get(position).getPrecoBruto()).toUpperCase());


        return view;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}
