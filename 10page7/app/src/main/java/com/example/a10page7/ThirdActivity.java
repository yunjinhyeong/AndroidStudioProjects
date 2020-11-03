package com.example.a10page7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.Nullable;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        final RatingBar rating1, rating2, rating3;
        Button btnInc, btnDec;

        rating1 = (RatingBar)findViewById(R.id.ratingBar1);
        rating2 = (RatingBar)findViewById(R.id.ratingBar2);
        rating3 = (RatingBar)findViewById(R.id.ratingBar3);
        btnInc = (Button)findViewById(R.id.btnInc);
        btnDec = (Button)findViewById(R.id.btnDec);

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating1.setRating(rating1.getRating()+rating1.getStepSize());
                rating2.setRating(rating2.getRating()+rating2.getStepSize());
                rating3.setRating(rating3.getRating()+rating3.getStepSize());
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating1.setRating(rating1.getRating()-rating1.getStepSize());
                rating2.setRating(rating2.getRating()-rating2.getStepSize());
                rating3.setRating(rating3.getRating()-rating3.getStepSize());
            }
        });

    }
}
