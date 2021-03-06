package com.example.a10page7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup)findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Intent intent;
                switch (checkedId){
                    case R.id.btnFirstActivity:
                        intent = new Intent(getApplicationContext(), FirstActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnSecondActivity:
                        intent = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnThirdActivity:
                        intent = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnFourthActivity:
                        intent = new Intent(getApplicationContext(), FourthActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnFifthActivity:
                        intent = new Intent(getApplicationContext(), FifthActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnCal:
                        intent = new Intent(getApplicationContext(), Cal.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
