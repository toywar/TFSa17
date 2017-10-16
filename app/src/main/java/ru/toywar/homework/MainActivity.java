package ru.toywar.homework;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements FragmentListener {

    private Double firstDigit;
    private Double secondDigit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startFragment1();

    }

    @Override
    public void startFragment1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Fragment1())
                .commit();
    }

    @Override
    public void startFragment2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Fragment2())
                .commit();
    }

    @Override
    public void firstDigit(Double dgt) {
        firstDigit = dgt;
    }

    @Override
    public void secondDigit(Double dgt) {
        secondDigit = dgt;
    }
}
