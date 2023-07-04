package com.example.newsapp;

import java.util.ArrayList;

public class FetchNews{
    private String status;
    private String totalResults;
    private ArrayList<APIModel> articles;

    public FetchNews(String status, String totalResults, ArrayList<APIModel> articles) {

        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<APIModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<APIModel> articles) {
        this.articles = articles;
    }
}
