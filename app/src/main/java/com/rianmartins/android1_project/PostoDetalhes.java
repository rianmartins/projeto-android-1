package com.rianmartins.android1_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostoDetalhes extends Activity {

    ArrayList<Combustivel> arrayListCombustivel = new ArrayList<Combustivel>();
    TabelaPrecoCombustivelAdapter precoCombustivelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posto_detalhes);

        TextView nomePostoTextView = findViewById(R.id.nomePostoLabel);
        TextView enderecoPostoTextView = findViewById(R.id.enderecoPostoLabel);
        ImageView logoBandeiraPostoImageView = findViewById(R.id.logoBandeira);

        Intent intent = getIntent();
        PostoGasolina posto = (PostoGasolina) intent.getExtras().get(PostoGasolina.POSTO_INFO);

        nomePostoTextView.setText(posto.getNome());
        enderecoPostoTextView.setText(posto.getEndereco());
        logoBandeiraPostoImageView.setImageResource(posto.getBandeiraLogo());

        ListView precosCombustiveisListView = (ListView) findViewById(R.id.tabelaPrecos);
        precoCombustivelAdapter = new TabelaPrecoCombustivelAdapter(this, arrayListCombustivel);
        precosCombustiveisListView.setAdapter(precoCombustivelAdapter);

        Combustivel gasolina = new Combustivel("Gasolina", posto.getPrecoGasolina());
        Combustivel gasolinaAdv = new Combustivel("Gasolina Aditvada", posto.getPrecoGasolinaAditivada());
        Combustivel alcool = new Combustivel("Álcool", posto.getPrecoAlcool());
        Combustivel diesel = new Combustivel("Diesel", posto.getPrecoDiesel());
        Combustivel dieselS10 = new Combustivel("Diesel S10", posto.getPrecoDieselS10());

        arrayListCombustivel.add(gasolina);
        arrayListCombustivel.add(gasolinaAdv);
        arrayListCombustivel.add(alcool);
        arrayListCombustivel.add(diesel);
        arrayListCombustivel.add(dieselS10);
        precoCombustivelAdapter.notifyDataSetChanged();
    }

    public void navegacao(View v){

    }
}
