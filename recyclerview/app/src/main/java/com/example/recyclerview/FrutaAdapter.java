package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

class FrutaAdapter  extends RecyclerView.Adapter<FrutaAdapter.MyViewHolder> {

    Context mContext;
    int mResource;
    Fruta[] mfrutas;

    public FrutaAdapter(Context c, int template, Fruta[] frutas) {
        this.mContext = c;
        this.mResource = template;
        this.mfrutas = frutas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Criando View Holder(Inflar Layout)
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(convertView);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Fruta fruta = mfrutas[position];

        NumberFormat numberFormat = new DecimalFormat("#,###.00");
        holder.tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        holder.tvNome.setText(fruta.getNome());
        holder.tvPreco.setText(numberFormat.format(fruta.getPreco()));
        holder.tvPrecoVenda.setText(numberFormat.format(fruta.getPreco_venda()));

        holder.imageView.setImageResource(fruta.getImagem());


    }

    @Override
    public int getItemCount() {
        return mfrutas.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvCodigo;
        TextView tvNome;
        TextView tvPreco;
        TextView tvPrecoVenda;
        ImageView imageView;

        public MyViewHolder(@NonNull View convertView) {
            super(convertView);

            tvCodigo = convertView.findViewById(R.id.tvCodigo);
            tvNome = convertView.findViewById(R.id.tvNome);
            tvPreco = convertView.findViewById(R.id.tvPreco);
            tvPrecoVenda = convertView.findViewById(R.id.tvPrecoVenda);
            imageView = convertView.findViewById(R.id.imageView);


        }
    }

}
