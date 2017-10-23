package ru.toywar.homework;

import android.os.AsyncTask;

/**
 * Created by romek on 23.10.2017.
 */

public class FetchTask extends AsyncTask<Void, Void, String[]> {

    @Override
    protected String[] doInBackground(Void... voids) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new String[] {
                "Тинькофф.Банк", "Тинькофф.Бизнес", "Тинькофф.Инвестиции", "Тинькофф.Мобайл"
        };
    }
}
