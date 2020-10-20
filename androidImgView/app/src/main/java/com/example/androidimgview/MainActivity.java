package com.example.androidimgview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        TextView tv1, tv2;
        Switch sw;
        RadioGroup rg;
        RadioButton ro, rp, rq;
        ImageView iv;
        Button end, restart;

        sw = (Switch)findViewById(R.id.switch1);
        tv2 = (TextView)findViewById(R.id.txtView2);
        rg = (RadioGroup)findViewById(R.id.rg);
        ro = (RadioButton)findViewById(R.id.oreo);
        rp = (RadioButton)findViewById(R.id.pie);
        rq = (RadioButton)findViewById(R.id.q);
        iv = (ImageView)findViewById(R.id.imgView);
        end = (Button)findViewById(R.id.btn1);
        restart = (Button)findViewById(R.id.btn2);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw.isChecked()==true) {
                    tv2.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    iv.setVisibility(View.VISIBLE);
                    end.setVisibility(View.VISIBLE);
                    restart.setVisibility(View.VISIBLE);
                } else {
                    tv2.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    iv.setVisibility(View.INVISIBLE);
                    end.setVisibility(View.INVISIBLE);
                    restart.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.oreo){
                    iv.setImageResource(R.drawable.oreo);
                } else if(checkedId==R.id.pie) {
                    iv.setImageResource(R.drawable.pie);
                } else if(checkedId==R.id.q) {
                    iv.setImageResource(R.drawable.q10);
                }
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restartIntent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(restartIntent);
            }
        });



    }
}