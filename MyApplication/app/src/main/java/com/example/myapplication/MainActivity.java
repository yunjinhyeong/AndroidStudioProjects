package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //1번-멤버 변수
    EditText edt1, edt2;
    TextView tv1;

    //4번-이너 클래스(내부 클래스)
//    class MyOnTouchListener implements View.OnTouchListener {
//
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            int result;
//            String str1, str2;
//            int n1, n2;
//            str1 = edt1.getText().toString();
//            str2 = edt2.getText().toString();
//            n1 = Integer.parseInt(str1);
//            n2 = Integer.parseInt(str2);//문자를 -> 숫자로
//
//            result = n1 - n2;
//
//            tv1.setText("계산 결과: " + result);
//            tv1.setTextSize(20);
//            return false;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal);

//        EditText edt1, edt2;
        Button btn1, btn2, btn3, btn4;
//        TextView tv1;

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        tv1 = (TextView) findViewById(R.id.tv1);

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int result;
                String str1, str2;
                int n1, n2;
                str1 = edt1.getText().toString();
                str2 = edt2.getText().toString();
                n1 = Integer.parseInt(str1);
                n2 = Integer.parseInt(str2);//문자를 -> 숫자로

                result = n1 + n2;

                tv1.setText("계산 결과: " + result);
                tv1.setTextSize(20);

                return false;
            }
        });


        //View.OnTouchListener lis1 = new View.OnTouchListener() ;


        View.OnTouchListener listener2 = new View.OnTouchListener (){

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int result;
                String str1, str2;
                int n1, n2;
                str1 = edt1.getText().toString();
                str2 = edt2.getText().toString();
                n1 = Integer.parseInt(str1);
                n2 = Integer.parseInt(str2);//문자를 -> 숫자로

                result = n1 - n2;

                tv1.setText("계산 결과: " + result);
                tv1.setTextSize(20);
                return false;
            }
        };



        btn2.setOnTouchListener(listener2);



        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int result;
                String str1, str2;
                int n1, n2;
                str1 = edt1.getText().toString();
                str2 = edt2.getText().toString();
                n1 = Integer.parseInt(str1);
                n2 = Integer.parseInt(str2);//문자를 -> 숫자로

                result = n1 * n2;

                tv1.setText("계산 결과: " + result);
                tv1.setTextSize(20);

                return false;
            }
        });

        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int result;
                String str1, str2;
                int n1, n2;
                str1 = edt1.getText().toString();
                str2 = edt2.getText().toString();
                n1 = Integer.parseInt(str1);
                n2 = Integer.parseInt(str2);//문자를 -> 숫자로

                result = n1 / n2;

                tv1.setText("계산 결과: " + result);
                tv1.setTextSize(20);

                return false;
            }
        });

    }
}