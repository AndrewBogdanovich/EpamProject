package com.andrewbogdanovich.github.epamproject.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewbogdanovich.github.epamproject.R;
import com.andrewbogdanovich.github.epamproject.activitys.CalculatorActivity;

public class LoginFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, null);
        view.findViewById(R.id.set_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CalculatorActivity)getActivity()).setLoginData();
            }
        });
        return view;
    }
}
