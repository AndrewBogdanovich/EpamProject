package com.andrewbogdanovich.github.epamproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.andrewbogdanovich.github.epamproject.R;


public class LogInActivity extends AppCompatActivity {

    private Button logInBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logInBtn = (Button) findViewById(R.id.logIn_Button);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this, CalculatorActivity.class));
            }
        });


    }
}
