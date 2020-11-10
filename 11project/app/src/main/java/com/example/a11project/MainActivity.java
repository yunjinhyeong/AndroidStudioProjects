package com.example.a11project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                        intent = new Intent(getApplicationContext(), page7.class);
                        startActivity(intent);
                        break;
                    case R.id.btnSecondActivity:
                        intent = new Intent(getApplicationContext(), page13.class);
                        startActivity(intent);
                        break;
                    case R.id.btnThirdActivity:
                        intent = new Intent(getApplicationContext(), page22.class);
                        startActivity(intent);
                        break;
                    case R.id.btnFourthActivity:
                        intent = new Intent(getApplicationContext(), page28.class);
                        startActivity(intent);
                        break;
//                    case R.id.btnFifthActivity:
//                        intent = new Intent(getApplicationContext(), FifthActivity.class);
//                        startActivity(intent);
//                        break;
//                    case R.id.btnCal:
//                        intent = new Intent(getApplicationContext(), Cal.class);
//                        startActivity(intent);
//                        break;
                }
            }
        });
    }
}