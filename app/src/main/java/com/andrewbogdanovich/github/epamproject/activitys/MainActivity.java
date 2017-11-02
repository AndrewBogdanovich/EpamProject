package com.andrewbogdanovich.github.epamproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.andrewbogdanovich.github.epamproject.Constants;
import com.andrewbogdanovich.github.epamproject.R;
import com.andrewbogdanovich.github.epamproject.services.PlayerService;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = CalculatorActivity.class.getSimpleName();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sign_in_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LogInActivity.class));
            }
        });

        findViewById(R.id.play_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, PlayerService.class));
            }
        });
        findViewById(R.id.stop_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, PlayerService.class));
            }
        });
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        Log.w(TAG, "startActivityForResult: ");
        if (requestCode == Constants.SERVICE_RESULT) {
            Toast.makeText(this, "" + intent.getIntExtra(Constants.RESULT_KEY, 0), Toast.LENGTH_SHORT).show();
        }

        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.w(TAG, "startActivityForResult: ");
        if (requestCode == Constants.SERVICE_RESULT) {
            Toast.makeText(this, "" + data.getIntExtra(Constants.RESULT_KEY, 0), Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
