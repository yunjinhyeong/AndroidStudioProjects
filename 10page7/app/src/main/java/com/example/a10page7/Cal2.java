package com.example.a10page7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cal2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal2);
        setTitle("Cal2 액티비티");

        Intent inIntent = getIntent();
        String Sign = (inIntent.getStringExtra("Sign"));
        int sampleNum = 0;
        if (Sign.equals("+")) {
            sampleNum = inIntent.getIntExtra("Num1",0)
                    +inIntent.getIntExtra("Num2",0);
        } else if(Sign.equals("-")) {
            sampleNum = inIntent.getIntExtra("Num1", 0)
                    - inIntent.getIntExtra("Num2", 0);
        } else if(Sign.equals("*")) {
            sampleNum = inIntent.getIntExtra("Num1", 0)
                    * inIntent.getIntExtra("Num2", 0);
        } else if(Sign.equals("/")) {
            sampleNum = inIntent.getIntExtra("Num1", 0)
                    / inIntent.getIntExtra("Num2", 0);
        }

        final int hapValue = sampleNum;
        Intent outIntent = new Intent(getApplicationContext(), Cal.class);
        outIntent.putExtra("Hap", hapValue);
        setResult(RESULT_OK, outIntent);
        finish();
    }
}
