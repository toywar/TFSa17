package ru.toywar.homework;

import android.app.Fragment;
import android.os.Bundle;

public class FetchFragment extends Fragment {

    private String[] projects;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setProjects(String[] projects) {
        this.projects = projects;
    }

    public String[] getProjects() {
        return projects;
    }
}
