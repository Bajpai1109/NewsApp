package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Technology extends Fragment {
    String api_key="4e0801ae8e044c89b99dbe221a3c8f7d";
    ArrayList<APIModel> apiModelArrayList;
    CardAdapter cardAdapter;
    String country="in";
    private String category="technology";
    private RecyclerView recyclerViewtechnology;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.technology_feed,null);

        recyclerViewtechnology=v.findViewById(R.id.recyclerviewtechnology);
        apiModelArrayList = new ArrayList<>();
        recyclerViewtechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        cardAdapter = new CardAdapter(getContext(), apiModelArrayList);
        recyclerViewtechnology.setAdapter(cardAdapter);

        findNews();
        return v;
    }

    private void findNews() {
        APIUtilities.getApiInterface().getCategoryNews(country,category,100,api_key).enqueue(new Callback<FetchNews>() {
            @Override
            public void onResponse(Call<FetchNews> call, Response<FetchNews> response) {
                if(response.isSuccessful()){
                    apiModelArrayList.addAll(response.body().getArticles());
                    cardAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<FetchNews> call, Throwable t) {

            }
        });
    }
}

