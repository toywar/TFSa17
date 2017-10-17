package ru.toywar.homework;

import static ru.toywar.homework.OperationEnum.*;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment4 extends Fragment {

    private FragmentListener fragmentListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment4, container, false);
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
        TextView tw = view.findViewById(R.id.textResult);
        Double firstDigit = getArguments().getDouble("firstDigit");
        Double secondDigit = getArguments().getDouble("secondDigit");
        OperationEnum operation = values()[getArguments().getInt("operation")];
        Double result;

        switch (operation) {
            case plus:
                result = firstDigit + secondDigit;
                break;
            case minus:
                result = firstDigit - secondDigit;
                break;
            case mult:
                result = firstDigit * secondDigit;
                break;
            case div:
                result = firstDigit / secondDigit;
                break;
            default:
                result = 0d;
                break;
        }

        tw.setText(result.toString());
        super.onViewCreated(view, savedInstanceState);
    }
}
