package ru.toywar.homework.views;

import java.util.List;

import ru.toywar.homework.models.News;

public interface TFNewsView {

    void tfNewsSuccess(List<News> news);
    void tfNewsError(String error);
}