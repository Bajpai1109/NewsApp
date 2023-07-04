package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    Context context;
    ArrayList<APIModel> apiModelArrayList;

    public CardAdapter(Context context, ArrayList<APIModel> apiModelArrayList) {
        this.context = context;
        this.apiModelArrayList = apiModelArrayList;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url", apiModelArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        String s = apiModelArrayList.get(position).getPublishedAt();
        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(s);
        Instant i = Instant.from(ta);
        Date d = Date.from(i);


        holder.time.setText( "Published At:- "+d);
        holder.author.setText(apiModelArrayList.get(position).getAuthor());
        holder.heading.setText(apiModelArrayList.get(position).getTitle());
        holder.content.setText(apiModelArrayList.get(position).getDescription());
        Glide.with(context).load(apiModelArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return apiModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading,content,author,time;
        CardView cardView;
        ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.Heading);
            content = itemView.findViewById(R.id.Content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.createdTime);
            imageView = itemView.findViewById(R.id.newsImage);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
