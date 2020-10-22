package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button sum, sub, mul, div;
    TextView tv;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.page33);
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
        setTitle("테이블 레이아웃 계산기");
//        setTitle("IT Cookbook. Android");
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//
//        LinearLayout baseLayout = new LinearLayout(this);
//        baseLayout.setOrientation(LinearLayout.VERTICAL);
//        setContentView(baseLayout,params);
//
//        Button btn = new Button(this);
//        btn.setText("버튼입니다.");
//        btn.setBackgroundColor(Color.YELLOW);
//        baseLayout.addView(btn);
//
//        TextView tv = new TextView(this);
//        tv.setText("IT Cookbook. Android");
//        tv.setTextColor(Color.GREEN);
//        tv.setTextSize(20);
//        baseLayout.addView(tv);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        sum = (Button)findViewById(R.id.sum);
        sub = (Button)findViewById(R.id.sub);
        mul = (Button)findViewById(R.id.mul);
        div = (Button)findViewById(R.id.div);
        tv = (TextView)findViewById(R.id.tv);

        sum.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tv.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });
        sub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tv.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });
        mul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tv.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });
        div.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                tv.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });

        for(i = 0 ; i<numBtnIDs.length ; i++) {
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i = 0 ; i<numBtnIDs.length ; i++) {
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (et1.isFocused() == true) {
                        num1 = et1.getText().toString() + numButtons[index].getText().toString();
                        et1.setText(num1);
                    } else if (et2.isFocused() == true) {
                        num2 = et2.getText().toString() + numButtons[index].getText().toString();
                        et2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),"텍스트에디트 선택하시오",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}