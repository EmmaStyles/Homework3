package com.infs3634.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    private TextView mTv;
    private String Tag = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        mTv = findViewById(R.id.tvQuote);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuoteService api = retrofit.create(QuoteService.class);
        Call<Quote> call = api.getQuotes();

        call.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                Log.d(Tag, "OnResponse: Success");
                Quote quote = response.body();
                mTv.setText(quote.getValue());
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                Log.d(Tag, "OnFailure: Failure");
            }
        });
    }



}
