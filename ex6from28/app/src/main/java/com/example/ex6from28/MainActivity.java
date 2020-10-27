package com.example.ex6from28;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.ViewFlipper;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.page34);
        setContentView(R.layout.page36);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec rabbit = tabHost.newTabSpec("dog").setIndicator("토끼");
            rabbit.setContent(R.id.rabbit);
            tabHost.addTab(rabbit);

        TabHost.TabSpec kitkat = tabHost.newTabSpec("kitkat").setIndicator("키켓");
            kitkat.setContent(R.id.kitkat);
            tabHost.addTab(kitkat);

        TabHost.TabSpec dog = tabHost.newTabSpec("dog").setIndicator("개");
            dog.setContent(R.id.dog);
            tabHost.addTab(dog);

        TabHost.TabSpec cat = tabHost.newTabSpec("cat").setIndicator("고양이");
            cat.setContent(R.id.cat);
            tabHost.addTab(cat);

//        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
//            tabSpecSong.setContent(R.id.tabSong);
//            tabHost.addTab(tabSpecSong);
//
//        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
//            tabSpecArtist.setContent(R.id.tabArtist);
//            tabHost.addTab(tabSpecArtist);
//
//        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
//            tabSpecAlbum.setContent(R.id.tabAlbum);
//            tabHost.addTab(tabSpecAlbum);
            
            // 초기 탭 설정
            tabHost.setCurrentTab(1);


//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.page29);

        /////////////
//        setContentView(R.layout.page31);
//        Button btnStart, btnStop;
//        ViewFlipper viewFlipper;
//
//        btnStart = (Button)findViewById(R.id.btnStart);
//        btnStop = (Button)findViewById(R.id.btnStop);
//        viewFlipper = (ViewFlipper)findViewById(R.id.viewFilpper);
//
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewFlipper.startFlipping();
//            }
//        });
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewFlipper.stopFlipping();
//            }
//        });
        /////////////
//        Button btnPrev, btnNext;
//        final ViewFlipper vFlipper;
//
//        btnPrev = (Button)findViewById(R.id.btnPrev);
//        btnNext = (Button)findViewById(R.id.btnNext);
//        vFlipper = (ViewFlipper)findViewById(R.id.viewFilpper1);
//
//        btnPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vFlipper.showPrevious();
//            }
//        });
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vFlipper.showNext();
//            }
//        });
    }
}