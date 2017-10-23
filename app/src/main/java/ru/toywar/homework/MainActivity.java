package ru.toywar.homework;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {

    private static final String TAG_FETCH_FRAGMENT = "FetchFragment";
    private FetchFragment fetchFragment;

    FetchTask ft = new FetchTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        fetchFragment = (FetchFragment) fm.findFragmentByTag(TAG_FETCH_FRAGMENT);

        if (fetchFragment == null) {
            fetchFragment = new FetchFragment();
            fm.beginTransaction()
                    .add(fetchFragment, TAG_FETCH_FRAGMENT)
                    .commit();

            try {
                String[] projects = ft.execute().get();
                if (!ft.isCancelled()) {
                    fetchFragment.setProjects(projects);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        ListView lv = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fetchFragment.getProjects());
        lv.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ft != null) {
            ft.cancel(true);
        }
    }
}
