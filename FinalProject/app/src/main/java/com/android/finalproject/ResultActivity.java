package com.android.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

// 프로그램 제목 : 너의 원픽은?
// 학번: 2020111315 이름: 김동주
// 코드작성날짜 2022.12.15

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");           // 진행했던 드라마 투표 결과를 확인할 수 있다.

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

        for(int i=0; i<voteResult.length; i++) {                        // 각 드라마의 투표 결과를 확인할 수 있다.
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity.class);   // 주인공 사진보기 화면으로 넘어간다.
                startActivity(intent);

            }
        });

        Integer imageFileID[] = {R.drawable.poster1, R.drawable.poster2, R.drawable.poster3, R.drawable.poster4, R.drawable.poster5, R.drawable.poster6, R.drawable.poster7, R.drawable.poster8, R.drawable.poster9};

        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        ImageView ivResult = (ImageView) findViewById(R.id.ivResult);
        int maxEntry = 0;
        for(int i=1; i<voteResult.length; i++) {
            if(voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }                                                                    // 가장 많이 투표를 받은 드라마는
        tvResult.setText(imageName[maxEntry]);                               // 제목과 포스터가 상단에 보여진다.
        ivResult.setImageResource(imageFileID[maxEntry]);

    }
}