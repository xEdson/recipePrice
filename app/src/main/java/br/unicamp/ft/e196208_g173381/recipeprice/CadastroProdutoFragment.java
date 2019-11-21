package br.unicamp.ft.e196208_g173381.recipeprice;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroProdutoFragment extends Fragment {

    private View view;
    private Spinner mySpinner;
    private Button buttonCadastrar;
    private EditText nomeProduto;
    private EditText valorProduto;
    private String unidade;


    public CadastroProdutoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.fragment_cadastro_produto, container, false);

        }


        List<String> listUnidade = UnidadeMedida.getList();

        mySpinner = view.findViewById(R.id.spinnerUnidade);
        buttonCadastrar = view.findViewById(R.id.btnCadastrar);
        nomeProduto = view.findViewById(R.id.txtNomeProduto);
        valorProduto = view.findViewById(R.id.txtValorProduto);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, listUnidade);
        mySpinner.setAdapter(adapter);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nomeProduto.getText().toString().isEmpty() || valorProduto.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(view.getContext(), "Nome e Valor São Obrigatorios", Toast.LENGTH_SHORT);
                    toast.show();

                } else {
                    Produto produto = new Produto(nomeProduto.getText().toString(), UnidadeMedida.valueOf(mySpinner.getSelectedItem().toString()), Double.parseDouble(valorProduto.getText().toString()));
                    System.out.println(produto);
                    inserirProduto(produto);
                    Toast toast = Toast.makeText(view.getContext(), "Produto Cadastrado com sucesso", Toast.LENGTH_SHORT);
                    toast.show();

                    nomeProduto.setText("");
                    valorProduto.setText("");

                }
            }
        });

        return view;
    }

    public void inserirProduto(Produto produto) {
        new WebServerAscync(produto, "PATCH", this).execute();
    }

}
