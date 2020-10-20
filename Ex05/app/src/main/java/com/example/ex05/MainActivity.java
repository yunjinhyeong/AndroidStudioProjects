package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//
//        LinearLayout baseLayout = new LinearLayout(this);
//        baseLayout.setOrientation(LinearLayout.VERTICAL);
//        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0));
//        setContentView(baseLayout,params);
//
//        Button btn = new Button(this);
//        btn.setText("버튼입니다.");
//        btn.setBackgroundColor(Color.MAGENTA);
//        baseLayout.addView(btn);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"코드로 생성한 버튼입니다.",Toast.LENGTH_SHORT).show();
//            }
//        });

        setTitle("IT Cookbook. Android");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout,params);

        Button btn = new Button(this);
        btn.setText("버튼입니다.");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        TextView tv = new TextView(this);
        tv.setText("IT Cookbook. Android");
        tv.setTextColor(Color.GREEN);
        tv.setTextSize(20);
        baseLayout.addView(tv);
    }
}