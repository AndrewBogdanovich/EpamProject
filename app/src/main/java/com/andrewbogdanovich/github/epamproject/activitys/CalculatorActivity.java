package com.andrewbogdanovich.github.epamproject.activitys;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andrewbogdanovich.github.epamproject.R;
import com.andrewbogdanovich.github.epamproject.fragments.LoginFragment;
import com.andrewbogdanovich.github.epamproject.fragments.SuccessFragment;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener, Comparable {

    EditText input_first_field_edit_text;
    EditText input_second_field_edit_text;

    Button calculate_button;

    TextView result_text_view;

    @Override
    protected void onCreate(@Nullable Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_calculator);

        input_first_field_edit_text = (EditText) findViewById(R.id.input_first_field_edit_text);
        input_second_field_edit_text = (EditText) findViewById(R.id.input_second_field_edit_text);

        calculate_button = (Button) findViewById(R.id.calculate_button);
        result_text_view = (TextView) findViewById(R.id.result_text_view);

        calculate_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
       /* int firstArgument = 0;
        int secondArgument = 0;
        int result = 0;


        firstArgument = Integer.parseInt(input_first_field_edit_text.getText().toString());
        secondArgument = Integer.parseInt(input_second_field_edit_text.getText().toString());


        if (secondArgument != 0) {
            result = firstArgument / secondArgument;
            result_text_view.setText(firstArgument + " / " + secondArgument + " = " + result);

        } else result_text_view.setText("error");*/

        //  new EndpointsAsyncTask().execute((Runnable) new Pair<Context, String>(CalculatorActivity.this, "Manfred"));
        //  new UserListLoader().execute(CalculatorActivity.this);

        showFragment(new LoginFragment());


    }

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }


    public void setLoginData() {
        showFragment(new SuccessFragment());
    }

    public void hideSuccess() {
        showFragment(new LoginFragment());
    }
}
