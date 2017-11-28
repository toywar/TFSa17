package ru.toywar.homework.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TFNews {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("payload")
    List<News> news;

    public TFNews() {

    }

    public TFNews(String recultCode, List<News> news) {
        this.resultCode = recultCode;
        this.news = news;
    }

    public String getResultCode() {
        return resultCode;
    }

    public List<News> getNews() {
        return news;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}