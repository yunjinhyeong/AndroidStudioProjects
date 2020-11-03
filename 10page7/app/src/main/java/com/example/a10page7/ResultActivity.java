package com.example.a10page7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4,
                R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};
        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};



        for (int i = 0 ; i<voteResult.length ; i++) {
            tv[i] = (TextView)findViewById(tvID[i]);
            rbar[i] = (RatingBar)findViewById(rbarID[i]);
        }

        for (int i = 0 ; i<voteResult.length ; i++ ) {

            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);

        }
        int bigIndex = 0;
        TextView imgName = (TextView)findViewById(R.id.imgName);
        ImageView imgView = (ImageView)findViewById(R.id.imgView);
        for (int i = 0 ; i<voteResult.length ; i++ ) {
            if(voteResult[bigIndex] < voteResult[i]){
                bigIndex=i;
            }
        }
        imgName.setText(imageName[bigIndex]);
        imgView.setImageResource(imageFileId[bigIndex]);

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
