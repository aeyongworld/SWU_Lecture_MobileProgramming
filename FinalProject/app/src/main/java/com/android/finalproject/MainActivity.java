package com.android.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

// 프로그램 제목 : 너의 원픽은?
// 학번: 2020111315 이름: 김동주
// 코드작성날짜 2022.12.15

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        // 처음 앱을 실행하면 9개의 드라마 포스터가 뜨고, 투표를 진행할 수 있다.
        setTitle("너의 원픽은?");

        final int voteCount[] = new int[9];
        for(int i=0; i<9; i++)
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.drama01, R.id.drama02, R.id.drama03, R.id.drama04, R.id.drama05, R.id.drama06, R.id.drama07, R.id.drama08, R.id.drama09};
        final String imgName[] = {"갯마을차차차", "또오해영", "사내맞선", "스물다섯스물하나", "스토브리그", "유미의세포들", "응답하라1988", "이상한변호사우영우", "청춘시대"};

        for(int i=0; i<imageId.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override                                                     // 포스터 이미지를 누르면 해당 드라마 투표값이 카운트되며 토스트메시지로 누적된 투표값을 알 수 있다.
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총" + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);      // 버튼을 클릭했을 때 결과 화면으로 넘어가게 한다.
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });




    }
}