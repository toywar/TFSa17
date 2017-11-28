package ru.toywar.homework.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import ru.toywar.homework.R;
import ru.toywar.homework.models.News;
import ru.toywar.homework.network.TFNewsApi;
import ru.toywar.homework.network.TFNewsConnect;

public class TFNewsFragment extends Fragment implements TFNewsView{

    private Unbinder unbinder;
    private TFNewsConnect tfNewsConnect;
    private Presenter presenter;

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.news_list)
    RecyclerView recyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tfnews, container, false);
        unbinder = ButterKnife.bind(this, view);
        newsList();
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.getNews());
        tfNewsConnect = new TFNewsConnect(TFNewsApi.ConnectApi.create());
        presenter = new Presenter(tfNewsConnect, this);
        presenter.getNews();
        return view;
    }

    private void newsList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void tfNewsSuccess(List<News> news) {
        swipeRefreshLayout.setRefreshing(false);
        setNews(news);
    }

    @Override
    public void tfNewsError(String error) {
        swipeRefreshLayout.setRefreshing(false);
        setNews(new ArrayList<>());
    }

    private void setNews(List<News> news) {
        TFNewsAdapter tfNewsAdapter = new TFNewsAdapter(news);
        recyclerView.setAdapter(tfNewsAdapter);
    }
}