package ru.toywar.homework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements FragmentListener {

    private Double firstDigit;
    private Double secondDigit;
    private OperationEnum operation;

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
    public void startFragment3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Fragment3())
                .commit();
    }

    @Override
    public void startFragment4() {

        if (firstDigit != null && secondDigit != null & operation != null) {
            Bundle bundle = new Bundle();
            bundle.putDouble("firstDigit", firstDigit);
            bundle.putDouble("secondDigit", secondDigit);
            bundle.putInt("operation", operation.ordinal());

            Fragment fragment4 = new Fragment4();
            fragment4.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment4)
                    .commit();
        }
    }

    @Override
    public void firstDigit(Double dgt) {
        firstDigit = dgt;
    }

    @Override
    public void secondDigit(Double dgt) {
        secondDigit = dgt;
    }

    @Override
    public void operation(OperationEnum op) {
        operation = op;
    }
}
