package ru.toywar.homework.network;


import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.toywar.homework.models.News;
import ru.toywar.homework.models.TFNews;

public class TFNewsConnect {
    private final TFNewsApi tfNewsApi;

    public TFNewsConnect(TFNewsApi tfNewsApi) {
        this.tfNewsApi = tfNewsApi;
    }

    public Disposable getNews(GetNewsCallback getNewsCallback) {
        return tfNewsApi.getNews()
                .subscribeOn(Schedulers.io())
                .map(TFNews::getNews)
                .filter(news -> news != null)
                .map(news -> {
                    Collections.sort(news, (news1, t1) -> t1.getDate()
                            .get("milliseconds")
                            .compareTo(news1.getDate().get("milliseconds")));
                    return news;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        getNewsCallback::onSuccess,
                        throwable -> getNewsCallback.onError(throwable.getMessage())
                );
    }

    public interface GetNewsCallback {
        void onSuccess(List<News> news);
        void onError(String error);
    }
}