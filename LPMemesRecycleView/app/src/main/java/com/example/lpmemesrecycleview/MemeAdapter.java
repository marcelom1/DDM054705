package com.example.lpmemesrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


class MemeAdapter  extends RecyclerView.Adapter<MemeAdapter.MyViewHolder> {

    Context mContext;
    int mResource;
    Meme[] mMeme;

    public MemeAdapter(Context c, int template, Meme[] meme) {
        this.mContext = c;
        this.mResource = template;
        this.mMeme = meme;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(convertView);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Meme meme = mMeme[position];

        holder.tvNome.setText(meme.getNome());
        holder.imageView.setImageResource(meme.getImagem());


    }

    @Override
    public int getItemCount() {
        return mMeme.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvNome;
        ImageView imageView;

        public MyViewHolder(@NonNull View convertView) {
            super(convertView);

            tvNome = convertView.findViewById(R.id.tvNome);
            imageView = convertView.findViewById(R.id.imageView);


        }
    }
}
