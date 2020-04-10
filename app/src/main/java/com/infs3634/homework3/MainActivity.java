package com.infs3634.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button mButton;
    public static final String EXTRA_MESSAGE = "com.infs3634.homework.MESSAGE";
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btnQuote);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                launchDetailActivity("DetailActivity");
            }
        });

    }

    private void launchDetailActivity(String message){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
