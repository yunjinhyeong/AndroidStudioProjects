package com.example.a10page7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cal extends AppCompatActivity {
    RadioGroup rg;

    String num1, num2;
    Integer result;
    Button btnCal;
    String sign;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal);
        setTitle("계산기");

        final EditText edt1 = (EditText) findViewById(R.id.edt1);
        final EditText edt2 = (EditText) findViewById(R.id.edt2);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        btnCal = (Button) findViewById(R.id.btnCal);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Cal2.class);
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.sum:
                        intent.putExtra("Sign", "+");
                        break;
                    case R.id.sub:
                        intent.putExtra("Sign", "-");
                        break;
                    case R.id.mul:
                        intent.putExtra("Sign", "*");
                        break;
                    case R.id.div:
                        intent.putExtra("Sign", "/");
                        break;
                }
                intent.putExtra("Num1", Integer.parseInt(edt1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edt2.getText().toString()));
                startActivityForResult(intent, 0);

            }
        });
        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(),
                    "결과 :"+hap, Toast.LENGTH_SHORT).show();
        }
    }
}
