package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Model.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

   Context context;
   List<Articles> articles;

    public Adapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
            Articles a=articles.get(position);
            holder.tvTitle.setText(a.getTitle());
            holder.tvSource.setText(a.getSource().getName());
            holder.tvDate.setText(a.getPublishedAt());

            String imageUri=a.getUrlToImage();
            Picasso.with(context).load(imageUri).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvSource,tvDate;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvtitle);
            tvSource=itemView.findViewById(R.id.tvSource);
            tvDate=itemView.findViewById(R.id.tvDate);
            imageView=itemView.findViewById(R.id.image_photo);
            cardView=itemView.findViewById(R.id.cardView);

        }
    }
}