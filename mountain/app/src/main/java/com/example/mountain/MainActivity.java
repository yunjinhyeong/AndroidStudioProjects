package com.example.mountain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout baseL;
    EditText etRotation;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 여행지");
        baseL = (RelativeLayout)findViewById(R.id.baseL);
        etRotation = (EditText)findViewById(R.id.etRotation);
        imgView = (ImageView)findViewById(R.id.imgView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.imgRotation:
                imgView.setRotation(R.id.etRotation);
                return true;
            case R.id.item1:
                imgView.setImageResource(R.drawable.jeju13);
                return true;
            case R.id.item2:
                imgView.setImageResource(R.drawable.jeju1);
                return true;
            case R.id.item3:
                imgView.setImageResource(R.drawable.jeju2);
                return true;
        }

        return false;
    }
}