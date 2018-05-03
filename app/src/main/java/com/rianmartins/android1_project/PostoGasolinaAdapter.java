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

public class PostoGasolinaAdapter extends BaseAdapter{

    Context context;
    ArrayList<PostoGasolina> listaPostos = new ArrayList<PostoGasolina>();
    String[] data;
    private static LayoutInflater inflater = null;

    public PostoGasolinaAdapter(Context context, ArrayList<PostoGasolina> listaPostos) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.listaPostos = listaPostos;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaPostos.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listaPostos.get(position);
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
            vi = inflater.inflate(R.layout.posto_row, null);

        ImageView bandeiraLogoImageView = vi.findViewById(R.id.bandeiraLogoImg);
        TextView nomePostoTextView = vi.findViewById(R.id.headerNomePosto);
        TextView enderecoPostoTextView = vi.findViewById(R.id.bodyEndereco);
        TextView precoPrioritarioTextView = vi.findViewById(R.id.precoPrioritario);
        nomePostoTextView.setText(listaPostos.get(position).getNome());
        enderecoPostoTextView.setText(listaPostos.get(position).getEndereco());
        precoPrioritarioTextView.setText("R$ " + formatter.format(listaPostos.get(position).getCombustivelPrioritario()));
        bandeiraLogoImageView.setImageResource(listaPostos.get(position).getBandeiraLogo());

        return vi;
    }

    public ArrayList<PostoGasolina> getList() {
        return new ArrayList<PostoGasolina>(listaPostos);
    }
}
