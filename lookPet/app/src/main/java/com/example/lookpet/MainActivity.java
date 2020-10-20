package com.example.lookpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진보기");
        TextView tv1, tv2;
        CheckBox cs;
        RadioGroup rg;
        RadioButton d, r, c;
        Button btn;
        ImageView iv;

        tv1 = (TextView)findViewById(R.id.txtStartAnswer);
        tv2 = (TextView)findViewById(R.id.txtPetAnswer);
        cs = (CheckBox)findViewById(R.id.chkStart);
        rg = (RadioGroup)findViewById(R.id.imgGroup);
        d = (RadioButton)findViewById(R.id.imgDog);
        r = (RadioButton)findViewById(R.id.imgRabit);
        c = (RadioButton)findViewById(R.id.imgCat);
        btn = (Button)findViewById(R.id.checkConfirm);
        iv = (ImageView)findViewById(R.id.imgView);

        cs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cs.isChecked()==true) {
                    tv2.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    iv.setVisibility(View.VISIBLE);
                } else {
                    tv2.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    iv.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.imgDog:
                        iv.setImageResource(R.drawable.dog);
                        break;
                    case R.id.imgCat:
                        iv.setImageResource(R.drawable.cat);
                        break;
                    case R.id.imgRabit:
                        iv.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물먼저 선택", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}