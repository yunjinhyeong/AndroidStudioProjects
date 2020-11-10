package com.example.a11project;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class page28 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page28);
        setTitle("스피너 테스트");

        final String[] movie = { "쿵푸팬더", "짱구", "아저씨", "쿵푸팬더", "짱구", "아저씨",
                "쿵푸팬더", "짱구", "아저씨", "쿵푸팬더", "짱구", "아저씨"};

        Spinner spinner = (Spinner)findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView movieView = (ImageView)findViewById(R.id.movieView);
            }
        });
    }
}
