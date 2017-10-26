package com.andrewbogdanovich.github.epamproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.andrewbogdanovich.github.epamproject.R;

public class MainActivity extends AppCompatActivity {

    private Button signInBtn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInBtn = (Button) findViewById(R.id.sign_in_Button);
        signInBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(new Intent(MainActivity.this, LogInActivity.class));
            }
        });
    }


}
