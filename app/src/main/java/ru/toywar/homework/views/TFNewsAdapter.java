package ru.toywar.homework.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.toywar.homework.R;
import ru.toywar.homework.models.News;

public class TFNewsAdapter extends RecyclerView.Adapter<TFNewsAdapter.NewsHolder> {

    private List<News> news;

    public TFNewsAdapter(List<News> news) {
        this.news = news;
    }

    @Override
    public TFNewsAdapter.NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        NewsHolder holder = new NewsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TFNewsAdapter.NewsHolder holder, int position) {
        holder.textView.setText(news.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public NewsHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.newsTitle);
        }
    }

}