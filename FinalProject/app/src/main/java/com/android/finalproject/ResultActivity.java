package com.android.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};


        for(int i=0; i<voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for(int i=0; i<voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Integer imageFileID[] = {R.drawable.poster1, R.drawable.poster2, R.drawable.poster3, R.drawable.poster4, R.drawable.poster5, R.drawable.poster6, R.drawable.poster7, R.drawable.poster8, R.drawable.poster9};

        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        ImageView ivResult = (ImageView) findViewById(R.id.ivResult);
        int maxEntry = 0;
        for(int i=1; i<voteResult.length; i++) {
            if(voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }
        tvResult.setText(imageName[maxEntry]);
        ivResult.setImageResource(imageFileID[maxEntry]);

    }
}