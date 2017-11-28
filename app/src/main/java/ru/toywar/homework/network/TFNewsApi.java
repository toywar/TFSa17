package ru.toywar.homework.network;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import ru.toywar.homework.models.TFNews;

public interface TFNewsApi {
    @GET("news")
    Single<TFNews> getNews();

    class ConnectApi {
        public static TFNewsApi create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.tinkoff.ru/v1/")
                    .build();

            return retrofit.create(TFNewsApi.class);
        }
    }
}