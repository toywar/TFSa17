package ru.toywar.homework;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends android.support.v4.app.Fragment {

    private FragmentListener fragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FragmentListener) {
            fragmentListener = (FragmentListener) getActivity();
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        view.findViewById(R.id.buttonEnter1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = view.findViewById(R.id.textEnter1);
                if (et1 != null) {
                    Double digit = Double.valueOf(et1.getText().toString());
                    fragmentListener.firstDigit(digit);
                    fragmentListener.startFragment2();
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}