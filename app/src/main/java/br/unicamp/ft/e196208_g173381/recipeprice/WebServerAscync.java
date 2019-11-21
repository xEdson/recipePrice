package br.unicamp.ft.e196208_g173381.recipeprice;

import android.os.AsyncTask;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WebServerAscync extends AsyncTask<String, Void, String> {

    private Produto produto;
    private String tipo;
    private UnidadeMedida unidadeMedida;
    private CadastroProdutoFragment cadastroProdutoFragment;
    private CadastroReceitasFragment cadastroReceitasFragment;
    private ProdutosFragment produtosFragment;
    private ArrayList<Produto> list = new ArrayList<>();



    public WebServerAscync(Produto produto, String tipo,CadastroProdutoFragment cadastroProdutoFragment) {
        this.produto=produto;
        this.tipo = tipo;
        this.cadastroProdutoFragment = cadastroProdutoFragment;
    }

    public WebServerAscync(String tipo,ProdutosFragment produtosFragment) {
        this.tipo = tipo;
        this.produtosFragment=produtosFragment;
    }
    public WebServerAscync(String tipo,CadastroReceitasFragment cadastroReceitasFragment) {
        this.tipo = tipo;
        this.cadastroReceitasFragment=cadastroReceitasFragment;
    }


    @Override
    protected String doInBackground(String... strings) {
//        getValue(args);


        if (tipo.equals("GET")){
            getValue();

        }else{
            return setProduto();
        }

        return null;
    }

    @NotNull
    private String setProduto() {
        HttpURLConnection httpURLConnection;
        try {

        /*
          Abrindo uma conexão com o servidor
        */
            URL url = new URL("https://recipeprice-43100.firebaseio.com/Produtos/.json");

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("PATCH");

            String json = "{\"" + produto.getNome() + "\": {\"Preço\" : \"" + produto.getPreço() + "\",\"UnidadeMedida\" : \"" + produto.getUnidadeMedida() +"\"}}";


            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(json);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            /*
          Lendo a resposta do servidor
        */
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(httpURLConnection.getInputStream()));


            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            int value;
            return sb.toString();
        } catch (IOException e) {
            Log.v("Erro", e.getMessage());
            return "Exception\n" + e.getMessage();
        }
    }

    @NotNull
    private String setReceita() {
        HttpURLConnection httpURLConnection;
        try {

        /*
          Abrindo uma conexão com o servidor
        */
            URL url = new URL("https://recipeprice-43100.firebaseio.com/Receitas/.json");

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("PATCH");


            String json = "{\"" + produto.getNome() + "\": {\"Preço\" : \"" + produto.getPreço() + "\",\"UnidadeMedida\" : \"" + produto.getUnidadeMedida() +"\"}}";


            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(json);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            /*
          Lendo a resposta do servidor
        */
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(httpURLConnection.getInputStream()));


            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            int value;
            return sb.toString();
        } catch (IOException e) {
            Log.v("Erro", e.getMessage());
            return "Exception\n" + e.getMessage();
        }
    }

    @NotNull
    private String getValue() {

        HttpURLConnection httpURLConnection;
        try {

        /*
          Abrindo uma conexão com o servidor
        */
            URL url = new URL("https://recipeprice-43100.firebaseio.com/Produtos/.json");

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("GET");

            /*
          Lendo a resposta do servidor
        */
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(httpURLConnection.getInputStream()));


            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            int value;
            try {
                JSONObject obj = new JSONObject(sb.toString());
                JSONArray names = obj.names();
                JSONArray jsonArray = obj.toJSONArray(names);
                for (int i =0; i< names.length();i++){

                    list.add(new Produto(names.getString(i),UnidadeMedida.valueOf(jsonArray.getJSONObject(i).getString("UnidadeMedida")),Double.parseDouble(jsonArray.getJSONObject(i).get("Preço").toString())));
                }

            } catch (Exception e) {
            }

            return sb.toString();
        } catch (IOException e) {
            Log.v("Erro", e.getMessage());
            return "Exception\n" + e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (produtosFragment!=null){
            produtosFragment.preencher(list);
        }
        if (cadastroReceitasFragment!=null){
            cadastroReceitasFragment.preencherProduto(list);

        }
    }
}
