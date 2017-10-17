package ru.toywar.homework;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment3 extends Fragment {

    private FragmentListener fragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment3, container, false);
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
        Button plusButton = view.findViewById(R.id.buttonPlus);
        Button minusButton = view.findViewById(R.id.buttonMinus);
        Button multiplyButton = view.findViewById(R.id.buttonMultiply);
        Button divideButton = view.findViewById(R.id.buttonDivide);

        plusButton.setOnClickListener(onClickListener(OperationEnum.plus));
        minusButton.setOnClickListener(onClickListener(OperationEnum.minus));
        multiplyButton.setOnClickListener(onClickListener(OperationEnum.mult));
        divideButton.setOnClickListener(onClickListener(OperationEnum.div));

        super.onViewCreated(view, savedInstanceState);
    }

    private View.OnClickListener onClickListener(final OperationEnum op) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.operation(op);
                fragmentListener.startFragment4();
            }
        };
    }
}
