package com.rianmartins.android1_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends OptionAppMenu implements PopupMenu.OnMenuItemClickListener {

    ArrayList<PostoGasolina> arrayListPostos = new ArrayList<PostoGasolina>();
    PostoGasolinaAdapter postoGasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getActionBar().setIcon(R.mipmap.gas_tank);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        if(savedInstanceState != null){
//            listTweets = (ArrayList<Tweet>)savedInstanceState.getSerializable(STATE_LIST);

        }

        ListView postosListView = (ListView) findViewById(R.id.postosGasListView);
        postoGasAdapter = new PostoGasolinaAdapter(this, arrayListPostos);
        postosListView.setAdapter(postoGasAdapter);

        // Realiza consulta para listar postos
        PostoGasolina posto1 = new PostoGasolina
                (
                    "Posto Monte Belo Augusto",
                    "Av. das Alagoas, 83 - Neopolis",
                    "3208-2352",
                    "BR",
                    R.drawable.br_logo
                );

        PostoGasolina posto2 = new PostoGasolina
                (
                    "Posto Ipiranga",
                    "Av. Ayrton Senna da principal, 3083 - Neopolis",
                    "3208-2352",
                    "Ipiranga",
                    R.drawable.ipiranga_logo
                );

        arrayListPostos.add(posto1);
        arrayListPostos.add(posto2);
        arrayListPostos.add(posto1);
        postoGasAdapter.notifyDataSetChanged();

        postosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PostoGasolina postoSelecionado = arrayListPostos.get(position);
                Intent detalhaPostoIntent = new Intent(Home.this, PostoDetalhes.class);
                detalhaPostoIntent.putExtra(PostoGasolina.POSTO_INFO, postoSelecionado);
                startActivity(detalhaPostoIntent);
            }
        });
    }

    public void showPopupMenu(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.sort_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.order_local_option:
                orderResults("local");
                return true;
            case R.id.order_price_option:
                orderResults("price");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void orderResults(String opt){
        CharSequence text;
        int duration;
        Toast toast;
        TextView orderLabel = findViewById(R.id.order_label);

        switch (opt){
            case "local":
                orderLabel.setText(R.string.local_label);
                text = "Ordenando resultados por proximidade...";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(this, text, duration);
                toast.show();
                break;
            case "price":
                orderLabel.setText(R.string.price_label);
                text = "Ordenando resultados por preço...";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(this, text, duration);
                toast.show();
                break;
            default:
                break;
        }
    }
}
