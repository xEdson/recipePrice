package br.unicamp.ft.e196208_g173381.recipeprice;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroReceitasFragment extends Fragment {

    private View view;
    private EditText nomeReceita;
    private Spinner tipoUnidade;
    private Spinner produtos;
    private EditText quantidade;
    private List<String> nomesProdutos= new ArrayList<>();
    private Button insere;
    private Button salva;
    private List<Ingrediente> ingredientes = new ArrayList<>();



    public CadastroReceitasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.fragment_cadastro_receitas, container, false);

        }

        List<String> listUnidade = UnidadeMedida.getList();
        nomeReceita = view.findViewById(R.id.txtNomeCadastroReceita);
        tipoUnidade = view.findViewById(R.id.spinnerUnidadeReceita);
        quantidade = view.findViewById(R.id.txtQuantidadeProduto);
        produtos = view.findViewById(R.id.spinnerProdutos);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, listUnidade);
        tipoUnidade.setAdapter(adapter);

        new WebServerAscync("GET", this).execute();

        insere = view.findViewById(R.id.btnAddReceita);
        salva = view.findViewById(R.id.btnSalvarReceita);

        insere.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                if (!quantidade.getText().toString().isEmpty()){
                    Ingrediente ingrediente = new Ingrediente(((Produto)produtos.getSelectedItem()), Integer.parseInt(quantidade.getText().toString()),UnidadeMedida.valueOf(tipoUnidade.getSelectedItem().toString()));
                    ingredientes.add(ingrediente);
                    Toast toast = Toast.makeText(view.getContext(), "Produto inserido á receita com sucesso", Toast.LENGTH_SHORT);
                    toast.show();
                    quantidade.setText("");
                }else{
                    Toast toast = Toast.makeText(view.getContext(), "Adicione a quantidade", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        });
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Receita receita = new Receita(nomeReceita.getText().toString(),ingredientes,2,1);
            }
        });

        return view;
     }

     public void preencherProduto(ArrayList<Produto> list){

        for (Produto produto: list){
            nomesProdutos.add(produto.getNome());
        }
         ArrayAdapter<Produto> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, list);
         produtos.setAdapter(adapter);

     }

}
