package br.unicamp.ft.e196208_g173381.recipeprice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutosFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private AdapterProduto adapterProduto;


    public ProdutosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_produtos, container, false);
        }

        mRecyclerView = view.findViewById(R.id.recycle_viewProduto);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        new WebServerAscync("GET", this).execute();


        return view;
    }

    public void preencher(ArrayList<Produto> arrayList) {
        adapterProduto = new AdapterProduto(arrayList);
        mRecyclerView.setAdapter(adapterProduto);

    }
}
