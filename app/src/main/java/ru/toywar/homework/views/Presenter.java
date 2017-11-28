package ru.toywar.homework.views;

import java.util.List;

import io.reactivex.disposables.Disposable;
import ru.toywar.homework.models.News;
import ru.toywar.homework.network.TFNewsConnect;

public class Presenter {

    private final TFNewsConnect tfNewsConnect;
    private final TFNewsView tfNewsView;
    private Disposable disposable;

    public Presenter(TFNewsConnect tfNewsConnect, TFNewsView tfNewsView) {
        this.tfNewsConnect = tfNewsConnect;
        this.tfNewsView = tfNewsView;
    }

    public void getNews() {
        disposable = tfNewsConnect.getNews(new TFNewsConnect.GetNewsCallback() {
            @Override
            public void onSuccess(List<News> news) {
                tfNewsView.tfNewsSuccess(news);
            }

            @Override
            public void onError(String error) {
                tfNewsView.tfNewsError(error);
            }
        });
    }
}