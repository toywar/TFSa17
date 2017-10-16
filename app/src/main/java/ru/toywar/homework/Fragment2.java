package ru.toywar.homework;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment2 extends android.support.v4.app.Fragment {

    private FragmentListener fragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
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
        Button button2 = view.findViewById(R.id.buttonEnter2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et2 = view.findViewById(R.id.textEnter2);
                if (et2 != null) {
                    Double digit = Double.valueOf(et2.getText().toString());
                    fragmentListener.secondDigit(digit);
                }
            }
        });
    }
}
