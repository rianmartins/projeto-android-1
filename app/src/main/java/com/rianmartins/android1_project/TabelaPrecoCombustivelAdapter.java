package com.rianmartins.android1_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by rianmartins on 17/04/18.
 */

public class TabelaPrecoCombustivelAdapter extends BaseAdapter{

    Context context;
    ArrayList<Combustivel> listaCombustivel = new ArrayList<Combustivel>();
    private static LayoutInflater inflater = null;

    public TabelaPrecoCombustivelAdapter(Context context, ArrayList<Combustivel> listaCombustivel) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.listaCombustivel = listaCombustivel;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaCombustivel.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listaCombustivel.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        NumberFormat formatter = new DecimalFormat("#0,00");

        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.tabela_preco_row, null);

        TextView nomeCombustivelTextView = vi.findViewById(R.id.nomeCombustivelLabel);
        TextView precoCombustivelTextView = vi.findViewById(R.id.precoCombustivelLabel);
        nomeCombustivelTextView.setText(listaCombustivel.get(position).getNome());
        precoCombustivelTextView.setText("R$ " + formatter.format(listaCombustivel.get(position).getPreco()));

        return vi;
    }

    public ArrayList<Combustivel> getList() {
        return new ArrayList<Combustivel>(listaCombustivel);
    }
}
