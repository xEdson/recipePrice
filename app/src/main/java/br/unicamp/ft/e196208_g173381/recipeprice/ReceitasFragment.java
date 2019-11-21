package br.unicamp.ft.e196208_g173381.recipeprice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceitasFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private AdapterReceita adapterReceita;
    private Receitas receitas = new Receitas();


    public ReceitasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_receitas, container, false);

        }

        mRecyclerView = view.findViewById(R.id.recycle_viewReceita);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));

        adapterReceita = new AdapterReceita(new ArrayList(receitas.receitas()));

        adapterReceita.setMyOnItemClickListener(new AdapterReceita.MyOnItemClickListener() {

            @Override
            public void onMyItemLongClick(int position) {
                ((MainActivity) getActivity()).showReceita(position);
            }
        });

        mRecyclerView.setAdapter(adapterReceita);

        return view;
    }

}
